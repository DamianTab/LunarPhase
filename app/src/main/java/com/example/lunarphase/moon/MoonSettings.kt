package com.example.lunarphase.moon

import com.example.lunarphase.moon.Algorithm
import java.io.Serializable


class MoonSettings : Serializable {
    var isNorthSide: Boolean = true
    var algorithm: Algorithm = Algorithm.Simple
}

