package com.aman.user.mvpkotlin.Fragments.SecondFragment

import com.aman.user.mvpkotlin.Utilities.mvp.BaseObject


object ViewContractSecondFrag {

    interface View : BaseObject.BaseView {

        fun showData()

    }

    interface Presenter : BaseObject.BasePresenter<View> {

        fun getData()

    }
}