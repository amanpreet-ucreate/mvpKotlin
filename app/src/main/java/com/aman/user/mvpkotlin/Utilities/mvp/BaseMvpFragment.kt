package com.aman.user.mvpkotlin.Utilities.mvp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by Amanpreet Singh on 28 Aug 2018.
 */
abstract class BaseMvpFragment<in V : BaseObject.BaseView, T : BaseObject.BasePresenter<V>>
: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter.attachView(this as V)
    }


    override fun getContext(): Context = activity as AppCompatActivity

    protected abstract var mPresenter: T

     fun showError(error: String?) {
        Toast.makeText(activity, error, Toast.LENGTH_LONG).show()
    }

     fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

}