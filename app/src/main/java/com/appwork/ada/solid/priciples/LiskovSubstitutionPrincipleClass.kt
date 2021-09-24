package com.appwork.ada.solid.priciples

import android.util.Log

/**
 * Created by Vivek Kumar on 11/09/21.
 * #3 Liskov Substitution Principle:
 * This states that Any Parent CLass can be REPLACED by it's Subclass.
 * Every Class that implements an Interface, must be able to substitute any reference throughout the code that implements that same Interface.
 */
class LiskovSubstitutionPrincipleClass {
    companion object {
        const val TAG = "Liskov"
    }

    //SubType
    interface WhatsApp : Applications {
        override fun haveUi() {
            Log.i(TAG, "haveUi: true")
        }

        override fun haveFeature() {
            Log.i(TAG, "haveFeature: true")
        }

        override fun packageId() {
            Log.i(TAG, "packageId: 1234546")
        }

    }

    interface Signal : WhatsApp {
        override fun haveUi() {
            Log.i(TAG, "haveUi: true")
        }

        override fun haveFeature() {
            Log.i(TAG, "haveFeature: true")
        }

        override fun packageId() {
            Log.i(TAG, "packageId: 1234546")
        }

    }

}

/**
 *
 */
interface Animal {
    fun eat()
    fun run()
    fun breed()

}

class Dog : Animal {
    override fun eat() {

    }

    override fun run() {

    }

    override fun breed() {

    }


}


/**
 * Parent Interface
 */
interface Applications {
    //Any language like Java,Kotlin,JS, etc
    fun haveUi()

    //Like chat ,Live streaming,location tracking
    fun haveFeature()

    //Unique for registration on play store
    fun packageId()
}