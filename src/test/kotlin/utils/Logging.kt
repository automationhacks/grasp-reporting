package utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

object Logging {
    private val LOGGER: Logger = LoggerFactory.getLogger("binary_data_logger")

    fun log(file : File, msg : String) {
        LOGGER.info("RP_MESSAGE#FILE#${file.absolutePath}#$msg")
    }
}
