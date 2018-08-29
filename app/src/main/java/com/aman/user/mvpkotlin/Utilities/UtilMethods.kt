package com.aman.user.tablayoutkotlin.Utilres

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

class UtilMethods(ctx : Context) {

    var context: Context

    init {
        this.context = ctx
    }


    fun AddFragment(container: Int, frag: Fragment) {
        (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .add(container,frag).addToBackStack(context.packageName).commitAllowingStateLoss()

    }

    fun ReplaceFragment(container: Int, frag: Fragment) {
        (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(container,frag).addToBackStack(context.packageName).commitAllowingStateLoss()

    }


}
