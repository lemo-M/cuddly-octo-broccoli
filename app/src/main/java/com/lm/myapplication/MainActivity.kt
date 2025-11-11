package com.lm.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lm.myapplication.databinding.ActivityMainBinding
import kotlin.random.Random
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val TAG = "Main-Life"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "===Main: onCreate called")

        //初始化binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //设置内容试图的root
        setContentView(binding.root)

        //显式intent
        binding.buttonToB.setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "===Main onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "===Main onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "===Main onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "===Main onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "===Main onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "===Main onRestart: ")
    }

}