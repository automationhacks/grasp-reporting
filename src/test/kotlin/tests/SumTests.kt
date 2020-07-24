package tests

import TestGroups
import org.testng.Assert
import org.testng.annotations.Test

@Test(groups = [TestGroups.ALL])
class SumTests {
    @Test(groups=[TestGroups.SHOULD_FAIL])
    fun addTwoNumbers() {
        Assert.assertEquals(2 + 2, 3)
    }

    @Test(groups=[TestGroups.SHOULD_PASS])
    fun addAnotherTwoNumbers() {
        Assert.assertEquals(2 + 5, 7)
    }

    @Test(groups=[TestGroups.SHOULD_FAIL])
    fun addYetAnotherTwoNumbers() {
        Assert.assertEquals(2 + 4, 5)
    }
}