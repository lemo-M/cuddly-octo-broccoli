package com.lm.myapplication

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lm.myapplication.databinding.ActivityCBinding

class ActivityC : AppCompatActivity() {

    private lateinit var binding: ActivityCBinding

    private val TAG = "C-Life"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "C-ac onCreate called")

        binding = ActivityCBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToMain.setOnClickListener {
            val intent = android.content.Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // 从 Intent 中获取传递过来的 User 对象
        // 注意：从 Android 13 (API 33) 开始，推荐使用带 Class 参数的 getParcelableExtra
        val user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("USER_DATA", User::class.java)
        } else {
            @Suppress
            intent.getParcelableExtra<User>("USER_DATA")
        }

        if (user!=null){
            val userInfo = """
                User Information:
                ID: ${user.id}
                Name: ${user.name}
                Email: ${user.email}
            """.trimIndent()
            binding.userInfo.text = userInfo
        }else{
            binding.userInfo.text = "No user data found"
        }



    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "!!C-ac onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "!!C-ac onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "!!C-ac onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "!!C-ac onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "!!C-ac onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "!!C-ac onRestart: ")
    }
}