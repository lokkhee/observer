package com.example.observer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var counterViewModel: CounterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity","OnCreated")
        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)

        counterViewModel.getCounter.observe( this , Observer {
            textViewContent.text = counterViewModel.getCounter.value.toString()

            if( it.equals(10)) goodLuck()
        })

        //textViewContent.text = counterViewModel.getCounter.value.toString()

        buttonplus.setOnClickListener {
            counterViewModel.increment()

        }

        buttonneg.setOnClickListener {
            counterViewModel.decrement()


        }
    }
    private fun goodLuck(){
        Toast.makeText( applicationContext,"good luck !!!", Toast.LENGTH_SHORT).show()

    }
    override fun onDestroy() {
        Log.d("MainActivity","onDestroy")
        super.onDestroy()
    }
}
