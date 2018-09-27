package com.aman.user.mvpkotlin.Utilities.mvp

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by Amanpreet Singh on 28 Aug 2018.
 */
abstract class BaseMvpActivity<in V : BaseObject.BaseView, T : BaseObject.BasePresenter<V>>
: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attachView(this as V)

    }

    override fun onStart() {
        super.onStart()
    //    EventBus.getDefault().register(this);
    }

     fun getContext(): Context = this

    protected abstract var mPresenter: T

     fun showError(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

     fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
       // EventBus.getDefault().unregister(this);
    }
}