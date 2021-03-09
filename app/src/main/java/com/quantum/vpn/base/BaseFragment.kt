package com.quantum.vpn.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment<T : BaseViewModel> : Fragment() {
    private val TAG: String = "BaseFragment"

    private var viewModel: T? = null

    @LayoutRes
    protected abstract fun getLayoutResource(): Int

    protected abstract fun getViewModelClass(): Class<T>?
    protected abstract fun getViewModelFactoryClass(): ViewModelProvider.Factory?
    protected abstract fun setViewModel(viewModel: T?)
    protected abstract fun initViews(view: View)
    protected abstract fun setUpViewData()
    protected abstract fun initialiseDaggerComponent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "BaseFragment - onCreate")
        initialiseDaggerComponent()
        setUpViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutResource(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setUpViewData()
    }

    private fun setUpViewModel() {
        viewModel = (activity as BaseActivity<*>).getViewModel(
            getViewModelFactoryClass(),
            getViewModelClass()
        )
        setViewModel(viewModel)
        setupObserver()
        Log.e(TAG, "BaseFragment - setUpViewModel")
    }

    private fun setupObserver() {
        viewModel?.errorMessage?.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })

        viewModel?.loadingVisibility?.observe(this, Observer { visibilityStatus ->
            if (visibilityStatus == View.VISIBLE) showProgressDialog() else hideProgressDialog()
        })
    }

    abstract fun showProgressDialog()

    abstract fun hideProgressDialog()

    abstract fun showError(errorMessage: String)

    abstract fun hideError()

    fun showMessage(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}