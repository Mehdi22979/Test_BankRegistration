package com.quantum.vpn.ui.fragment

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.quantum.vpn.R
import com.quantum.vpn.base.BaseFragment
import com.quantum.vpn.ui.fragment.dashboard.DaggerMainComponent
import com.quantum.vpn.ui.listener.DateValidator
import com.quantum.vpn.ui.viewmodel.MainFragmentViewModel
import com.quantum.vpn.utils.AppUtils
import com.quantum.vpn.utils.DateValidatorUsingDateFormat
import javax.inject.Inject


/**
 * Created by Meenu Singh on 08/03/2021.
 */
class MainFragment : BaseFragment<MainFragmentViewModel>(), TextWatcher {
    private var tvPAN: EditText? = null
    private var tvNoPAN: TextView? = null
    private var btnNext: Button? = null
    private lateinit var etDay: EditText
    private lateinit var etMonth: EditText
    private lateinit var etYear: EditText

    private lateinit var validator: DateValidator
    private var maineDate: String = ""

    private var mViewModel: MainFragmentViewModel? = null

    @Inject
    lateinit var viewModelFactory: MainFragmentViewModel.Factory

    override fun getLayoutResource(): Int {
        return R.layout.fragment_main
    }

    override fun getViewModelClass(): Class<MainFragmentViewModel> {
        return MainFragmentViewModel::class.java
    }

    override fun getViewModelFactoryClass(): ViewModelProvider.Factory {
        return viewModelFactory
    }

    override fun setViewModel(viewModel: MainFragmentViewModel?) {
        mViewModel = viewModel
    }

    override fun initViews(view: View) {
        tvPAN = view.findViewById(R.id.tvPAN)
        tvNoPAN = view.findViewById(R.id.tvNoPAN)
        btnNext = view.findViewById(R.id.btnNext)
        etDay = view.findViewById(R.id.etDay)
        etMonth = view.findViewById(R.id.etMonth)
        etYear = view.findViewById(R.id.etYear)

        validator = DateValidatorUsingDateFormat("dd/MM/yyyy")

        tvPAN?.addTextChangedListener(this)
        etDay.addTextChangedListener(this)
        etMonth.addTextChangedListener(this)
        etYear.addTextChangedListener(this)
    }

    override fun setUpViewData() {
        tvNoPAN?.setOnClickListener { activity?.finish() }

        btnNext?.setOnClickListener {
            if (AppUtils.isPanCardValid(tvPAN?.text.toString()) && validator.isValid(maineDate)) {
                showMessage("Details Submitted Successfully")
                activity?.finish()
            }
        }
    }


    override fun initialiseDaggerComponent() {
        val dashboardComponent = DaggerMainComponent.builder().build()
        dashboardComponent.inject(this)
    }

    override fun showProgressDialog() {
    }

    override fun hideProgressDialog() {
    }

    override fun showError(errorMessage: String) {
    }

    override fun hideError() {
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        maineDate =
            etDay.text.toString() + "/" + etMonth.text.toString() + "/" + etYear.text.toString()

        if (AppUtils.isPanCardValid(tvPAN?.text.toString()) && validator.isValid(maineDate)) {
            btnNext?.background = resources.getDrawable(R.drawable.btn_connect)
        }
    }

    override fun afterTextChanged(p0: Editable?) {

    }
}