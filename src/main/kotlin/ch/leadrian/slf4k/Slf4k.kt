package ch.leadrian.slf4k

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.Marker

inline fun <reified T : Any> loggerFor(): Logger = LoggerFactory.getLogger(T::class.java)

@Suppress("unused")
inline fun <reified T : Any> T.logger(): Logger {
    val classToLog = when {
        T::class.isCompanion -> T::class.java.declaringClass ?: T::class.java
        else -> T::class.java
    }
    return LoggerFactory.getLogger(classToLog)
}

inline fun Logger.trace(message: () -> String) {
    if (isTraceEnabled) {
        trace(message())
    }
}

inline fun Logger.trace(marker: Marker, message: () -> String) {
    if (isTraceEnabled) {
        trace(marker, message())
    }
}

inline fun Logger.trace(throwable: Throwable, message: () -> String) {
    if (isTraceEnabled) {
        trace(message(), throwable)
    }
}

inline fun Logger.trace(marker: Marker, throwable: Throwable, message: () -> String) {
    if (isTraceEnabled) {
        trace(marker, message(), throwable)
    }
}

inline fun Logger.debug(message: () -> String) {
    if (isDebugEnabled) {
        debug(message())
    }
}

inline fun Logger.debug(marker: Marker, message: () -> String) {
    if (isDebugEnabled) {
        debug(marker, message())
    }
}

inline fun Logger.debug(throwable: Throwable, message: () -> String) {
    if (isDebugEnabled) {
        debug(message(), throwable)
    }
}

inline fun Logger.debug(marker: Marker, throwable: Throwable, message: () -> String) {
    if (isDebugEnabled) {
        debug(marker, message(), throwable)
    }
}

inline fun Logger.info(message: () -> String) {
    if (isInfoEnabled) {
        info(message())
    }
}

inline fun Logger.info(marker: Marker, message: () -> String) {
    if (isInfoEnabled) {
        info(marker, message())
    }
}

inline fun Logger.info(throwable: Throwable, message: () -> String) {
    if (isInfoEnabled) {
        info(message(), throwable)
    }
}

inline fun Logger.info(marker: Marker, throwable: Throwable, message: () -> String) {
    if (isInfoEnabled) {
        info(marker, message(), throwable)
    }
}

inline fun Logger.warn(message: () -> String) {
    if (isWarnEnabled) {
        warn(message())
    }
}

inline fun Logger.warn(marker: Marker, message: () -> String) {
    if (isWarnEnabled) {
        warn(marker, message())
    }
}

inline fun Logger.warn(throwable: Throwable, message: () -> String) {
    if (isWarnEnabled) {
        warn(message(), throwable)
    }
}

inline fun Logger.warn(marker: Marker, throwable: Throwable, message: () -> String) {
    if (isWarnEnabled) {
        warn(marker, message(), throwable)
    }
}

inline fun Logger.error(message: () -> String) {
    if (isErrorEnabled) {
        error(message())
    }
}

inline fun Logger.error(marker: Marker, message: () -> String) {
    if (isErrorEnabled) {
        error(marker, message())
    }
}

inline fun Logger.error(throwable: Throwable, message: () -> String) {
    if (isErrorEnabled) {
        error(message(), throwable)
    }
}

inline fun Logger.error(marker: Marker, throwable: Throwable, message: () -> String) {
    if (isErrorEnabled) {
        error(marker, message(), throwable)
    }
}