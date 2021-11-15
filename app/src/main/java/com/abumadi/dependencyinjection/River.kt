package com.abumadi.dependencyinjection

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

////constructor inject
//class River
//@Inject constructor() {
//}
//field Inject outside constructor
//private const val TAG = "River"
////@ActivityScope//to make River instance Global
@Singleton
class River {
        @Inject constructor(){
//        Log.d(TAG, " Abdullah Constructor Inject")
    }
    fun getWater(): String {
        return "Water"
    }
}
//}