package com.example.lunarphase

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    private var moonSettings: MoonSettings? = null
    private var algorithmListeners: List<Button>? = null
    private var hemisphereListeners: List<Button>? = null
    private val CUSTOM_COLOR = Color.rgb(213, 213, 213)

    override fun onCreate(savedInstanceState: Bundle?) {
        moonSettings = intent.extras?.get(Utils.Data.toString()) as MoonSettings?
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        algorithmListeners = listOf(trig1Button, trig2Button, conwayButton, simpleButton)
        hemisphereListeners = listOf(sButton, nButton)
        init()
    }

    override fun finish() {
        intent.putExtra(Utils.Data.toString(), moonSettings)
        setResult(Activity.RESULT_OK, intent)
        super.finish()
    }

    fun buttonAlgorithmListener(view: View){
        val button = view as Button
        colorButtonsList(algorithmListeners, button.id);
        when (button.text) {
            Algorithm.Simple.name -> moonSettings?.algorithm = Algorithm.Simple
            Algorithm.Conway.name -> moonSettings?.algorithm = Algorithm.Conway
            Algorithm.Trig1.name -> moonSettings?.algorithm = Algorithm.Trig1
            else -> moonSettings?.algorithm = Algorithm.Trig2
        }
    }

    fun buttonHemisphereListener(view: View){
        val button = view as Button
        colorButtonsList(hemisphereListeners, button.id)
        moonSettings?.isNorthSide = button.text == "North (N)"
    }

    private fun init(){
        algorithmListeners?.forEach {
            val color = if (moonSettings?.algorithm?.name == it.text) Color.GRAY else CUSTOM_COLOR
            it.setBackgroundColor(color)
        }
        if(moonSettings?.isNorthSide!!){
            nButton.setBackgroundColor(Color.GRAY)
            sButton.setBackgroundColor(CUSTOM_COLOR)
        }else{
            sButton.setBackgroundColor(Color.GRAY)
            nButton.setBackgroundColor(CUSTOM_COLOR)
        }
    }

    private fun colorButtonsList(list: List<Button>?, id: Int) {
        list?.forEach {
            val color = if (it.id == id) Color.GRAY else CUSTOM_COLOR
            it.setBackgroundColor(color)
        }
    }
}
