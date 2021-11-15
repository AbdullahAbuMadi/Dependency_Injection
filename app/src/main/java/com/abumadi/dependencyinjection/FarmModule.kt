package com.abumadi.dependencyinjection

import android.util.Log
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//private const val TAG = "CoffeeModule"
////if I want to make sugar value user input it inside constructor >> put it inside constructor here
//@Module
//open class CoffeeModule {
//    private val farm = Farm()
//
//    @Singleton
//    @Provides
//    fun provideFarm(): Farm {
////        Log.d(TAG, " Abdullah Field Inject")
//        return farm
//    }
//    //if sugar spoons value is hardcode , we can pass sugar inside component builder
//    @Provides
//    fun provideSugar(): Int {
//        return sugar
//    }


//if I want to use this w/o builder(object..) in Main Activity >>add Builder interface in Component class
@Module
open class FarmModule {
    private val farm = Farm()

    @Singleton
    @Provides
    fun provideFarm(): Farm {
        return farm
    }
}
