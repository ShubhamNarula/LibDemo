package com.example.samplepolkadot.base


import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.Fragment
import com.example.polka_lib.R

abstract class BaseFragment : Fragment() {


    /**
     * To show progress
     */
    var mProgressDialog: Dialog? = null


    /**
     * Can be used to show Log messages
     */
    protected val TAG = javaClass.simpleName

    private var rootView: View? = null

    /********************* abstract method used to get view from child class ***************/

    /**
     * Called from onCreateView () Function
     */
    public abstract fun getLayoutID():Int

    /**
     * Called from onViewCreated () Function
     */
    public abstract fun onCreateView();

    /**************************************  Fragment Lifecycle Methods  ************************************************************************************/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(rootView == null) {
            rootView = inflater.inflate(getLayoutID(), container, false)
        } else{
            (rootView?.parent as? ViewGroup)?.removeView(rootView)
        }
        return rootView

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreateView()

    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStart() {
        super.onStart()
    }

    /********************************************* Show progress and hide progress ****************************************************************************************************/

//    fun showProgress(context:Context) {
//        if (mProgressDialog == null) {
//            mProgressDialog = Dialog(context, android.R.style.Theme_Translucent)
//            mProgressDialog?.window!!.requestFeature(Window.FEATURE_NO_TITLE)
//            mProgressDialog?.setContentView(R.layout.loader_half__layout)
//            mProgressDialog?.setCancelable(false)
//        }
//
//        mProgressDialog?.show()
//    }
//
//    fun hideProgress() {
//        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
//            mProgressDialog?.dismiss()
//        }
//    }


    /********************************************* Show progress and hide progress ****************************************************************************************************/

}