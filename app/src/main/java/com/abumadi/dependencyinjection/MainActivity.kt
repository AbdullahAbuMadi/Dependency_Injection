package com.abumadi.dependencyinjection

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
//    //manual
//    private var farm: Farm? = null
//    private var river: River? = null

    //    //field Inject in Activities or fragments:Instance inject inside mainActivity
    @Inject
    @JvmField
    var coffee1: Coffee? = null

    //
    @Inject
    @JvmField
    var coffee2: Coffee? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        //manual
//        val coffee = Coffee(farm, river)
        //dagger generated DaggerCoffeeComponent class using my labels(constructor injection)
//        val component = DaggerCoffeeComponent.create()
//        Log.d(TAG, "Abdullah: "+component.getCoffee())

        //note:DaggerCoffeeComponent>>generated class by dagger overrides our getCoffee function
//        Log.d(TAG, "Abdullah: "+component.getCoffee().getCoffeeCup())
        //in Activities or fragment instances

        val appComponent = (application as MainApplication).getAppComponent()//to farm and river
       //dependencies
//        val coffeeComponent =
//            DaggerCoffeeComponent.builder().sugar(2).milk(4).appComponent(appComponent!!)
//                .build()//to coffee cup
        val coffeeComponent =appComponent!!.getCoffeeComponentBuilder().sugar(2).milk(4).build()
        coffeeComponent.inject(this)
//        Log.d(TAG, "Abdullah: "+coffee1!!.getCoffeeCup()+"coffee1 farm no. = ${coffee1!!.farm}")
//        Log.d(TAG, "Abdullah: "+coffee2!!.getCoffeeCup()+"coffee2 farm no. = ${coffee2!!.farm}")
////    }


//        val sugar = inputSugar.text


//        clickBtn.setOnClickListener {}

