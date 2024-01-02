package com.bengisusahin.workmanagerk

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class RefreshDatabase(val context: Context, workerParams: WorkerParameters) : Worker(context,
    workerParams
) {
    override fun doWork(): Result {
        refreshDatabase()
        return Result.success()
    }

    private fun refreshDatabase(){
        val sharedPreferences = context.getSharedPreferences("com.bengisusahin.workmanagerk",Context.MODE_PRIVATE)
        var mySavedNumber = sharedPreferences.getInt("myNumber",0)
        mySavedNumber = mySavedNumber + 1
        println(mySavedNumber)
        sharedPreferences.edit().putInt("myNumber",mySavedNumber)
    }
}