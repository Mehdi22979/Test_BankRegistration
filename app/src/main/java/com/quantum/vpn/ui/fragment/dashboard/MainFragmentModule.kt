package com.quantum.vpn.ui.fragment.dashboard

import com.quantum.vpn.ui.viewmodel.MainFragmentViewModel
import dagger.Module
import dagger.Provides


@Module
class MainFragmentModule {

    @Provides
    internal fun provideDashboardViewModel(): MainFragmentViewModel {
        return MainFragmentViewModel()
    }


    /* Receive FeatureViewModel provider and pass it to factory */
    @Provides
    fun provideFeatureViewModelFactory() =
        MainFragmentViewModel.Factory()
}