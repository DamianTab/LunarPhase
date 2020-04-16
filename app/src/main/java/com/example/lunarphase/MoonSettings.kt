package com.example.lunarphase

import java.io.Serializable
import kotlin.math.round
import com.example.lunarphase.R.drawable as d


class MoonSettings : Serializable {
    var isNorthSide: Boolean = true
    var algorithm: Algorithm = Algorithm.Simple
}

