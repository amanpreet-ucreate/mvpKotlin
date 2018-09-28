package com.aman.user.mvpkotlin.Fragments.OneFragment

import android.util.Log
import com.aman.user.mvpkotlin.Models.Pojos
import com.aman.user.mvpkotlin.Utilities.mvp.BasePresenterImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.junit.Test

class FirstFragPresenterImpl : BasePresenterImpl<ViewContract.View>(), ViewContract.Presenter {

    var arrList : List<Pojos.SearchItem> = ArrayList()

    @Test
    override fun executeAPI(): List<Pojos.SearchItem> {

        showProgressDialog()
        webservice.getData("query", "json", "search", "Trump")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).doOnError {
                    println("ERROR:  #${it.printStackTrace()}")

                }
                .subscribe ({
                    result ->
                    Log.e("Result: ",">>   "+result.toString())
                    Log.e("Result", "There are ${result.query.search?.size} Java developers in Lagos")
                    if(result.query.search?.size!! > 0){
                        arrList = result.query.search
                        mView?.showData(arrList)
                        hideProgressDialog()
                    }

                }, { error ->
                    error.printStackTrace()
                })

        return arrList

    }

}