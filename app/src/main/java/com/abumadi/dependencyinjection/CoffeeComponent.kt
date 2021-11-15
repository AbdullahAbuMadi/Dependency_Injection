package com.abumadi.dependencyinjection

import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Named
import javax.inject.Singleton

////if I have more than one module[first::class, second::class]
////dependencies
//@ActivityScope
//@Component(dependencies = [AppComponent::class])
//interface CoffeeComponent {
//
//    fun getCoffee():Coffee
////    //field Inject in Activities or fragments
//    fun inject(mainActivity: MainActivity)
////to know this is component builder not any else>>@Component.Builder
//    @Component.Builder
//    interface Builder{
//
//        fun build():CoffeeComponent
//        @BindsInstance//is one of dependencies u have to use it
//        fun sugar(@SUGAR sugar :Int):Builder
//        @BindsInstance
//        fun milk(@MILK milk :Int):Builder
//        //dependency appComponent
//        fun appComponent(appComponent: AppComponent):Builder
//
//    }
//}
//dependencies
@ActivityScope
@Subcomponent
interface CoffeeComponent {

    fun getCoffee():Coffee
    //    //field Inject in Activities or fragments
    fun inject(mainActivity: MainActivity)
    //to know this is component builder not any else>>@Component.Builder
    @Subcomponent.Builder
    interface Builder{

        fun build():CoffeeComponent
        @BindsInstance//is one of dependencies u have to use it
        fun sugar(@SUGAR sugar :Int):Builder
        @BindsInstance
        fun milk(@MILK milk :Int):Builder

    }
}