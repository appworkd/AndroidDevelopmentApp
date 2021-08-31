package com.appwork.mentorshipprogram.background.async

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.appwork.mentorshipprogram.background.SecondActivity
import com.appwork.mentorshipprogram.databinding.ActivityMainBackgroundBinding

class MainBackgroundActivity : AppCompatActivity() {
    companion object MainComp{
        const val TAG = "MainBackgroundActivity"
        const val a=0;
    }

    private val mainBinding by lazy {
        ActivityMainBackgroundBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)
        mainBinding.btnStart.setOnClickListener {
            MyAsyncTask().execute(10)
        }
        mainBinding.btnMove.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }

    }

    //    class MyAsyncTask(private val mainBackgroundActivity: MainBackgroundActivity) :
    inner class MyAsyncTask :   //Input, Progress, Output
                                AsyncTask<Int, Int, String>() {
//        var weakReference: WeakReference<MainBackgroundActivity> =
//            WeakReference(mainBackgroundActivity)

        //#1
        override fun onPreExecute() {
            super.onPreExecute()
            Log.e(TAG, "onPreExecute: Thread Name ${Thread.currentThread().name}")
            mainBinding.progressBar.visibility = View.VISIBLE
            /*val activity = weakReference.get()
            activity?.let {
                if (it.isFinishing) {
                    return
                }
                it.mainBinding.progressBar.visibility = View.VISIBLE
            }*/
        }

        //#2
        override fun doInBackground(vararg params: Int?): String {
            Log.e(TAG, "doInBackground: Thread Name ${Thread.currentThread().name}")
            for (i in 0..params[0]!!) {
                publishProgress((i * 100) / params[0]!!)
                try {
                    Thread.sleep(200L)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            return "RESULT"
        }

        //#3
        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            //Log.e(TAG, "onProgressUpdate: Thread Name ${Thread.currentThread().name}")
            mainBinding.progressBar.progress = values[0]!!
           /* val activity = weakReference.get()
            activity?.let {
                if (it.isFinishing) {
                    return
                }
                it.mainBinding.progressBar.progress = values[0]!!
            }*/

        }

        //#4
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Log.e(TAG, "onPostExecute: Thread Name ${Thread.currentThread().name}")
            mainBinding.progressBar.visibility = View.GONE
            Toast.makeText(this@MainBackgroundActivity, result, Toast.LENGTH_LONG).show()
            /*val activity = weakReference.get()
            activity?.let {
                if (it.isFinishing) {
                    return
                }
                Toast.makeText(activity, result, Toast.LENGTH_LONG).show()
                it.mainBinding.progressBar.visibility = View.GONE
            }*/
        }
    }
}