package kz.zhandos.lib.navigation.domain

import androidx.fragment.app.FragmentActivity
import com.github.terrakok.cicerone.NavigatorHolder

interface NavigationDelegate {
    fun onResumeFragmentsNavigator()
    fun onPauseFragmentsNavigator()
    fun registerNavigatorDelegate(
        activity: FragmentActivity,
        containerId: Int,
        navHolder: NavigatorHolder,
    )
}