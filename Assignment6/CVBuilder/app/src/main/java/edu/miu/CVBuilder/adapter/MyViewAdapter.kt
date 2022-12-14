package edu.miu.CVBuilder.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import edu.miu.CVBuilder.data.Work
import edu.miu.CVBuilder.ui.fragments.AboutFragment
import edu.miu.CVBuilder.ui.fragments.ContactFragment
import edu.miu.CVBuilder.ui.fragments.HomeFragment
import edu.miu.CVBuilder.ui.fragments.WorkFragment

class MyViewAdapter(fm:FragmentManager,lc:Lifecycle) : FragmentStateAdapter(fm,lc) {
    override fun getItemCount(): Int = 4
    val workFragment = WorkFragment()
    override fun createFragment(position: Int): Fragment {
        return   when(position){
            0-> HomeFragment()
            1-> AboutFragment()
            2-> workFragment
            3-> ContactFragment()
            else-> Fragment()
        }
    }

    fun addWork(work: Work){
        workFragment.onAddWOrk(work)
    }
}

