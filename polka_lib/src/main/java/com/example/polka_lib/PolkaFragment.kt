package com.example.polka_lib

import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.samplepolkadot.base.BaseFragment

class PolkaFragment : BaseFragment() {
    override fun getLayoutID(): Int {
        return R.layout.polka_frag
    }

    override fun onCreateView() {
        val btnSend = requireView().findViewById<Button>(R.id.btnSend)
        btnSend.setOnClickListener {
            Toast.makeText(requireActivity(), "Please wait....", Toast.LENGTH_SHORT).show()
            PolkaResult {
                Log.e("HashKey", "onCreateView: ${it}", )
            }.getTransCall(
                requireActivity(),
                "5Fz3kFo7yLp65zBxGnHbmUbZBB33JqYCXRMp3LBKeVBtmpQS",
                "already gold shoot famous excess uncle remind flock lucky announce gain blind",
                "0.01",
                "5Hof7tJS4rkQykAtUEKUCcMwdnarhypbnKsuNF2VKdXTbVtd"
            )
        }
    }

}