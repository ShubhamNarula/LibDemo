package com.example.samplepolkadot.fragments

import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.polka_lib.PolkaResult
import com.example.samplepolkadot.R
import com.example.samplepolkadot.base.BaseFragment
import com.lib.polkalib.PolkaUtils
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : BaseFragment() {
    override fun getLayoutID(): Int {
        return R.layout.main_fragment
    }

    override fun onCreateView() {
        onClick()
    }

    private fun onClick() {


        PolkaResult {
            hideProgress()
            Toast.makeText(requireActivity(), "$it", Toast.LENGTH_SHORT).show()
        }.getTransCall(requireActivity(),"","","","")
        btnCreate.setOnClickListener {
            showProgress(requireActivity())

//            PolkaUtils { result ->
//                navigateScreen(result)
//            }.createMnemonics(requireActivity())
        }
        btnImport.setOnClickListener {

            findNavController().navigate(R.id.action_mainFragment_to_showMnemonicsFragment, null)

        }
    }

    private fun navigateScreen(result: String) {
        hideProgress()
        val bundle = Bundle()
        bundle.putString("create_mno", result)
        findNavController().navigate(R.id.action_mainFragment_to_showMnemonicsFragment, bundle)
    }
}