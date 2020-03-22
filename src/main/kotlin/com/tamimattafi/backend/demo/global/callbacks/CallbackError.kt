package com.tamimattafi.backend.demo.global.callbacks

import com.tamimattafi.backend.demo.global.ICoreContract.ICallbackError

/**
 * Implementation of ICallbackError
 *
 * @see ICallbackError for more information
 *
 */
data class CallbackError(



    /**
     * @see ICallbackError.message for more information
     *
     */
    override var message: String? = null,



    /**
     * @see ICallbackError.localizedMessage for more information
     *
     */
    override var localizedMessage: String? = null,



    /**
     * @see ICallbackError.code for more information
     *
     */
    override var code: Int? = null



) : ICallbackError