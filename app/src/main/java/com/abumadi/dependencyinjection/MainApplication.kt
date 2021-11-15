package com.abumadi.dependencyinjection

import android.app.Application
//it was provides farm+coffee >> we need it to farm only >>coffee has another component
class MainApplication : Application() {

    private var appComponent: AppComponent? = null

    override fun onCreate() {//anything happens here will be one time >>just when Application fires
        appComponent = DaggerAppComponent.create()
        super.onCreate()
    }

    fun getAppComponent(): AppComponent? {
        return appComponent
    }

}