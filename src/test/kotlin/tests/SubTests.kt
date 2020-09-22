package tests

import TestGroups
import org.testng.Assert
import org.testng.annotations.Test
import utils.Logging

@Test(groups = [TestGroups.ALL])
class SubTests {
    @Test(groups=[TestGroups.SHOULD_FAIL])
    fun subTwoNumbers() {
        Logging.log("Checking if the diff between 5 and 2 is 2 (should fail)")
        Assert.assertEquals(5 - 2, 2)
    }

    @Test(groups=[TestGroups.SHOULD_PASS])
    fun subAnotherTwoNumbers() {
        Assert.assertEquals(2 - 5, -3)
    }

    @Test(groups=[TestGroups.SHOULD_FAIL])
    fun subYetAnotherTwoNumbers() {
        Assert.assertEquals(10 - 4, 5)
    }
}