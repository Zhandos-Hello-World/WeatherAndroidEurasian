package kz.zhandos.lib.coreui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kz.zhandos.lib.core.error.handling.ErrorHandler
import kz.zhandos.lib.core.events.SystemEvent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseViewModel : ViewModel(), KoinComponent {
    private val _event = MutableSharedFlow<SystemEvent>()
    val event: SharedFlow<SystemEvent> = _event.asSharedFlow()
    private val errorHandler: ErrorHandler by inject()
    val router: Router by inject()

    fun <T> dataRequest(
        dispatcher: CoroutineDispatcher = Dispatchers.Default,
        loading: ((Boolean) -> Unit)? = null,
        request: suspend () -> T,
        onSuccess: ((T) -> Unit)? = null,
        shouldUseBasicErrorHandler: Boolean = true,
        onError: ((Throwable) -> Unit)? = null,
        finally: (() -> Unit)? = null,
    ) = viewModelScope.launch(dispatcher) {
        try {
            loading?.invoke(true)
            val response = request()
            loading?.invoke(false)
            onSuccess?.invoke(response)
        } catch (e: CancellationException) {
            loading?.invoke(false)
        } catch (e: Throwable) {
            loading?.invoke(false)
            onError?.invoke(e)
            if (shouldUseBasicErrorHandler) {
                errorHandler.handleError(e)
            }
        } finally {
            finally?.invoke()
        }
    }

    fun notifyEvent(event: SystemEvent) {
        _event.tryEmit(event)
    }
}