package com.development.twitchtopgames

import com.development.twitchtopgames.util.Util
import org.junit.Assert
import org.junit.Test

class UtilTest {

    @Test
    fun formatStringViewers_isCorrect(){
        Assert.assertEquals("10 зрителей", Util.formatStringViewers(10))
        Assert.assertEquals("10,1 тыс. зрителей", Util.formatStringViewers(10100))
        Assert.assertEquals("205 зрителей", Util.formatStringViewers(205))
        Assert.assertEquals("201 зритель", Util.formatStringViewers(201))
        Assert.assertEquals("9 тыс. зрителей", Util.formatStringViewers(9000))
    }
}