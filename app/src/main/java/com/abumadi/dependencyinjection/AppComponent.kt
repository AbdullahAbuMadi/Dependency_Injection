package com.abumadi.dependencyinjection

import dagger.Component
import dagger.Module
import javax.inject.Singleton
//dependencies
//@Singleton
//@Component(modules = [FarmModule::class])
//interface AppComponent {
//    fun getFarm():Farm
//    fun getRiver():River
//}
//subComponent
@Singleton
@Component(modules = [FarmModule::class])
interface AppComponent {
    fun getCoffeeComponentBuilder():CoffeeComponent.Builder//component.builder
}