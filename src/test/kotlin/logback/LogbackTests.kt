package logback

import TestGroups
import org.testng.Assert
import org.testng.annotations.Test
import utils.Logging
import java.util.concurrent.ThreadLocalRandom


@Test(groups = [TestGroups.ALL])
class LogbackTests {

    // This test can be flaky and non deterministic
    // Done on purpose to see variation in report portal history
    @Test
    fun simpleLoggingTest() {
        Logging.log("Example log from ${this::class.java.simpleName}")
        val random = ThreadLocalRandom.current().nextInt(30000)
        val limit = 20000
        if (random > limit) {
            Logging.log("$random is > $limit")
        } else {
            Logging.log("$random is < $limit")
        }
        Assert.assertTrue(random > limit, "No was greater than $limit")
    }
}