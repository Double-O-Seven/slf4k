/*
 * Copyright (C) 2021 Adrian-Philipp Leuenberger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package ch.leadrian.slf4k

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.Marker

/**
 * @return a logger for the given parameterized type [T]
 */
inline fun <reified T : Any> loggerFor(): Logger = LoggerFactory.getLogger(T::class.java)

/**
 * @return a logger for the given receiver's class or it's declaring class in case of a companion class
 */
fun Any.logger(): Logger {
    val classToLog = when {
        this::class.isCompanion -> javaClass.declaringClass ?: javaClass
        else                    -> javaClass
    }
    return LoggerFactory.getLogger(classToLog)
}

/**
 * @return a logger with the given name
 */
fun logger(name: String): Logger = LoggerFactory.getLogger(name)

/**
 * Log a lazily computed message at TRACE level.
 */
inline fun Logger.trace(message: () -> String) {
    if (isTraceEnabled) {
        trace(message())
    }
}

/**
 * Log a lazily computed message with the specified marker at TRACE level.
 */
inline fun Logger.trace(marker: Marker, message: () -> String) {
    if (isTraceEnabled) {
        trace(marker, message())
    }
}

/**
 * Log an exception and a lazily computed message at TRACE level.
 */
inline fun Logger.trace(throwable: Throwable?, message: () -> String) {
    if (isTraceEnabled) {
        trace(message(), throwable)
    }
}

/**
 * Log an exception and a lazily computed message with the specified marker at TRACE level.
 */
inline fun Logger.trace(marker: Marker, throwable: Throwable?, message: () -> String) {
    if (isTraceEnabled) {
        trace(marker, message(), throwable)
    }
}

/**
 * Log a lazily computed message at DEBUG level.
 */
inline fun Logger.debug(message: () -> String) {
    if (isDebugEnabled) {
        debug(message())
    }
}

/**
 * Log a lazily computed message with the specified marker at DEBUG level.
 */
inline fun Logger.debug(marker: Marker, message: () -> String) {
    if (isDebugEnabled) {
        debug(marker, message())
    }
}

/**
 * Log an exception and a lazily computed message at DEBUG level.
 */
inline fun Logger.debug(throwable: Throwable?, message: () -> String) {
    if (isDebugEnabled) {
        debug(message(), throwable)
    }
}

/**
 * Log an exception and a lazily computed message with the specified marker at DEBUG level.
 */
inline fun Logger.debug(marker: Marker, throwable: Throwable?, message: () -> String) {
    if (isDebugEnabled) {
        debug(marker, message(), throwable)
    }
}

/**
 * Log a lazily computed message at INFO level.
 */
inline fun Logger.info(message: () -> String) {
    if (isInfoEnabled) {
        info(message())
    }
}

/**
 * Log a lazily computed message with the specified marker at INFO level.
 */
inline fun Logger.info(marker: Marker, message: () -> String) {
    if (isInfoEnabled) {
        info(marker, message())
    }
}

/**
 * Log an exception and a lazily computed message at INFO level.
 */
inline fun Logger.info(throwable: Throwable?, message: () -> String) {
    if (isInfoEnabled) {
        info(message(), throwable)
    }
}

/**
 * Log an exception and a lazily computed message with the specified marker at INFO level.
 */
inline fun Logger.info(marker: Marker, throwable: Throwable?, message: () -> String) {
    if (isInfoEnabled) {
        info(marker, message(), throwable)
    }
}

/**
 * Log a lazily computed message at WARN level.
 */
inline fun Logger.warn(message: () -> String) {
    if (isWarnEnabled) {
        warn(message())
    }
}

/**
 * Log a lazily computed message with the specified marker at WARN level.
 */
inline fun Logger.warn(marker: Marker, message: () -> String) {
    if (isWarnEnabled) {
        warn(marker, message())
    }
}

/**
 * Log an exception and a lazily computed message at WARN level.
 */
inline fun Logger.warn(throwable: Throwable?, message: () -> String) {
    if (isWarnEnabled) {
        warn(message(), throwable)
    }
}

/**
 * Log an exception and a lazily computed message with the specified marker at WARN level.
 */
inline fun Logger.warn(marker: Marker, throwable: Throwable?, message: () -> String) {
    if (isWarnEnabled) {
        warn(marker, message(), throwable)
    }
}

/**
 * Log a lazily computed message at ERROR level.
 */
inline fun Logger.error(message: () -> String) {
    if (isErrorEnabled) {
        error(message())
    }
}

/**
 * Log a lazily computed message with the specified marker at ERROR level.
 */
inline fun Logger.error(marker: Marker, message: () -> String) {
    if (isErrorEnabled) {
        error(marker, message())
    }
}

/**
 * Log an exception and a lazily computed message at ERROR level.
 */
inline fun Logger.error(throwable: Throwable?, message: () -> String) {
    if (isErrorEnabled) {
        error(message(), throwable)
    }
}

/**
 * Log an exception and a lazily computed message with the specified marker at ERROR level.
 */
inline fun Logger.error(marker: Marker, throwable: Throwable?, message: () -> String) {
    if (isErrorEnabled) {
        error(marker, message(), throwable)
    }
}