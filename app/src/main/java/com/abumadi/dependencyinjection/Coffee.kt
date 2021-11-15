package com.abumadi.dependencyinjection

import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

//Abstraction class:look at S in SOLID principles

////constructor inject
// class Coffee @Inject constructor(
//    private val farm: Farm?,
//    private val river: River?
//)
//////////////////////////////////////////////////////////////////////////
////field Inject outside constructor
//class Coffee @Inject constructor() {
//    //late init using
//    //    @Inject
//    //    lateinit var farm: Farm
//
//    //w/o late init
//    @Inject
//    @JvmField
//    var farm: Farm? = null
//
//    @Inject
//    @JvmField
//    var river: River?=null
//
//    fun getCoffeeCup(): String {
//        return "${farm!!.getBeans()}+${river!!.getWater()}"
//    }
//}
//////////////////////////////////////////////////////////////////////////
////method inject
//private const val TAG = "Coffee"
//class Coffee @Inject constructor(){
//
//    @Inject
//    @JvmField
//    var farm: Farm? = null
//
//    @Inject
//    @JvmField
//    var river: River? = null
//
//    @Inject
//    fun connectElectricity(){
//        Log.d(TAG, "Abdullah connectElectricity: Done")
//    }
//
//    fun getCoffeeCup(): String {
//        return "${farm!!.getBeans()}+${river!!.getWater()}"
//    }
//}
/////////////////////////////////////////////////////////////////////
//3 types of inject
//private const val TAG = "Coffee"
//
//class Coffee//1
//    @Inject constructor(river: River) {
//    //2
//    @Inject
//    @JvmField
//    var farm: Farm? = null
//
//    var river: River? = river
//
//    @Inject
//    fun connectElectricity() {
//        Log.d(TAG, "Abdullah method inj")
//    }
//
//    fun getCoffeeCup(): String {
//        return "${farm!!.getBeans()}+${river!!.getWater()}"
//    }
//}

//
////3 types of injection
////1 constructor
//class Coffee @Inject constructor(
//    var river: River,
//    @SUGAR var sugar: Int,
//    @MILK var milk: Int
//) {
//    //2 field
//    @Inject
//    @JvmField
//    var farm: Farm? = null
//
//    //3 method
//    @Inject
//    fun connectElectricity() {
//    }
//
//    //
//    fun getCoffeeCup(): String {
//        return "${farm!!.getBeans()}+${river.getWater()}+${"sugar:$sugar"}+${"milk spoons:$milk"}}"
//    }

//    companion object {
//        const val SUGAR = "sugar"
//        const val MILK = "milk"
//    }

//same coffee in same activity >>even if new instance but different in new activity (restart activity)
@ActivityScope
class Coffee @Inject constructor(var river: River, @SUGAR var sugar:Int, @MILK var milk:Int) {
    //2 field
    @Inject
    @JvmField
    var farm: Farm? = null

    //3 method
    @Inject
    fun connectElectricity(){
    }

    fun getCoffeeCup(): String {
        return "${farm!!.getBeans()}+${river.getWater()}+${"sugar:$sugar"}+${"milk spoons:$milk"}"
    }
//    companion object{
//        const val SUGAR="sugar"
//        const val MILK="milk"
//    }
}