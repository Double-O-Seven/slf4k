package ch.leadrian.slf4k

internal class TestLoggers {

    companion object {

        val companionLogger = logger()
    }

    val instanceLogger = logger()
}