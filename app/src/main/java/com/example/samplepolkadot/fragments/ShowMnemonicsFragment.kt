package com.example.samplepolkadot.fragments

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.example.samplepolkadot.R
import com.example.samplepolkadot.base.BaseFragment
import com.lib.polkalib.PolkaUtils
import kotlinx.android.synthetic.main.show_mno_frag.*

class ShowMnemonicsFragment : BaseFragment() {


    override fun getLayoutID(): Int {
        return R.layout.show_mno_frag
    }

    override fun onCreateView() {
        onClick()
    }


    private fun onClick() {
        btnNext.setOnClickListener {
            showProgress(requireActivity())
            PolkaUtils { result ->
                hideProgress()
                val bundle = Bundle()
                bundle.putString("create_mno",result)
                findNavController().navigate(R.id.action_showMnemonicsFragment_to_sendFragment2,bundle)
            }.importMnemonics(
                requireActivity(),
                "already gold shoot famous excess uncle remind flock lucky announce gain blind"
            )
        }
    }
}