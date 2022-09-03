package com.lucasdias.data_core.api_call

import com.lucasdias.core.state.State

sealed class ApiState<out T> {
    data class Success<out T>(val data: T) : ApiState<T>()
    class Empty<out T>() : ApiState<T>()
    data class Error<T>(val throwable: Throwable) : ApiState<T>()
}

fun <I, O> ApiState<I>.mapToDomainState(onSuccess: (I) -> State.Success<O>): State<O> =
    when (this) {
        is ApiState.Success -> onSuccess(data)
        is ApiState.Empty -> State.Empty()
        is ApiState.Error -> State.Error(throwable)
    }
