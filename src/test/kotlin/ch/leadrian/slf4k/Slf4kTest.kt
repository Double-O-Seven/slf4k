/*
 * Copyright (C) 2023 Adrian-Philipp Leuenberger
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

import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.Marker

internal class Slf4kTest {

    private val logger = mockk<Logger>()

    @Test
    fun `given trace is enabled it should send message`() {
        val message = "Hi there"
        every { logger.trace(message) } just Runs
        every { logger.isTraceEnabled } returns true

        logger.trace { message }

        verify { logger.trace(message) }
    }

    @Test
    fun `given trace is enabled it should send message with exception`() {
        val message = "Hi there"
        val exception = Exception()
        every { logger.trace(message, exception) } just Runs
        every { logger.isTraceEnabled } returns true

        logger.trace(exception) { message }

        verify { logger.trace(message, exception) }
    }

    @Test
    fun `given trace is enabled it should send message with exception and marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        val exception = Exception()
        every { logger.trace(marker, message, exception) } just Runs
        every { logger.isTraceEnabled } returns true

        logger.trace(marker, exception) { message }

        verify { logger.trace(marker, message, exception) }
    }

    @Test
    fun `given trace is enabled it should send message with marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        every { logger.trace(marker, message) } just Runs
        every { logger.isTraceEnabled } returns true

        logger.trace(marker) { message }

        verify { logger.trace(marker, message) }
    }

    @Test
    fun `given trace is disabled it should send message`() {
        val message = "Hi there"
        every { logger.trace(message) } just Runs
        every { logger.isTraceEnabled } returns false

        logger.trace { message }

        verify(exactly = 0) { logger.trace(message) }
    }

    @Test
    fun `given trace is disabled it should send message with exception`() {
        val message = "Hi there"
        val exception = Exception()
        every { logger.trace(message, exception) } just Runs
        every { logger.isTraceEnabled } returns false

        logger.trace(exception) { message }

        verify(exactly = 0) { logger.trace(message, exception) }
    }

    @Test
    fun `given trace is disabled it should send message with exception and marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        val exception = Exception()
        every { logger.trace(marker, message, exception) } just Runs
        every { logger.isTraceEnabled } returns false

        logger.trace(marker, exception) { message }

        verify(exactly = 0) { logger.trace(marker, message, exception) }
    }

    @Test
    fun `given trace is disabled it should send message with marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        every { logger.trace(marker, message) } just Runs
        every { logger.isTraceEnabled } returns false

        logger.trace(marker) { message }

        verify(exactly = 0) { logger.trace(marker, message) }
    }

    @Test
    fun `given debug is enabled it should send message`() {
        val message = "Hi there"
        every { logger.debug(message) } just Runs
        every { logger.isDebugEnabled } returns true

        logger.debug { message }

        verify { logger.debug(message) }
    }

    @Test
    fun `given debug is enabled it should send message with exception`() {
        val message = "Hi there"
        val exception = Exception()
        every { logger.debug(message, exception) } just Runs
        every { logger.isDebugEnabled } returns true

        logger.debug(exception) { message }

        verify { logger.debug(message, exception) }
    }

    @Test
    fun `given debug is enabled it should send message with exception and marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        val exception = Exception()
        every { logger.debug(marker, message, exception) } just Runs
        every { logger.isDebugEnabled } returns true

        logger.debug(marker, exception) { message }

        verify { logger.debug(marker, message, exception) }
    }

    @Test
    fun `given debug is enabled it should send message with marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        every { logger.debug(marker, message) } just Runs
        every { logger.isDebugEnabled } returns true

        logger.debug(marker) { message }

        verify { logger.debug(marker, message) }
    }

    @Test
    fun `given debug is disabled it should send message`() {
        val message = "Hi there"
        every { logger.debug(message) } just Runs
        every { logger.isDebugEnabled } returns false

        logger.debug { message }

        verify(exactly = 0) { logger.debug(message) }
    }

    @Test
    fun `given debug is disabled it should send message with exception`() {
        val message = "Hi there"
        val exception = Exception()
        every { logger.debug(message, exception) } just Runs
        every { logger.isDebugEnabled } returns false

        logger.debug(exception) { message }

        verify(exactly = 0) { logger.debug(message, exception) }
    }

    @Test
    fun `given debug is disabled it should send message with exception and marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        val exception = Exception()
        every { logger.debug(marker, message, exception) } just Runs
        every { logger.isDebugEnabled } returns false

        logger.debug(marker, exception) { message }

        verify(exactly = 0) { logger.debug(marker, message, exception) }
    }

    @Test
    fun `given debug is disabled it should send message with marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        every { logger.debug(marker, message) } just Runs
        every { logger.isDebugEnabled } returns false

        logger.debug(marker) { message }

        verify(exactly = 0) { logger.debug(marker, message) }
    }

    @Test
    fun `given info is enabled it should send message`() {
        val message = "Hi there"
        every { logger.info(message) } just Runs
        every { logger.isInfoEnabled } returns true

        logger.info { message }

        verify { logger.info(message) }
    }

    @Test
    fun `given info is enabled it should send message with exception`() {
        val message = "Hi there"
        val exception = Exception()
        every { logger.info(message, exception) } just Runs
        every { logger.isInfoEnabled } returns true

        logger.info(exception) { message }

        verify { logger.info(message, exception) }
    }

    @Test
    fun `given info is enabled it should send message with exception and marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        val exception = Exception()
        every { logger.info(marker, message, exception) } just Runs
        every { logger.isInfoEnabled } returns true

        logger.info(marker, exception) { message }

        verify { logger.info(marker, message, exception) }
    }

    @Test
    fun `given info is enabled it should send message with marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        every { logger.info(marker, message) } just Runs
        every { logger.isInfoEnabled } returns true

        logger.info(marker) { message }

        verify { logger.info(marker, message) }
    }

    @Test
    fun `given info is disabled it should send message`() {
        val message = "Hi there"
        every { logger.info(message) } just Runs
        every { logger.isInfoEnabled } returns false

        logger.info { message }

        verify(exactly = 0) { logger.info(message) }
    }

    @Test
    fun `given info is disabled it should send message with exception`() {
        val message = "Hi there"
        val exception = Exception()
        every { logger.info(message, exception) } just Runs
        every { logger.isInfoEnabled } returns false

        logger.info(exception) { message }

        verify(exactly = 0) { logger.info(message, exception) }
    }

    @Test
    fun `given info is disabled it should send message with exception and marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        val exception = Exception()
        every { logger.info(marker, message, exception) } just Runs
        every { logger.isInfoEnabled } returns false

        logger.info(marker, exception) { message }

        verify(exactly = 0) { logger.info(marker, message, exception) }
    }

    @Test
    fun `given info is disabled it should send message with marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        every { logger.info(marker, message) } just Runs
        every { logger.isInfoEnabled } returns false

        logger.info(marker) { message }

        verify(exactly = 0) { logger.info(marker, message) }
    }

    @Test
    fun `given warn is enabled it should send message`() {
        val message = "Hi there"
        every { logger.warn(message) } just Runs
        every { logger.isWarnEnabled } returns true

        logger.warn { message }

        verify { logger.warn(message) }
    }

    @Test
    fun `given warn is enabled it should send message with exception`() {
        val message = "Hi there"
        val exception = Exception()
        every { logger.warn(message, exception) } just Runs
        every { logger.isWarnEnabled } returns true

        logger.warn(exception) { message }

        verify { logger.warn(message, exception) }
    }

    @Test
    fun `given warn is enabled it should send message with exception and marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        val exception = Exception()
        every { logger.warn(marker, message, exception) } just Runs
        every { logger.isWarnEnabled } returns true

        logger.warn(marker, exception) { message }

        verify { logger.warn(marker, message, exception) }
    }

    @Test
    fun `given warn is enabled it should send message with marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        every { logger.warn(marker, message) } just Runs
        every { logger.isWarnEnabled } returns true

        logger.warn(marker) { message }

        verify { logger.warn(marker, message) }
    }

    @Test
    fun `given warn is disabled it should send message`() {
        val message = "Hi there"
        every { logger.warn(message) } just Runs
        every { logger.isWarnEnabled } returns false

        logger.warn { message }

        verify(exactly = 0) { logger.warn(message) }
    }

    @Test
    fun `given warn is disabled it should send message with exception`() {
        val message = "Hi there"
        val exception = Exception()
        every { logger.warn(message, exception) } just Runs
        every { logger.isWarnEnabled } returns false

        logger.warn(exception) { message }

        verify(exactly = 0) { logger.warn(message, exception) }
    }

    @Test
    fun `given warn is disabled it should send message with exception and marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        val exception = Exception()
        every { logger.warn(marker, message, exception) } just Runs
        every { logger.isWarnEnabled } returns false

        logger.warn(marker, exception) { message }

        verify(exactly = 0) { logger.warn(marker, message, exception) }
    }

    @Test
    fun `given warn is disabled it should send message with marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        every { logger.warn(marker, message) } just Runs
        every { logger.isWarnEnabled } returns false

        logger.warn(marker) { message }

        verify(exactly = 0) { logger.warn(marker, message) }
    }

    @Test
    fun `given error is enabled it should send message`() {
        val message = "Hi there"
        every { logger.error(message) } just Runs
        every { logger.isErrorEnabled } returns true

        logger.error { message }

        verify { logger.error(message) }
    }

    @Test
    fun `given error is enabled it should send message with exception`() {
        val message = "Hi there"
        val exception = Exception()
        every { logger.error(message, exception) } just Runs
        every { logger.isErrorEnabled } returns true

        logger.error(exception) { message }

        verify { logger.error(message, exception) }
    }

    @Test
    fun `given error is enabled it should send message with exception and marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        val exception = Exception()
        every { logger.error(marker, message, exception) } just Runs
        every { logger.isErrorEnabled } returns true

        logger.error(marker, exception) { message }

        verify { logger.error(marker, message, exception) }
    }

    @Test
    fun `given error is enabled it should send message with marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        every { logger.error(marker, message) } just Runs
        every { logger.isErrorEnabled } returns true

        logger.error(marker) { message }

        verify { logger.error(marker, message) }
    }

    @Test
    fun `given error is disabled it should send message`() {
        val message = "Hi there"
        every { logger.error(message) } just Runs
        every { logger.isErrorEnabled } returns false

        logger.error { message }

        verify(exactly = 0) { logger.error(message) }
    }

    @Test
    fun `given error is disabled it should send message with exception`() {
        val message = "Hi there"
        val exception = Exception()
        every { logger.error(message, exception) } just Runs
        every { logger.isErrorEnabled } returns false

        logger.error(exception) { message }

        verify(exactly = 0) { logger.error(message, exception) }
    }

    @Test
    fun `given error is disabled it should send message with exception and marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        val exception = Exception()
        every { logger.error(marker, message, exception) } just Runs
        every { logger.isErrorEnabled } returns false

        logger.error(marker, exception) { message }

        verify(exactly = 0) { logger.error(marker, message, exception) }
    }

    @Test
    fun `given error is disabled it should not send message with marker`() {
        val marker = mockk<Marker>()
        val message = "Hi there"
        every { logger.error(marker, message) } just Runs
        every { logger.isErrorEnabled } returns false

        logger.error(marker) { message }

        verify(exactly = 0) { logger.error(marker, message) }
    }

    @Test
    fun `should create logger with correct name from companion`() {
        val logger = TestLoggers.companionLogger

        assertEquals("ch.leadrian.slf4k.TestLoggers", logger.name)
    }

    @Test
    fun `should create logger with correct name for instance`() {
        val logger = TestLoggers().instanceLogger

        assertEquals("ch.leadrian.slf4k.TestLoggers", logger.name)
    }

    @Test
    fun `should create logger with correct name for class`() {
        val logger = loggerFor<TestLoggers>()

        assertEquals("ch.leadrian.slf4k.TestLoggers", logger.name)
    }

    @Test
    fun `should create logger with given name`() {
        val logger = logger("TestLogger")

        assertEquals("TestLogger", logger.name)
    }
}

