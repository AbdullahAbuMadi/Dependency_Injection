package com.abumadi.dependencyinjection

////constructor inject
//class Farm @Inject constructor(){
//}

////private const val TAG = "Farm"
//class Farm {
//    @Inject constructor() {
////        Log.d(TAG, " Abdullah Field Inject")
//    }
//    fun getBeans():String{
//        return "Beans"
//    }
//}

//class for view:not allow to edit
//private const val TAG = "Farm"

class Farm {
    //    @Inject constructor() {
//        Log.d(TAG, " Abdullah Field Inject")
//    }
    fun getBeans(): String {
        return "Beans"
    }
}