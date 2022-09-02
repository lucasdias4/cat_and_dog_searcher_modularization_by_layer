package com.lucasdias.data_core.api_call

import com.lucasdias.core.state.State

sealed class ApiCallState<out T> {
    data class Success<out T>(val data: T) : ApiCallState<T>()
    data class Error<T>(val throwable: Throwable) : ApiCallState<T>()
}

fun <I, O> ApiCallState<I>.mapToDomainState(onSuccess: (I) -> State.Success<O>): State<O> =
    when (this) {
        is ApiCallState.Success -> onSuccess(data)
        is ApiCallState.Error -> State.Error(throwable)
    }
