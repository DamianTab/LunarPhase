package com.example.lunarphase

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.LocalDate

class Moon : Serializable{

    var isNorthSide: Boolean = true
    @RequiresApi(Build.VERSION_CODES.O)
    var date: LocalDate = LocalDate.now()
    var algorithm: Algorithm = Algorithm.Simple
    var photo: Int = R.drawable.n_b_0_4
}

