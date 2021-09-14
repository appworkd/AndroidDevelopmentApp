package com.appwork.ada.solid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.appwork.ada.databinding.ActivityMainBinding
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
                else -> "Field Not Defined"
            }
            vbAct.tvOutput.text = textValue
        }
    }

}

//Inheritance
open class Parent {

    open fun walk() {
        //Do anything
    }
}

class Child : Parent() {
    override fun walk() {
        super.walk()
    }
}


class Demo {

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

    fun getName(input: String) {

    }

    fun getName(input: Int) {

    }
}

interface Override{
    fun getName()
}

class A:Override{
    override fun getName() {
        //Anything
        Log.i("TAG", "getName: Pribn")
    }

}

class B:Override{
    override fun getName() {
        Log.i("TAG", "getName: ${2+4}")
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
















