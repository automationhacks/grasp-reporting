import LogbackExample.logger
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object LogbackExample {
    val logger: Logger = LoggerFactory.getLogger(LogbackExample::class.java)
}

fun main(args: Array<String>) {
    logger.info("Example log from ${LogbackExample::class.java.simpleName}")
}