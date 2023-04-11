package com.manukanagala.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ProductDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val phoneModel = intent.getParcelableExtra<PhoneModel>("PHONE_DATA")

        val price: TextView = findViewById(R.id.price_value)
        val description: TextView = findViewById(R.id.description_content)
        val imageView: ImageView = findViewById(R.id.imageView2)
        val title: TextView = findViewById(R.id.title)

        price.text = phoneModel!!.price.toString()
        description.text = phoneModel.description
        title.text = phoneModel.title
        Glide.with(imageView.context).load(phoneModel.thumbnail).into(imageView)

    }
}