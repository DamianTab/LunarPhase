package com.example.lunarphase

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    private var moon: Moon? = null
    val listeners: List<Button> = listOf(sButton, nButton, trig1Button, trig2Button, conwayButton, simpleButton )

    override fun onCreate(savedInstanceState: Bundle?) {
        moon = intent.extras?.get(DataType.Data.toString()) as Moon?
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }

    fun buttonListener(view: View){
        println(view.id)
    }


    fun southListener(view: View) {
    }

    fun northListener(view: View) {

    }

    fun trig1Listener(view: View) {

    }

    fun trig2Listener(view: View) {
    }

    fun conwayListener(view: View) {

    }

    fun simpleListener(view: View) {

    }

    fun colorAlgorithm() {

    }

    fun colorHemisphere() {

    }

    override fun finish() {
//        val intent = Intent()
        intent.putExtra(DataType.Data.toString(), moon)
        setResult(Activity.RESULT_OK, intent)
        super.finish()
    }
}
