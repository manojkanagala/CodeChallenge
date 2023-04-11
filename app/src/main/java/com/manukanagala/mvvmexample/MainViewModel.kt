package com.manukanagala.mvvmexample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(), CoroutineScope by MainScope() {
    companion object {
        const val LOG = "GetPhoneModelData"
    }

    private val phoneModelLiveData = MutableLiveData<List<PhoneModel>>()
    val phoneModelData: LiveData<List<PhoneModel>>
        get() = phoneModelLiveData

    fun getSmartPhones() {
        launch(Dispatchers.Main) {
            try {
                val response = ServiceBuilder.apiService.getSmartphone()
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.products?.let {
                        phoneModelLiveData.value = it
                        Log.d(LOG, it.toString())
                    }
                } else {
                    Log.d(LOG, "Server error")
                }
            } catch (exception: Exception) {
                exception.message?.let {
                    Log.d(LOG, it)
                }
            }
        }
    }

}