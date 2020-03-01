import org.testng.Assert
import org.testng.annotations.Test

class CalculatorTests {
    @Test
    fun addTwoNumbers() {
        Assert.assertEquals(2 + 2, 3)
    }
}