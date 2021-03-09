package com.quantum.vpn.ui.fragment.dashboard

import com.quantum.vpn.ui.fragment.MainFragment
import dagger.Component
import javax.inject.Named

@Named
@Component(modules = [(MainFragmentModule::class)])
interface MainComponent {
    /**
     * Injects required dependencies into the specified PostViewModel.
     * @param MainFragmentViewModel BaseViewModel in which to inject the dependencies
     */
    fun inject(fragment: MainFragment)

    @Component.Builder
    interface Builder {
        fun build(): MainComponent

    }
}