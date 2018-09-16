package com.fanhl.msgcommunilearn.ui.pool

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.fanhl.msgcommunilearn.R
import kotlinx.android.synthetic.main.activity_pool.*
import java.util.concurrent.Executors

class PoolActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pool)

        val executor = Executors.newFixedThreadPool(5)

        val myRunnable = Runnable {
            Thread.sleep(1000)
            Log.d("myRunnable", "run ${System.currentTimeMillis()}")
        }
        executor.execute(myRunnable)

        button.setOnClickListener {
            executor.execute(myRunnable)
        }
    }

    companion object {
        val TAG = PoolActivity::class.java.simpleName
    }
}
