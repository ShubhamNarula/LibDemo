package com.example.samplepolkadot.fragments

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import com.example.samplepolkadot.R
import com.example.samplepolkadot.base.BaseFragment
import com.lib.polkalib.PolkaUtils
import kotlinx.android.synthetic.main.send_frag.*
import org.json.JSONObject

class SendFragment : BaseFragment() {

    private var data: String? = null

    private var hash : String ?=null

    override fun getLayoutID(): Int {
        return R.layout.send_frag
    }

    override fun onCreateView() {
        init()
    }

    fun init() {
        arguments.let {
            data = it?.getString("create_mno")
        }
        data?.let{
            val jsonObject = JSONObject(data)
            edtYourAddress.setText(jsonObject["address"].toString())
            edtReceiverAddress.setText("5FThCokUgAJSgbNSQJbGMioAB13sRtZZJxZd6f5s64Qp2BQs")
            onClick()
        }
    }

    private fun onClick() {
        btnSend.setOnClickListener {
            if (edtYourAddress.text.toString().trim().isEmpty() || edtAmount.text.toString().trim()
                    .isEmpty() || edtReceiverAddress.text.toString().trim().isEmpty()
            ){
                Toast.makeText(requireActivity(), "Fields can not be empty.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (btnSend.text.toString() == getString(R.string.view_in_explorer)){
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse("https://telemetry.peerclub.com/tx/" + hash)
                startActivity(i)

                return@setOnClickListener
            }

            data?.let {
                showProgress(requireActivity())
                val jsonObject = JSONObject(data)
//                PolkaUtils {
//                    hideProgress()
//                    Log.e("hashhhhh", it.toString())
//                }.sendTrx(
//                    requireActivity(),
//                    "5Fz3kFo7yLp65zBxGnHbmUbZBB33JqYCXRMp3LBKeVBtmpQS",
//                    "already gold shoot famous excess uncle remind flock lucky announce gain blind",
//                    "0.001",
//                    "5Hof7tJS4rkQykAtUEKUCcMwdnarhypbnKsuNF2VKdXTbVtd"
//                )
                PolkaUtils {result ->
                    hideProgress()
                    val jsonObj = JSONObject(result)
                    hash = jsonObj["hash"].toString()
                    Toast.makeText(requireActivity(), hash, Toast.LENGTH_SHORT).show()

                    btnSend.text = getString(R.string.view_in_explorer)

                }.sendTrx(
                    requireActivity(),
                    "5Fz3kFo7yLp65zBxGnHbmUbZBB33JqYCXRMp3LBKeVBtmpQS"
                    /*jsonObject["address"].toString()*/,
                    jsonObject["mnemonics"].toString(),
                    edtAmount.text.toString().trim(),
                    "5Hof7tJS4rkQykAtUEKUCcMwdnarhypbnKsuNF2VKdXTbVtd"
                    /*edtReceiverAddress.text.toString().trim()*/
                )
            }
        }


        btnView.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse("https://telemetry.peerclub.com/tx/" + hash)
            startActivity(i)

        }
    }
}