import org.testng.Assert
import org.testng.annotations.Test

@Test(groups = [TestGroups.ALL])
class SubTests {
    @Test(groups=[TestGroups.SHOULD_FAIL])
    fun subTwoNumbers() {
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