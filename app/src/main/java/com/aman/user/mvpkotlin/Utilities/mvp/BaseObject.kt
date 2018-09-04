package com.aman.user.mvpkotlin.Utilities.mvp

import android.content.Context

object BaseObject {

    /**
     * Created by amanpreet singh on 20/4/18.
     */
    interface BaseView {

        fun getContext(): Context

        fun showError(error: String?)

        fun showMessage(message: String)

    }

    interface BasePresenter<in V : BaseView> {

        fun attachView(view: V)

        fun detachView()

        fun showProgressDialog()

        fun hideProgressDialog()
    }
}