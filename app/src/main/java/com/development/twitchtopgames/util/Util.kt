package com.development.twitchtopgames.util

import java.text.DecimalFormat

object Util {

    //TODO Привести к одному виду
    fun formatStringViewers(viewers: Int): String {
        var shortString = viewers.toString()
        if (viewers / 1000 > 1) {
            shortString = DecimalFormat("#.#").format(viewers.toFloat() / 1000) + " тыс."
        }
        return "$shortString ${getViewerAddiction(viewers)}"
    }

    fun formatStringChannels(count: Int): String {
        var shortString = count.toString()
        if (count / 1000 > 1) {
            shortString = DecimalFormat("#.#").format(count.toFloat() / 1000) + " тыс."
        }
        return "$shortString ${getChannelAddiction(count)}"
    }

    fun getChannelAddiction(count: Int): String {
        val preLastDigit = count % 100 / 10
        if (preLastDigit == 1) return "каналов"
        return when (count % 10) {
            1 -> "канал"
            else -> "каналов"
        }
    }

    fun getViewerAddiction(count: Int): String {
        val preLastDigit = count % 100 / 10
        if (preLastDigit == 1) return "зрителей"
        return when (count % 10) {
            1 -> "зритель"
            else -> "зрителей"
        }
    }
}