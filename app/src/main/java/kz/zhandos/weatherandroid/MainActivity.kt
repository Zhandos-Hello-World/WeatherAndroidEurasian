package kz.zhandos.weatherandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.launch
import kz.zhandos.features.weather.presentation.navigation.Screens
import kz.zhandos.lib.core.events.SystemEvent
import kz.zhandos.lib.core.message.MessageEvent
import kz.zhandos.lib.coreui.R
import kz.zhandos.lib.coreui.ext.showAlert
import kz.zhandos.lib.navigation.data.DefaultNavigationDelegate
import kz.zhandos.lib.navigation.domain.NavigationDelegate
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), NavigationDelegate by DefaultNavigationDelegate() {
    private val viewModel: MainViewModel by viewModel()
    private val navigatorHolder: NavigatorHolder by inject()
    private val router: Router by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.collectMessage()
        subscribeToEvents()
        registerNavigatorDelegate(this, R.id.fragment_container, navigatorHolder)

        router.replaceScreen(Screens.CitySelection())
    }

    override fun onResume() {
        super.onResume()
        onResumeFragmentsNavigator()
    }

    override fun onPause() {
        super.onPause()
        onPauseFragmentsNavigator()
    }

    private fun subscribeToEvents() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect(::handleEvents)
            }
        }
    }

    private fun handleEvents(event: SystemEvent) {
        when (event) {
            is MessageEvent -> {
                showAlert(event)
            }
        }
    }
}
