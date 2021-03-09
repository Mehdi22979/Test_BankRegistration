package com.quantum.vpn.ui.activity

import androidx.fragment.app.FragmentTransaction
import com.quantum.vpn.R
import com.quantum.vpn.base.BaseActivity
import com.quantum.vpn.ui.fragment.MainFragment
import com.quantum.vpn.ui.viewmodel.MainActivityViewModel

class MainActivity : BaseActivity<MainActivityViewModel>() {

    private var mainFragment: MainFragment? = null
    private var fragmentTransaction: FragmentTransaction? = null

    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun initializeViews() {
        initFragment()
    }

    private fun initFragment() {
        mainFragment = MainFragment()
        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction!!.replace(R.id.frameLayout, mainFragment!!, "MainFragment")
        fragmentTransaction!!.commit()
    }

}