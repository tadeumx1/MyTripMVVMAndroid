package com.example.mytrip

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mytrip.databinding.ActivityMainBinding
import com.example.mytrip.viewmodels.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    /**
     * Função responsável por fazer a criação da Activity
     * */

    val mainViewModel: MainActivityViewModel by lazy { ViewModelProviders.of(this).get(MainActivityViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            this.lifecycleOwner = this@MainActivity
            this.viewModel = mainViewModel
        }

        getError()

    }

    private fun getError() {

        mainViewModel.getError().observe(this, Observer { value ->
            if(value != null) {
                Toast.makeText(application, value.toString(), Toast.LENGTH_LONG).show();
            }
        })

    }


}
