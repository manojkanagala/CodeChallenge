package com.manukanagala.mvvmexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //Initiating Recyclerview
        val recyclerView: RecyclerView = findViewById(R.id.phone_list)
        val phoneListAdapter = PhoneListAdapter(PhoneListAdapter
            .PhoneModelListener { phone: PhoneModel ->
            val intent = Intent(this, ProductDetailsActivity::class.java)
                intent.putExtra("PHONE_DATA", phone)
            startActivity(intent)
        })
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = phoneListAdapter
        }

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            viewModel.getSmartPhones()
        }

        viewModel.phoneModelData.observe(
            this,
            {
                Log.d("Response", it.toString())
                phoneListAdapter.setPhoneList(it)
            }
        )

    }
}