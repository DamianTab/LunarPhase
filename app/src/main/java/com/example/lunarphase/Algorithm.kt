package com.example.lunarphase

import kotlin.reflect.KFunction4

enum class Algorithm {
    Simple(Algorithm::simple), Conway(Algorithm::conway), Trig1(Algorithm::trig1), Trig2(Algorithm::trig2);

    private val function: KFunction4<Algorithm, Int, Int, Int, Unit>

    constructor(
        func: KFunction4<Algorithm, @ParameterName(
            name = "year"
        ) Int, @ParameterName(name = "month") Int, @ParameterName(name = "day") Int, Unit>
    ) {
        this.function = func
    }

    public fun calculate(year: Int, month: Int, day: Int) {
        return function(this, year, month, day)
    }

    private fun simple(year: Int, month: Int, day: Int) {}
    private fun conway(year: Int, month: Int, day: Int) {}
    private fun trig1(year: Int, month: Int, day: Int) {}
    private fun trig2(year: Int, month: Int, day: Int) {}
}