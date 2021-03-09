package com.quantum.vpn.utils

import com.quantum.vpn.ui.listener.DateValidator
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * Created by Meenu Singh on 09/03/2021.
 */
class DateValidatorUsingDateFormat constructor(var dateFormat: String) : DateValidator {

    override fun isValid(dateStr: String): Boolean {
        val sdf: DateFormat = SimpleDateFormat(dateFormat)
        sdf.isLenient = false
        try {
            sdf.parse(dateStr)
        } catch (e: ParseException) {
            return false
        }
        return true
    }
}