//        val component = DaggerCoffeeComponent.builder().sugar(4).build()
//        Log.d(TAG, "Abdullah: "+component.getCoffee().getCoffeeCup())
//        component.inject(this)
//        CoffeeCup.text = coffee!!.getCoffeeCup()
//            CoffeeCup.text = coffee!!.getCoffeeCup()
//        Log.d(TAG, "Abdullah: " + coffee!!.getCoffeeCup())
///////////////////////////////////////////////////////////////////////////////////////////////////
//        val component = (application as MainApplication).getAppComponent()
//        val coffeeComponent: CoffeeComponent =
//            component!!.getCoffeeComponentBuilder().milk(4).sugar(2).build()
//
//        coffeeComponent.inject(this)
//        Log.d(
//            TAG,
//            "Abdullah:" + "\n" + "coffee1 instance river:" + coffee1!!.river + "\n" + "coffee2 instance river:" + coffee2!!.river
//        )
//    }}

        Log.d(
            TAG,
            "Abdullah:" + "\n" + "coffee1:${coffee1}" + "\n" + "coffee2:${coffee2}" + "\n" + "coffee1 instance farm:" + coffee1!!.farm + "\n" + "coffee2 instance farm:" + coffee2!!.farm
        )

    }
}
/***
 * 1)Inversion of control : instead of put your dependencies inside the class with (new keyword)>>pass it as function parameter
 * this means >> controller will be from outside not inside the class.
 *
 * 2)BoilerPlateCode: repeating same code every time calling function
 * ex: new river , new beans , getCoffee(river,beans):in every time want to make cup of coffee
 * to solve this problem : use dependencies with coffee shop >>new coffeeShop,coffeeShop.getCoffeeCup.
 *
 * 3)Dependencies Acyclic Graph (DAG_ger):graph contains all dependencies of item as a tree.
 * Acyclic(one direction>>coffeeCup depends on water not vice versa)
 * DAGGER 2 : Dependencies Acyclic Graph version 2.
 *
 * Why we using DAGGER?>>1)More usability
 *                       2)No BoilerPlate code
 *                       3)Testability
 *                       4)Decoupling(there is no new word inside same class >>no nested classes)
 *                       5)Maintainability.
 *
 * 4)types of dependencies in code:
 * a- no dependencies>>get water from river then coffee from farm >> no dependencies.
 * b- manual dependencies >> buy water and coffee then prepare it.
 * c- automated dependencies >>use coffeeShop to prepare coffeeCup.
 *
 * 5)to convert manual dependencies >> to automated dependencies > we need:
 * - Acyclic graph .
 * - DAGGER_2 >>has special property on dagger1 in errors will be display.
 * by add annotations(badges)>>for item ,dependencies>>same badge,,,waiter of coffeeShop>> another badge (to make inject dependencies inside item )
 * >>>2 types of labels: dependencies labels , and creator labels.
 *
 * DAGGER 2 using annotationProcessor : dagger will write the code using labels or annotations.
 * 1)@Inject
 * 2)@Component(creator_Interface)
 * 3)@Module & @ Provides:>>use classes that I didn't element it.
 * 4)@Named,@Singleton,@SubComponent
 *
 *
 * note :dagger inject 3 things:
 * 1)constructor.>>what if I need to inject something not inside constructor>>use 2 and 3.
 * 2)field.>>inject field variables not in constructor parameters,or inside any activity and fragment>>have not be private variables
 * 3)method.>>when dagger enter any class has function with @inject will call it without call it inside my activity.
 *
 * note : there is problem with field injection >>coupling btw dagger and the class when I made field injection>> use constructor inj as you can.
 *
 * note: why we use field inject? 1-if I don't want to put dependencies in constructor.
 *                                2-if I'm using fragments and activities>>we have to inject instance of class inside act or frag
 * DAGGER_2:enter the class >>1)constructor.>>constructor inject.
 *                            2)parameters.>>field inject.>>inside class or inside activity.
 *                            3)method.>>method inject without call the method.
 *
 * all of previous >> classes that I made >> but if I need to inject dependencies from model classes (no allowance to it )>>use @Modules
 *
 * note : when I have (dependency) class I cannot write @Inject inside constructor of it >> dagger will cannot make instance of it to use in (Dependent)class
 * solve>>I will create the instance and take it to dagger to use it in dependent class>>@Module&@Provides.
 *
 *6) @Module & @Provides
 * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 * note:all of above was in hard codes_no response from outsource or user input(di happening in compile time)
 * if the dependencies from user or api response(di at run time)>> all of below
 *
 * DaggerCoffeeComponent.builder().coffeeModule(object:CoffeeModule(2){}).build()
 *
 * coffeeModule(object:CoffeeModule(2){})>>function dagger create it to input my values
 * note:When I provide Int inside Module >>it provides Int Not provides Sugar >>what if I have more than one Int values?&not every value I want to add I will modified the Module??
 * note: If I want to make sugar = 3 in all of application after user input it or If I don't need to create new instance every time I want to add sugar value>> modification builder
 *  solve>>use 3 new @ :@Component.builder >>to create my builder
 *                     @BindInstance >>to be one of dependencies u have to use it
 *                     @Named >>more than one variable from same type
 *                     note: if I have big project @Named("string") will be confusing>>use companion object or custom @Named
 *
 * note: coffee instance that dagger created in Main Activity will loss it after change of screen orientation.
 * to solve this problem we need to make single instance >> by dagger scopes....scope is like >>Global var init(can use with all class) and local var init(can use in same function).
 * if I have some instance I need it in Application Context(like retrofit instance or something else..)>>General scope
 * if I have>>login>>items>>payment>>profile >>inside Application>>>>this will be inside 4 activities <for ex..> >>user scope
 * >>there is many scope types (depend on my situation)
 *
 * Scopes:
 * a)General scope.>>use instance in hall Application.>>put val component = DaggerCoffeeComponent.builder().sugar(4).milk(5).build()
component.inject(this) >>inside Class extends Application class (don't forget mod in manifest (name:MainApplication) )
 * b)Custom scope. >>custom case(not in hall Application).
 *
 * note: river and farm instances have to be one instance in hall application .
 * note:if the class read only >>go to module >>put @singleton above @provides
 * note:I need single coffee for each single Activity >> when rotate screen I need new coffee for new Activity
 *
 * Note: MainApplication make coffee component:farm+coffee >>I need to separate it >>component for farm (Global)>>component for coffee(just inside Activity)
 * >>but now CoffeeComponent will depend on App Component >>subComponent or dependency(make custom singleton annotation)
 *
 */
