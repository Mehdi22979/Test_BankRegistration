package com.quantum.vpn.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

object AppUtils {

    fun isPanCardValid(pan_number: String): Boolean {
        val pattern: Pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}")
        val matcher: Matcher = pattern.matcher(pan_number)
        // Check if pattern matches
        return matcher.matches()
    }
}