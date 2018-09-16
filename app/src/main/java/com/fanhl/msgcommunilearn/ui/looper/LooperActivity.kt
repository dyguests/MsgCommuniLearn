package com.fanhl.msgcommunilearn.ui.looper

import android.os.*
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.fanhl.msgcommunilearn.R
import kotlinx.android.synthetic.main.activity_looper.*


class LooperActivity : AppCompatActivity() {

    //    var handler: Handler? = null
    var mHandlerThread: MyHandlerThread? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_looper)

        button.setOnClickListener {
            mHandlerThread = MyHandlerThread("onStartHandlerThread")
//            mHandlerThread = MyHandlerThread()
            Log.d(TAG, "创建myHandlerThread对象")
            mHandlerThread?.start()
            Log.d(TAG, "start一个Thread")
        }

        button2.setOnClickListener {
            if (mHandlerThread?.mHandler != null) {
                val msg = Message()
                msg.what = 1
                mHandlerThread?.mHandler?.sendMessage(msg)
            }
        }
    }

    companion object {
        const val TAG = "LooperActivity"
    }

    class MyHandlerThread(name: String) : Thread(name) {

        var mHandler: Handler? = null

        override fun run() {
            Log.d(TAG, "进入Thread的run")
            Looper.prepare()
            mHandler = object : Handler(Looper.myLooper()) {
                override fun handleMessage(msg: Message) {
                    Log.d(TAG, "获得了message ${msg.what}")

                    super.handleMessage(msg)
                }
            }
            Looper.loop()
        }

        companion object {
            const val TAG = "MyHandlerThread"
        }
    }

    class MyHandler2Thread(name: String) : HandlerThread(name) {
        var mHandler: Handler? = null

        override fun onLooperPrepared() {
            mHandler = object : Handler(Looper.myLooper()) {
                override fun handleMessage(msg: Message) {
                    Log.d(MyHandlerThread.TAG, "获得了message ${msg.what}")

                    super.handleMessage(msg)
                }
            }
        }
    }
}
