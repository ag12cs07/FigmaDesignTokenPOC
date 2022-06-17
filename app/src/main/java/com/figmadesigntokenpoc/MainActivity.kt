package com.figmadesigntokenpoc

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.google.gson.internal.LinkedTreeMap
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val consLayout = findViewById<ConstraintLayout>(R.id.parent)
        val imgIcon = findViewById<AppCompatImageView>(R.id.img_icon)
        val tvLabel = findViewById<TextView>(R.id.tv_label)

        val jsonToken = Utils.readRawTokensJson(
            this,
            R.raw.tokens
        )

        jsonToken?.let { tokens ->
            try {
                consLayout.background = ColorDrawable(
                    Color.parseColor(
                        tokens
                            ?.get(TokenConstant.TOKEN_SET_GLOBAL)
                            ?.get(TokenConstant.white)
                            ?.value
                    )

                )





            Glide.with(this).load(
                tokens?.get(TokenConstant.TOKEN_SET_GLOBAL)?.get(TokenConstant.ic_home)?.value
            ).into(imgIcon)







//                val ver1WindowBackground =
//                    tokens?.get(TokenConstant.ver_1)?.get(TokenConstant.window_bg)?.value
//                        ?: ""
//                if (ver1WindowBackground.length > 2) {
//
//                    val consLayoutColor = tokens?.get(TokenConstant.TOKEN_SET_GLOBAL)?.get(
//                        ver1WindowBackground.substring(1, ver1WindowBackground.length - 1))?.value ?: ""
//
//                    consLayout.background = ColorDrawable(Color.parseColor(consLayoutColor))
//                } else {
//                }


            } catch (e: Exception) {
                Log.e("token exc------->", e.toString())
            }

        }
    }
}
