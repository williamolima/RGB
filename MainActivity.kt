package com.example.rgb

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    var red: Int = 0
    var green: Int = 0
    var blue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        
        var view = R.layout.activity_main

        redBar.setOnSeekBarChangeListener(this)
        greenBar.setOnSeekBarChangeListener(this)
        blueBar.setOnSeekBarChangeListener(this)

        mudarCores(redBar, redBar.progress, true)
        mudarCores(greenBar, greenBar.progress, true)
        mudarCores(blueBar, blueBar.progress, true)
    }

    private fun mudarCores(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        when(seekBar){
            redBar -> red = redBar.progress
            greenBar -> green = greenBar.progress
            blueBar -> blue = blueBar.progress
        }
        updateColor()
    }

    private fun updateColor() = view.setBackgroundColor(Color.parseColor("#${getHex(red)}${getHex(green)}${getHex(blue)}"))

    val hexadeci = 16
    fun getHex(dec: Int): String = "${getHexDigit(dec/hexadeci)}${getHexDigit(dec%hexadeci)}"

    fun getHexDigit(dec: Int): String{
        return when(dec){
            in 0..9 -> "$dec"
            in 10..15 -> "${('A' + (dec-10))}"
            else -> "0"
        }
    }
}