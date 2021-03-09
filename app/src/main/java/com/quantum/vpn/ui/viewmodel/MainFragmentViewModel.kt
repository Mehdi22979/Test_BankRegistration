package com.quantum.vpn.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.quantum.vpn.base.BaseViewModel
import io.reactivex.disposables.Disposable

/**
 * Created by Meenu Singh on 08/03/2021.
 */

class MainFragmentViewModel : BaseViewModel() {

    class Factory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainFragmentViewModel() as T // Delegate call to provider
        }
    }


    private var disposable: Disposable? = null

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

}