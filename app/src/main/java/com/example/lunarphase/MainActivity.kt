package com.example.lunarphase

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.time.LocalDate


class MainActivity : AppCompatActivity() {

    private var moon: Moon = Moon()
    private val CODE = 1000
    private val filename = "MoonData.txt";


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun updateView() {
        var phase = 20.3
        moon.date = LocalDate.now()
        today.text = "Lunar phase today: $phase%"
        lastNewMoon.text = "Last new moon was: ${moon.date}"
        nextFullMoon.text = "Next full moon will be: ${moon.date}"
        moonImage.setImageResource(moon.photo)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CODE && resultCode == Activity.RESULT_OK) {
            moon = data?.extras?.get(Utils.Data.toString()) as Moon
            saveData()
        } else updateView()
    }

    fun fullMoonListener(view: View) {
        val intent = Intent(this, FullMoonActivity::class.java)
        intent.putExtra(Utils.Data.toString(), moon)
        startActivityForResult(intent, CODE)
    }

    fun settingsListener(view: View) {
        val intent = Intent(this, SettingsActivity::class.java)
        intent.putExtra(Utils.Data.toString(), moon)
        startActivityForResult(intent, CODE)
    }

    private fun saveData() {
        val file = File(this.getExternalFilesDir(null), filename)
        try {
            ObjectOutputStream(FileOutputStream(file)).use { it.writeObject(moon) }
            Toast.makeText(this, "Changes saved", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error occurred during saving!", Toast.LENGTH_SHORT).show()
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun loadData() {
        try {
            val file = File(this.getExternalFilesDir(null), filename)
            if (file.exists()) {
                ObjectInputStream(FileInputStream(file)).use { moon = it.readObject() as Moon }
            } else {
                updateView()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error occurred during loading!", Toast.LENGTH_SHORT).show()
        }
    }

}
