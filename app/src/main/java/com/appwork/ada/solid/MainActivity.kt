package com.appwork.ada.solid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.appwork.ada.databinding.ActivityMainBinding
import com.appwork.ada.solid.priciples.MyCheckbox
import com.appwork.ada.solid.priciples.MyEditText
import com.appwork.ada.solid.priciples.MyRadioBox
import com.appwork.ada.solid.priciples.MyTextBox

class MainActivity : AppCompatActivity() {

    private val vbAct by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vbAct.root)
        vbAct.btnGetOutput.setOnClickListener {
            val textValue = when (vbAct.tvInput.text.toString()) {
                "Text" -> {
                    MyTextBox().getInput()
                }
                "EditText" -> {
                    MyEditText().getInput()
                }
                "RadioBox" -> {
                    MyRadioBox().getInput()
                }
                "Checkbox"->{
                    MyCheckbox().getInput()
                }
                else -> "Field Not Defined"
            }
            vbAct.tvOutput.text = textValue
        }
    }

}

//OOPS
/**
 * #1. Inheritance - Relation b/w classes A and B(reusing code)
 * a. How many types of relationships b/w Class(is and has)
 * b. These are tightly coupled classes.
 * c. Object creation on references.
 *
 *
 * #2. Encapsulation - Binding code and data together in single unit
 * A class with 2 things 1 is private member variables and 2 is public methods
 * Hiding data + Abstraction
 *
 * #3. Polymorphism -
 * a. Overloading - Different signature i.e same name different args
 * - We can't have same args and different return type
 * - Compile Time Polymorphism
 * b. Overriding - Dynamic Polymorphism
 *
 * #4. Abstraction - Interfaces and Abstraction
 *
 *
 */

class Main {
    private lateinit var auth: MyServerAuth
    fun saveUser(mail: String, pass: String) {
        auth.saveUser(mail, pass)
    }
}

class FirebaseAuth : Auth {
    override fun saveUser(email: String, pass: String) {
        //Firebase auth
    }
}

class MyServerAuth : Auth {
    override fun saveUser(email: String, pass: String) {
        //Server auth
    }

}

interface Auth {
    fun saveUser(email: String, pass: String)
}


class Encapsulate {
    //Class members
    private var name: String = ""
    private var age: Int = 34

    fun getName(): String {
        if (!name.isEmpty()) {
            name
        }
        return ""
    }

    fun getAge(): Int {
        return age
    }

}

class Access {
    fun getData() {
        val en = Encapsulate()

    }

}

//Inheritance
open class Animal {

    open fun walk() {
        //Do anything
    }
}

class Dog : Animal() { //Dog is Animal -isARelationShip
    override fun walk() {
        super.walk()
    }
}

class Anything {
    val animal = Animal() //hasARelationShip(Ass)

    fun doA() {

    }
}


class Demo {
    //val dog:Dog =Animal()//parent object child reference
    val animal: Animal = Dog()//child Object parent reference


    fun call() {
        //dog.walk();
        val ov = OverLoad()
        ov.getName()
        ov.getName("jgndjk")
        ov.getName(34)
    }
//    val par:Parent= Parent()//Case 1---> Execute
//    val child:Child= Child()//Case 2---> Execute
//    val par: Parent = Child()//Parent can take the reference to Child//Case 3---> Execute
//    val child: Child = Parent()//Child can take the reference to Parent//Case 4--->Wouldn't Execute
    /*fun doSomething() {
        par.walk()
    }*/
}

//#2 PolyMorphism-Many Forms
//Compile Time/Overloading/Different name or Argument
//Run Time/Overriding/SameName

class OverLoad {

    fun getName() {

    }

    fun getName(input: String): Int {
        return 0
    }


    fun getName(input: Int) {

    }
}

interface Override {
    fun getName()
}

class A : Override {
    override fun getName() {
        //Anything
        Log.i("TAG", "getName: Pribn")
    }

}

class B : Override {
    override fun getName() {
        Log.i("TAG", "getName: ${2 + 4}")
    }

}

class Helper {
    private val o = OverLoad()
    fun setName() {
        o.getName()
        o.getName("StringExample")
        o.getName(1)
    }
}
















