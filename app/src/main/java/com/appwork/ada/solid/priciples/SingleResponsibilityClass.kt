package com.appwork.ada.solid.priciples

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Vivek Kumar on 12/09/21.
 */
/**
 * #1 Single Responsibility:
 * A class should be responsible for  one thing only
 * There's place for everything and everything is in  its place.
 * Names for classes should be precise
 * Say we have a class doing some IO operations then it should have only operations related to IO operations only.
 */
class SingleResponsibilityClass {
    /**
     *  #1Date
     */
    class DateUtil {
        /**
         * This method will take string date as input and return a date string
         */
        fun getDateFromString(
            dateString: String = "12/08/2021",
            requiredFormat: String = "dd/MM/yyyy",
            locale: Locale = Locale.getDefault()
        ): Date? {
            return SimpleDateFormat(
                requiredFormat,
                locale
            ).parse(dateString)
        }

        /**
         * This method will take millis as input and return a date string
         */
        fun getDateStringFromMillis(
            millis: Long = Calendar.getInstance().timeInMillis,
            requiredFormat: String = "dd/MM/yyyy",
            locale: Locale = Locale.getDefault()
        ) {
            val tempDate = Date(millis)
            val formatter = SimpleDateFormat(requiredFormat, locale)
            formatter.format(tempDate)
        }
    }



}