package com.quantum.vpn.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable


abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    private var subscription: MutableList<Disposable>? = null

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
        if (subscription != null) {
            if (subscription!!.isNotEmpty()) {
                subscription!!.forEach { disposable -> disposable.dispose() }
            }

        }
    }
}