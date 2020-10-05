package tests

import TestGroups
import com.epam.reportportal.annotations.attribute.Attribute
import com.epam.reportportal.annotations.attribute.Attributes
import org.slf4j.LoggerFactory
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class SetupTeardownWithDataProvider {
    private val logger = LoggerFactory.getLogger(SetupTeardownWithDataProvider::class.java)

    @BeforeMethod(alwaysRun = true)
    fun before(params: Array<Any>?) {
        logger.info("Checking if the param size > 2")
        Assert.assertTrue(params!!.size > 2)
    }

    @DataProvider
    fun numbers(): MutableIterator<Array<Any>> {
        val data = arrayListOf<Array<Any>>()

        data.add(arrayOf(2, 5, 7))
        data.add(arrayOf(3, 5, 8))
        data.add(arrayOf(4, 5, 9))
        data.add(arrayOf(5, 5, 9))
        data.add(arrayOf(6, 5, 11))

        return data.iterator()
    }


    @Test(dataProvider = "numbers", groups = [TestGroups.SHOULD_PASS])
    @Attributes(attributes = [Attribute(key = "additional", value = "should_pass")])
    fun testAddition(first: Int, second: Int, expected: Int) {
        Assert.assertTrue(first + second == expected)
    }

    @AfterMethod(alwaysRun = true)
    fun after(params: Array<Any>?) {
        logger.info("Executing teardown logic")
    }
}