package com.aman.user.mvpkotlin.Utilities.mvp

import android.content.Context
import android.support.annotation.StringRes

object BaseObject {

    /**
     * Created by amanpreet singh on 20/4/18.
     */
    interface BaseView {

        fun getContext(): Context

        fun showError(error: String?)

        fun showError(@StringRes stringResId: Int)

        fun showMessage(@StringRes srtResId: Int)

        fun showMessage(message: String)

    }

    interface BasePresenter<in V : BaseView> {

        fun attachView(view: V)

        fun detachView()

        fun showProgressDialog()

        fun hideProgressDialog()
    }
}