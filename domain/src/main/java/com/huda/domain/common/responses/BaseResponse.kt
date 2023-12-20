package com.huda.domain.common.responses

data class BaseResponse<T>(
    var response: T? = null,
    var errorResponse: ErrorResponse? = null,
    var status: Boolean = false,
)