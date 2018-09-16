package com.fanhl.msgcommunilearn.ui.looper2

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.support.v7.app.AppCompatActivity
import com.fanhl.msgcommunilearn.R

class Looper2Activity : AppCompatActivity() {
    private lateinit var myThread: MyThread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_looper2)


        myThread = MyThread()
    }

    class MyThread : HandlerThread("Looper2") {
        lateinit var handler: Handler

        override fun onLooperPrepared() {
            handler = object : Handler() {
                override fun handleMessage(msg: Message?) {

                }
            }
        }
    }
}
