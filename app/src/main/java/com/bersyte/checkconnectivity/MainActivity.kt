package com.bersyte.checkconnectivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bersyte.checkconnectivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var connectivityLiveData: ConnectionLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkNetworkConnectionLiveData()
    }

    private fun checkNetworkConnectionLiveData() {

        connectivityLiveData = ConnectionLiveData(application)

        connectivityLiveData.observe(this, { isAvailable ->

            when (isAvailable) {
                true -> binding.tvConnection.text = "Has Internet Connection"
                false -> binding.tvConnection.text = "No Internet Connection"
            }
        })

    }
}