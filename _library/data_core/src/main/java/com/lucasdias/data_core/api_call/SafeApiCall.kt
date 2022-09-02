package com.lucasdias.data_core.api_call

suspend fun <T> safeApiCall(call: suspend () -> T): ApiCallState<T> {
    return runCatching {
        call()
    }.fold(
        { ApiCallState.Success(it) },
        { ApiCallState.Error(it) }
    )
}
