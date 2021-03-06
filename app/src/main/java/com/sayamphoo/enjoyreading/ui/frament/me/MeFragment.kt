package com.sayamphoo.enjoyreading.ui.frament.me

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sayamphoo.enjoyreading.R
import com.sayamphoo.enjoyreading.ui.frament.me.adapter.MeRecyclerAdapter
import com.sayamphoo.enjoyreading.ui.frament.me.modle.Coins
import com.sayamphoo.enjoyreading.ui.frament.me.modle.MeDataViewItem
import com.sayamphoo.enjoyreading.ui.frament.me.modle.Menu
import com.sayamphoo.enjoyreading.ui.frament.me.modle.Profile
import kotlinx.android.synthetic.main.fragment_me.*

class MeFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_me, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val mMenuName = arrayListOf(
            "การตั้งค่า",
            "เกียวกับ",
            "ออกจากระบบ"
        )

        val mMenuIcon = arrayListOf(
            R.drawable.ic_settings,
            R.drawable.ic_about,
            R.drawable.ic_logout
        )

        val items = ArrayList<MeDataViewItem>()

        items.add(
            MeDataViewItem(
                0,
                profile = Profile(
                    "sayamphoo",
                    "id"
                )
            )
        )
        items.add(
            MeDataViewItem(
                1,
                coins = Coins("100")
            )
        )

        for (i in 0..2) {
            items.add(
                MeDataViewItem(
                    2,
                    menu = Menu(
                        mMenuName[i],
                        mMenuIcon[i]
                    )
                )
            )
        }

        meRecycler.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        meRecycler.adapter =
            MeRecyclerAdapter(items)
    }

}
