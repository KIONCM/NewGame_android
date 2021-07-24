package com.example.game.ui.game

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.game.R
import com.example.game.databinding.ActivityGameBinding
import com.example.game.ui.base.BaseActivity

class GameActivity : BaseActivity<GameViewModel,ActivityGameBinding>(),Navigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game)
        var count = 0
        binding?.counterLayout?.setOnClickListener {
            count++
            binding?.tvCounter?.text = count.toString()
        }

        /*val alertDialog = AlertDialog.Builder(this).setTitle("Get Ready !")
            .setMessage("Timer will start immediately after press \"OK\" ").setCancelable(false)
            .setPositiveButton("OK",DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
                startTimer()
            }).show()*/

        showDialog(title = "Get Ready !",message ="Timer will start immediately after press \"OK\" ","OK",DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
            viewModel?.startTimer()
        } )
        observers()


    }

    /*private fun startTimer() {
        object : CountDownTimer(10000, 1) {

            override fun onTick(millisUntilFinished: Long) {
                var mil = millisUntilFinished%1000
                var sec = millisUntilFinished/1000
                binding!!.tvTimer.text = ("seconds remaining:\n "+sec+"." + mil )
            }

            override fun onFinish() {
                binding!!.counterLayout.isEnabled = false
                binding!!.tvTimer.text = ("done!")
            }
        }.start()
    }*/

    private fun observers(){
        viewModel?.timerText?.observe(this, Observer {
            binding?.tvTimer?.text = it
        })

        viewModel?.counterLayout?.observe(this, Observer {
            binding?.counterLayout?.isEnabled = it
        })

    }
    override fun initializeViewModel()= GameViewModel()

    override fun inflateLayout() = R.layout.activity_game
}