package com.example.lunarphase

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    private val moon: Moon = Moon()
    private val CODE = 1000

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateView()

    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun updateView() {
        var phase = 20.3
        moon.date = LocalDate.now()
        val todayDate = LocalDate.now()
        today.text = "Lunar phase today: $phase%"
        lastNewMoon.text = "Last new moon was: ${moon.date}"
        nextFullMoon.text = "Next full moon will be: ${moon.date}"
        moonImage.setImageResource(moon.photo)
    }


    fun fullMoonListener(view: View){
        val intent = Intent(this, FullMoonActivity::class.java)
        intent.putExtra(Utils.Data.toString(), moon)
        startActivityForResult(intent, CODE)
    }

    fun settingsListener(view: View){
        val intent = Intent(this, SettingsActivity::class.java)
        intent.putExtra(Utils.Data.toString(), moon)
        startActivityForResult(intent, CODE)
    }

}
