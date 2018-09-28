package com.aman.user.mvpkotlin.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.aman.user.mvpkotlin.Fragments.OneFragment.Main2ActivityFragment
import com.aman.user.mvpkotlin.Fragments.SecondFragment.SecondFragFragment
import com.aman.user.mvpkotlin.R
import com.aman.user.mvpkotlin.Utilities.EventBus.Eventbus
import com.aman.user.tablayoutkotlin.Utilres.UtilMethods
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity : AppCompatActivity() {

    var utilMethods : UtilMethods = UtilMethods(this@MainActivity)

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        utilMethods.AddFragment(R.id.fragment, Main2ActivityFragment.newInstance())


         fab.setOnClickListener({
             utilMethods.ReplaceFragment(R.id.fragment, SecondFragFragment.newInstance())
         })
        Eventbus.listenSticky(String::class.java).subscribe({

            Toast.makeText(applicationContext,"Recieved: "+it,Toast.LENGTH_SHORT).show()

       })

    }


}
