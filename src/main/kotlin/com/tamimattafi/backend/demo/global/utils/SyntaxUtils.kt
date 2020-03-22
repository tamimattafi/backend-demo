package com.tamimattafi.backend.demo.global.utils


object SyntaxUtils {

    const val TRY_CATCH_TAG = "TryCatchBlock"

    fun <T> tryCatch(tag: String = TRY_CATCH_TAG, action: () -> T): T?
            = try {
                action.invoke()
            } catch (e: Exception) {
                print(e)
                e.printStackTrace()
                null
            }


    const val TRY_CALL_TAG = "TryCallBlock"

    fun <T> T?.tryCall(condition: Boolean = true, tag: String = TRY_CALL_TAG, action: T.() -> Unit)
            = this?.takeIf { condition }?.let {
        tryCatch(tag) {
            action.invoke(it)
        }
            }


}