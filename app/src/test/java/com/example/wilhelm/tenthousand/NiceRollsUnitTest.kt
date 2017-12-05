package com.example.wilhelm.tenthousand

import BusinessLogic.AllPairs
import BusinessLogic.OfAKind
import BusinessLogic.OnesAndFives
import BusinessLogic.Royal
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class OfAKindUnitTest {
    @Test
    fun evaluate_singleThreeOfAKind_returnsCorrect() {
        var _uut = OfAKind()
        assertEquals(1300, _uut.evaluate(intArrayOf(10,10,3,3, 3, 10)))
    }
}

class OnesAndFivesUnitTest {
    @Test
    fun evaluate_three10sAndThree5s_returns450() {
        var _uut = OnesAndFives()
        assertEquals(450, _uut.evaluate(intArrayOf(10,10,5,5, 5, 10)))
    }
}

class RoyalUnitTest {
    @Test
    fun evaluate_fullRoyal_returns1000() {
        var _uut = Royal()
        assertEquals(1000, _uut.evaluate(intArrayOf(1,2,3,4,5,6)))
    }

    @Test
    fun evaluate_NotRoyal_returns0() {
        var _uut = Royal()
        assertEquals(0, _uut.evaluate(intArrayOf(1,2,3,4, 5, 5)))
    }
}

class AllPairsUnitTest {
    @Test
    fun evaluate_AllPairs_returns1000() {
        var _uut = AllPairs()
        assertEquals(1000, _uut.evaluate(intArrayOf(1,1,3,3,6,6)))
    }

    @Test
    fun evaluate_NotAllPairs_returns0() {
        var _uut = AllPairs()
        assertEquals(0, _uut.evaluate(intArrayOf(1,1,3,3, 4, 5)))
    }
}
