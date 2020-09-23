package logback

import TestGroups
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.testng.Assert
import org.testng.annotations.Test
import java.util.concurrent.ThreadLocalRandom


@Test(groups = [TestGroups.ALL])
class LogbackTests {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    // This test can be flaky and non deterministic
    // Done on purpose to see variation in report portal history
    @Test
    fun simpleLoggingTest() {
        logger.info("Example log from ${this::class.java.simpleName}")
        val random = ThreadLocalRandom.current().nextInt(30000)
        val limit = 20000

        logMessage(random, limit)
        Assert.assertTrue(random > limit, "No was greater than $limit")
    }

    private fun logMessage(random: Int, limit: Int) {
        if (random > limit) {
            logger.info("$random is > $limit")
        } else {
            logger.info("$random is < $limit")
        }
    }

    @Test
    fun differentLogLevelsTest() {
        logger.trace("OMG trace level detail")
        logger.debug("Minute level detail")
        logger.info("This is just an info")
        logger.warn("Something bad happened")
        logger.error("Something catastropic happened")
    }
}