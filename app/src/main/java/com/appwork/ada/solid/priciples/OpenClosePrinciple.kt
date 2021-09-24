package com.appwork.ada.solid.priciples

/**
 * Created by Vivek Kumar on 11/09/21.
 * #2 Open Close Principle:
 * The principal states that classes should be OPEN for Extension but CLOSE for Modification.
 * Extend functionality by adding new code instead of changing existing code.
 * Separate the behaviours, so the system can easily extended, but never broken.
 * Never break the core of your System.
 */

/*//Basic implementation
class FieldType(
    private val input: String = "TextBox"
) {
    fun getInput(): String {
        return when (input) {
            "Text" -> {
                return "This Field used for showing text"
            }
            "EditText" -> {
                return "This field used for taking inputs"
            }
            "Radio" -> {
                return "This field used for choosing one option"
            }
            "Checkbox"->{
                return "This field used for choosing multiple options"
            }
            else -> "Nothing"
        }
    }
}*/


//Correct Way
interface FieldType {
     fun getInput(): String
}

//Type 1
class MyTextBox : FieldType {
    override fun getInput(): String {
        return "This Field used for showing text"
    }
}

//Type 2
class MyEditText : FieldType {
    override fun getInput(): String {
        return "This Field used for getting input"
    }
}

//Type 3
class MyRadioBox : FieldType {
    override fun getInput(): String {
        return "This Field used for choosing an option"
    }
}

//type 4
class MyCheckbox :FieldType{
    override fun getInput(): String {
      return  "This Field used for choosing  multiple options"
    }

}

