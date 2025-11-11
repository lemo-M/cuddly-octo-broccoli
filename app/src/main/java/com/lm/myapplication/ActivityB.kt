package com.lm.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lm.myapplication.databinding.ActivityBBinding
import com.lm.myapplication.databinding.ActivityMainBinding
import androidx.core.net.toUri

class ActivityB : AppCompatActivity() {

    private lateinit var binding: ActivityBBinding

    private var TAG = "B-Life"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "@@B-ac: onCreate called")

        //初始化binding
        binding = ActivityBBinding.inflate(layoutInflater)
        //设置内容试图的root
        setContentView(binding.root)

        //跳转到C，并传递User数据
        binding.buttonToC.setOnClickListener {
            val user = User(101, "lm", "123456@163.com")
            val intent = Intent(this, ActivityC::class.java)
            intent.putExtra("USER_DATA",user)
            startActivity(intent)
        }

        //隐式Intent
        //查看网页
        binding.buttonOpenBrowser.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
//            intent.action = "android.intent.action.VIEW"
            intent.data = Uri.parse("https://www.baidu.com")
            startActivity(intent)
        }

        //查看地图，北京故宫的经纬度
        binding.buttonOpenMap.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = "geo:39.916345,116.397155".toUri()
            startActivity(intent)
        }

        //拨打电话(预填电话号码，不拨打)
        binding.buttonDial.setOnClickListener {
            //Intent.ACTION_CALL 。 这是拨打电话
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = "tel:10086".toUri()
            startActivity(intent)
        }

        // 分享文本
        binding.buttonShareText.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain" //指定分享的数据类型是纯文本
            intent.putExtra(Intent.EXTRA_TEXT, "这是分享的文本")
            startActivity(Intent.createChooser(intent, "分享到？？？"))
        }

        // 发送短信
        binding.buttonSendSms.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = "smsto:10086".toUri()
            intent.putExtra("sms_body", "这是短信的内容")
            startActivity(intent)
        }


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "@@B-ac onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "@@B-ac onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "@@B-ac onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "@@B-ac onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "@@B-ac onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "@@B-ac onRestart: ")
    }
}