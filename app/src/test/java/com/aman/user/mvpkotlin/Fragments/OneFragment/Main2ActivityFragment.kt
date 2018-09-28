package com.aman.user.mvpkotlin.Fragments.OneFragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.aman.user.mvpkotlin.Models.Pojos
import com.aman.user.mvpkotlin.R
import com.aman.user.mvpkotlin.Utilities.EventBus.Eventbus
import com.aman.user.mvpkotlin.Utilities.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_main2.*
import org.junit.Test


/**
 * A placeholder fragment containing a simple view.
 */
class Main2ActivityFragment : BaseMvpFragment<ViewContract.View, ViewContract.Presenter>(), ViewContract.View {

    val string = "amanp3535reet singh"

    companion object {
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(): Main2ActivityFragment {
            val fragment = Main2ActivityFragment()

            return fragment
        }
    }
    override var mPresenter: ViewContract.Presenter = FirstFragPresenterImpl()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_main2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)

        mPresenter.executeAPI()
        //Some properties that can be used with String
        println("drop ${string.dropLast(2)}...")
        println("plus ${string.plus(2)}")
        println("isDigit ${string.filter { it.isLetter() }}")
        println("reversed ${string.reversed()}")
    }

    
    fun String.toUpperCasefirstLetter() : String{
        return this.substring(0,1).toUpperCase().plus(this.substring(1))
    }

    @Test
    override fun showData(arrrData: List<Pojos.SearchItem>) { //To change body of created functions use File | Settings | File Templates.
        recyclerview.adapter = RcyAdapter(resources.getStringArray(R.array.arrNames))
    }

    fun onItemClick(view: View) {
        Toast.makeText(activity, "CLICKED", Toast.LENGTH_SHORT).show()
    }

    class RcyAdapter(var arrData: Array<String>) : RecyclerView.Adapter<RcyAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_names, parent, false)
            return ViewHolder(v)
        }

        override fun getItemCount(): Int {
            return 5;
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindItems()

            holder.tvNamee.setText(arrData[position])
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            lateinit var tvNamee : TextView   // Using lateinit, the initial value does not need to be assigned.

            fun bindItems() = with(itemView)
            {
                tvNamee = itemView.findViewById(R.id.tvName) as TextView

                itemView.setOnClickListener {
                    //Which ever class/fragment is listening to this sticky will received this Name
                    Eventbus.publishSticky(tvNamee.text)
                }
            }
        }
    }

}

