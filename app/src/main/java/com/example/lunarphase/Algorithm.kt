package com.example.lunarphase

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.ZoneOffset
import kotlin.reflect.KFunction4

enum class Algorithm {
    Simple(Algorithm::simple), Conway(Algorithm::conway), Trig1(Algorithm::trig1), Trig2(Algorithm::trig2);

    private val function: KFunction4<Algorithm, Int, Int, Int, Double>

    constructor(
        func: KFunction4<Algorithm, @ParameterName(name = "year") Int, @ParameterName(
            name = "month"
        ) Int, @ParameterName(name = "day") Int, Double>
    ) {
        this.function = func
    }

    public fun calculate(year: Int, month: Int, day: Int): Double {
        return function(this, year, month, day)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun simple(year: Int, month: Int, day: Int): Double {
        val lp = 2551443
        val now = LocalDateTime.of(year, month-1, day, 20, 35, 0).atZone(ZoneOffset.UTC).toInstant()
            .toEpochMilli()
        val newMoon = LocalDateTime.of(1970, 0, 7, 20, 35, 0).atZone(ZoneOffset.UTC).toInstant()
            .toEpochMilli()
        val phase = ((now - newMoon) / 1000) % lp
        return kotlin.math.floor(phase / (24 * 3600).toDouble()) + 1
    }

    private fun conway(year: Int, month: Int, day: Int): Double {
        return 0.0
    }

    private fun trig1(year: Int, month: Int, day: Int): Double {
        return 0.0

    }

    private fun trig2(year: Int, month: Int, day: Int): Double {
        return 0.0

    }
}