package kz.zhandos.lib.coreui.base

sealed interface ViewState {
    data class Data<T>(val data: T) : ViewState

    object Loading : ViewState

    object Error : ViewState
}
