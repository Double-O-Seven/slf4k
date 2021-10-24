[![Java CI with Gradle](https://github.com/Double-O-Seven/slf4k/actions/workflows/gradle.yml/badge.svg)](https://github.com/Double-O-Seven/slf4k/actions/workflows/gradle.yml)
[![Release Version](https://img.shields.io/maven-central/v/ch.leadrian.slf4k/slf4k.svg?label=release)](https://search.maven.org/search?q=g:ch.leadrian.slf4k)

# slf4k
Kotlin extension functions for SLF4J.

## How to use it?

It's very simple:
```kotlin
package com.example

import ch.leadrian.slf4k.logger
import ch.leadrian.slf4k.info

class MyService {

  companion object {
    
    private val log = logger()
  }
  
  fun doSomething(foo: String) {
    log.info { "foo = $foo" }
  }

}
```

The above example create a logger with the name `com.example.MyService` and logs a lazily computed message at `INFO` level.
