package com.example.game.ui.game

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import com.example.game.ui.base.BaseViewModel

class GameViewModel:BaseViewModel<Navigator>() {
    val timerText = MutableLiveData<String>()
    val counterLayout = MutableLiveData<Boolean>(true)

    fun startTimer() {
        object : CountDownTimer(10000, 1) {

            override fun onTick(millisUntilFinished: Long) {
                var mil = millisUntilFinished%1000
                var sec = millisUntilFinished/1000
                timerText.value = ("seconds remaining:\n "+sec+"." + mil )
            }

            override fun onFinish() {
                counterLayout.value = false
                timerText.value = ("done!")
            }
        }.start()
    }
}