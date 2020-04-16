package com.example.lunarphase.activity

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.lunarphase.R
import com.example.lunarphase.moon.MoonSettings
import com.example.lunarphase.utils.Utils
import kotlinx.android.synthetic.main.activity_full_moon.*
import java.time.LocalDate
import kotlin.math.round

class FullMoonActivity : AppCompatActivity() {

    private var moonSettings: MoonSettings? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_moon)
        moonSettings = intent.extras?.get(Utils.Data.toString()) as MoonSettings?

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun fullMoonsInYear(view: View){
        val year = yearInput.text.toString().toInt()
        if (year > 2200 || year < 1900) {
            yearInput.setTextColor(Color.RED)
            Toast.makeText(this, "Year have to be between 1900-2200", Toast.LENGTH_SHORT).show()
            return
        }

        yearInput.setTextColor(Color.BLACK)
        var date = LocalDate.of(year, 1, 1)
        var phaseDate = moonSettings?.algorithm?.calculate(date)?.let { round(it) }

        //todo dokonczyc

    }
}
