package com.aman.user.mvpkotlin.Fragments.SecondFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.aman.user.mvpkotlin.R
import com.aman.user.mvpkotlin.Utilities.EventBus.Eventbus
import com.aman.user.mvpkotlin.Utilities.mvp.BaseMvpFragment

class SecondFragFragment : BaseMvpFragment<ViewContractSecondFrag.View, ViewContractSecondFrag.Presenter>(), ViewContractSecondFrag.View {


    override var mPresenter: ViewContractSecondFrag.Presenter = SecondFragPresenter()


    companion object {

        fun newInstance(): SecondFragFragment {
            return SecondFragFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second_frag, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Eventbus.listen(String::class.java).subscribe({
            if(activity!=null) {
                Toast.makeText(activity, "Recieved in SecondFrag: " + it, Toast.LENGTH_SHORT).show()
            }else{
                println("ACTIVTTY IS NULL")
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }

    override fun showData() {

    }

}