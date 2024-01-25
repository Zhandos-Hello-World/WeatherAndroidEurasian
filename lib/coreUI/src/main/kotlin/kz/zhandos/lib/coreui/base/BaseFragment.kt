package kz.zhandos.lib.coreui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.launch
import kz.zhandos.lib.core.events.SystemEvent

abstract class BaseFragment<V : BaseViewModel, Binding : ViewBinding>
    : Fragment() {
    abstract val viewModel: V
    private var _viewBinding: Binding? = null
    protected val viewBinding get() = _viewBinding!!

    abstract fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?): Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _viewBinding = inflateViewBinding(inflater, container)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.event.collect(::onActionEvent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

    open fun onActionEvent(event: SystemEvent) {}

}