package com.quantum.vpn.ui.viewmodel

import com.quantum.vpn.base.BaseViewModel
import io.reactivex.disposables.Disposable

class MainActivityViewModel : BaseViewModel() {

    private var disposable: Disposable? = null

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

}