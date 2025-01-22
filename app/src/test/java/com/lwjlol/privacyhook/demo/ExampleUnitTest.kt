package com.lwjlol.privacyhook.demo

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        runBlocking {
            launch {
                println("launch on ${System.currentTimeMillis()}")
                delay(5000)
                println("launch end on ${System.currentTimeMillis()}")

            }
            launch {
                println("launch1 on ${System.currentTimeMillis()}")
                delay(5000)
                println("launch1 end on ${System.currentTimeMillis()}")

            }
        }
        println("2")
    }
}