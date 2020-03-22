package com.tamimattafi.backend.demo.global.utils

import com.tamimattafi.backend.demo.global.ICoreContract.*
import com.tamimattafi.backend.demo.global.callbacks.CallbackError
import java.lang.Exception

object CallbackUtils {

    fun Exception.toCallbackError(): ICallbackError
        = CallbackError(message, localizedMessage)

    fun ICallbackError.stringify(): String
        = "Callback Error: " +
            "\n message: $message" +
            "\n localized message: $localizedMessage" +
            "\n code: $code"

}