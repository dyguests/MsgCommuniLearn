package com.fanhl.msgcommunilearn.ui.looper2

import android.os.*
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.fanhl.msgcommunilearn.R
import kotlinx.android.synthetic.main.activity_looper2.*

/**
 * 非主线程更新UI
 */
class Looper2Activity : AppCompatActivity() {
    private lateinit var myThread: MyThread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_looper2)

        myThread = MyThread().apply {
            start()
        }

        button.setOnClickListener {
            myThread.handler.sendMessage(Message().apply {
                what = 1
                obj = "haaa"
            })
        }

        button2.setOnClickListener {
            myThread.handler.post {
                try {
                    textView.text = "${System.currentTimeMillis()}"
                } catch (e: Exception) {
                } finally {
                }
            }
        }
    }

    companion object {
        val TAG = Looper2Activity::class.java.simpleName!!
    }

    class MyThread : HandlerThread("Looper2") {
        lateinit var handler: Handler

        override fun onLooperPrepared() {
            handler = object : Handler(Looper.myLooper()) {
                override fun handleMessage(msg: Message?) {
                    Log.d(TAG, "获得了message ${msg?.obj}")
                }
            }
        }
    }
}
