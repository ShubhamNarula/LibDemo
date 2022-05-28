package com.example.polka_lib

import android.content.Context
import com.lib.polkalib.PolkaUtils

class PolkaResult(val onSuccess: (message: String) -> Unit) {

    fun getTransCall(
        context: Context,
        fromAdd: String,
        mnemonics: String,
        amount: String,
        toAddress: String
    ) {
        PolkaUtils {
            onSuccess(it)
        }.sendTrx(
            context,
            fromAdd,
            mnemonics,
            amount,
            toAddress
        )
    }


}