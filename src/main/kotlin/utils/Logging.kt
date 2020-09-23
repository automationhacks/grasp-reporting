package utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

enum class LogLevel {
    TRACE, DEBUG, INFO, WARN, ERROR
}

object Logging {
    private val LOGGER: Logger = LoggerFactory.getLogger(this::class.java)

    fun log(msg: String, level: LogLevel = LogLevel.INFO) {
        when (level) {
            LogLevel.TRACE -> LOGGER.trace(msg)
            LogLevel.DEBUG -> LOGGER.debug(msg)
            LogLevel.INFO -> LOGGER.info(msg)
            LogLevel.WARN -> LOGGER.warn(msg)
            LogLevel.ERROR -> LOGGER.error(msg)
        }
    }
}
