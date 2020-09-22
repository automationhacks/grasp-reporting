package utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Logging {
    private val LOGGER: Logger = LoggerFactory.getLogger(this::class.java)

    fun log(msg: String) {
        LOGGER.info(msg)
    }
}
