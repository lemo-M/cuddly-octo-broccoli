package com.lm.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lm.myapplication.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //初始化binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //设置内容试图的root
        setContentView(binding.root)

        //button设置点击事件监听
        binding.actionButton.setOnClickListener {
            var randomNum = Random.nextInt(10)
            //当button被点击时，执行
            binding.infoTextView.text = randomNum.toString()
        }
    }
}