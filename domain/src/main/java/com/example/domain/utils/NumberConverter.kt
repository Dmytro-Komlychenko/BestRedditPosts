package com.example.domain.utils

object NumberConverter {

    fun convertNumberToShortFormat(number: Int): String {
        var strNumber = number.toString()
        return when (strNumber.count()) {
            7 -> strNumber.substring(0, 1) + "M " + strNumber.substring(1, 4)
            6 -> strNumber.substring(0, 3) + "k"
            5 -> strNumber.substring(0, 2) + "k"
            4 -> strNumber.substring(0, 1) + "k"
            else -> strNumber
        }
    }
}