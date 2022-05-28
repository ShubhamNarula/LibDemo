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
            "5Fz3kFo7yLp65zBxGnHbmUbZBB33JqYCXRMp3LBKeVBtmpQS",
            "already gold shoot famous excess uncle remind flock lucky announce gain blind",
            "0.01",
            "5Hof7tJS4rkQykAtUEKUCcMwdnarhypbnKsuNF2VKdXTbVtd"
        )
    }


}