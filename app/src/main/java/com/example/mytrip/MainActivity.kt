package com.example.mytrip

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mytrip.databinding.ActivityMainBinding
import com.example.mytrip.viewmodels.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    /**
     * Função responsável por fazer a criação da Activity
     * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            this.lifecycleOwner = this@MainActivity
            this.viewModel = mainViewModel
        }

    }

}
