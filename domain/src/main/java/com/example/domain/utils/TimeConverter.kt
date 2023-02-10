package com.example.domain.utils

import java.util.*

object TimeConverter {

    fun convertUNIXtoHoursAgo(timeStamp: Long): String {

        val publishingTime = Date(timeStamp * 1000)

        val currentTime = Date()

        val diff: Long = publishingTime.time - currentTime.time
        val seconds = diff / 1000
        val minutes = seconds / 60
        val hours = minutes / 60

        val diffHours = changeNegativeToPositiveNumber(hours.toInt())
        var diffMinutes: Int?

        var result: String

        if (diffHours == 0) {
            diffMinutes = changeNegativeToPositiveNumber(minutes.toInt())

            result =
                if (diffMinutes == 0) " now"
                else
                    diffMinutes.toString() +
                            if (diffMinutes % 10 == 1) " minute age"
                            else " minutes ago"
        } else {
            result =
                diffHours.toString() +
                            if (diffHours % 10 == 1) " hour age"
                            else " hours ago"
        }


        return result
    }

    private fun changeNegativeToPositiveNumber(negative: Int): Int {
        return -1 * negative
    }

}