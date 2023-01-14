package edu.miu.quizapp.ui

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import edu.miu.quizapp.R
import edu.miu.quizapp.utils.BaseFragment
import edu.miu.quizapp.utils.PrefManager

class WelcomeFragment : BaseFragment() {

    private lateinit var btnStart: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        btnStart = view.findViewById(R.id.startBtn)
        changeStatusBarColor()

        btnStart.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_welcomeFragment_to_homeFragment)

        }
        return view
    }

    private fun launchHomeScreen(view: View? = null) {
        Navigation.findNavController(requireView())
            .navigate(R.id.action_welcomeFragment_to_homeFragment)
    }

    private fun changeStatusBarColor() {
        val window: Window? = activity?.window
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.statusBarColor = Color.TRANSPARENT
    }

    }