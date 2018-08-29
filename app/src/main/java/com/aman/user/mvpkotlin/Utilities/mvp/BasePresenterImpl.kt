package com.aman.user.mvpkotlin.Utilities.mvp

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.aman.user.mvpkotlin.R
import com.aman.user.mvpkotlin.Utilities.api.WebserviceMethods

/**
 * Created by Amanpreet Singh on 28 Aug 2018.
 */
open class BasePresenterImpl<V : BaseObject.BaseView> {


    protected var mView: V? = null
    protected var webservice = WebserviceMethods.create()
    protected lateinit var dialog: Dialog



     fun attachView(view: V) {
        mView = view
        dialog = Dialog(mView?.getContext())
        dialog.setContentView(R.layout.progressdialog)
        dialog.setCancelable(false)
        dialog.getWindow().setBackgroundDrawable( ColorDrawable(Color.TRANSPARENT));
     //   dialog.getWindow().setFlags(Layou.FLAG_FULLSCREEN, LayoutParams.FLAG_FULLSCREEN);


    }

     fun detachView() {
        mView = null
    }
     fun showProgressDialog() {
        dialog.show()
    }

     fun hideProgressDialog() {
        dialog.hide()
    }
}