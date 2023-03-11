package com.sherlock.gb.kotlin.intentstart

import android.app.IntentService
import android.content.Intent

private const val KEY_WAVE_SERVICE_BROADCAST = "myaction_way"
private const val KEY_WAVE_SERVICE_BROADCAST_MESSAGE = "message"

class SendService(val name: String = ""): IntentService(name) {
    override fun onHandleIntent(intent: Intent?) {
        intent?.let {
            val text = it.getStringExtra("editText")
            val message = Intent(KEY_WAVE_SERVICE_BROADCAST)
            message.putExtra(KEY_WAVE_SERVICE_BROADCAST_MESSAGE, text)
            sendBroadcast(message)
        }
    }
}