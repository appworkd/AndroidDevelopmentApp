package com.appwork.ada.solid.priciples

/**
 * Created by Vivek Kumar on 12/09/21.
 * A Client should never be forced to depend on methods it doesn't use.
 * A Client should never depend on  anything more than that the method it's calling
 * Changing one method shouldn't affect classes that don't depend on it.
 * Replace big Interface into small and specific interfaces.
 *
 */
class InterfaceSegregationClass {

    interface Vehicle {

        fun wheels()
        fun feature()
        fun sunRoof()
        fun steering()
    }


    class Car : Vehicle {
        override fun wheels() {
            //TODO("Not yet implemented")
        }

        override fun feature() {
            //TODO("Not yet implemented")
        }

        override fun sunRoof() {
            //TODO("Not yet implemented")
        }

        override fun steering() {
            TODO("Not yet implemented")
        }

    }

    class Bike : Vehicle {
        override fun wheels() {
            //TODO("Not yet implemented")
        }

        override fun feature() {
            // TODO("Not yet implemented")
        }

        override fun sunRoof() {
            //TODO("Not yet implemented")
        }

        override fun steering() {
            //TODO("Not yet implemented")
        }

    }

    class Scooter:Vehicle{
        override fun wheels() {
            //TODO("Not yet implemented")
        }

        override fun feature() {
            //ODO("Not yet implemented")
        }

        override fun sunRoof() {
            //TODO("Not yet implemented")
        }

        override fun steering() {
            //TODO("Not yet implemented")
        }

    }

}
