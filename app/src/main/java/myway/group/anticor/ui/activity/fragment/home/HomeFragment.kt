package myway.group.anticor.ui.activity.fragment.home

import android.os.Bundle
import android.view.WindowManager
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*
import myway.group.anticor.R
import myway.group.anticor.ui.activity.BaseFragment

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    override fun initialize() {
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUpListeners()
        requireActivity().window
            .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }
    private fun setUpListeners() {
        tv_category_title1.setOnClickListener {
             findNavController().navigate(R.id.SendFragment)

         }

        tv_category_title2.setOnClickListener {
            findNavController().navigate(R.id.SendFragment)
        }

        tv_category_title3.setOnClickListener {
            findNavController().navigate(R.id.SendFragment)
        }

        tv_category_title4.setOnClickListener {
            findNavController().navigate(R.id.SendFragment)
        }
        /*  swipe_refresh_home.setOnRefreshListener {
              homeViewModel.getCategories()
          }*/

        /* categoryAdapter.setOnClickListener {
             val actions = HomeFragmentDirections.actionNavHomeToCategoryFragment(it.id)
             findNavController().navigate(actions)
         }

         topCourseAdapter.setOnClickListener {
             val action = HomeFragmentDirections.actionNavHomeToCourseFragment(it)
             if (findNavController().currentDestination?.id == R.id.nav_home)
                 findNavController().navigate(action)
         }*/
    }
}

