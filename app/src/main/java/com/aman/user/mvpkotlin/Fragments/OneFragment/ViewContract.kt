package com.aman.user.mvpkotlin.Fragments.OneFragment

import com.aman.user.mvpkotlin.Models.Pojos
import com.aman.user.mvpkotlin.Utilities.mvp.BaseObject

object ViewContract {

    interface View : BaseObject.BaseView {
        fun showData(arrrData : List<Pojos.SearchItem>)
    }

    interface Presenter : BaseObject.BasePresenter<View> {
        fun executeAPI() : List<Pojos.SearchItem>
    }


}