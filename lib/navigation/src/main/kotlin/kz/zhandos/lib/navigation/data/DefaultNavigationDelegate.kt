package kz.zhandos.lib.navigation.data

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.DefaultLifecycleObserver
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import kz.zhandos.lib.navigation.domain.NavigationDelegate

class DefaultNavigationDelegate: NavigationDelegate, DefaultLifecycleObserver {
    private lateinit var navigatorHolder: NavigatorHolder
    private lateinit var navigator: Navigator

    override fun registerNavigatorDelegate(
        activity: FragmentActivity,
        containerId: Int,
        navHolder: NavigatorHolder,
    ) {
        this.navigatorHolder = navHolder
        activity.lifecycle.addObserver(this)
        navigator = MyNavigator(activity, containerId)
    }

    override fun onResumeFragmentsNavigator() {
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPauseFragmentsNavigator() {
        navigatorHolder.removeNavigator()
    }

}