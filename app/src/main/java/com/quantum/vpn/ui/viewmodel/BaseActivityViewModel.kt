package com.quantum.vpn.ui.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable

class BaseActivityViewModel : ViewModel() {

    private var disposable: Disposable? = null

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

}