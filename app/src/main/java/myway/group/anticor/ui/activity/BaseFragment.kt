package myway.group.anticor.ui.activity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ColorRes
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import myway.group.anticor.R

abstract class BaseFragment(
    @LayoutRes private val layoutId: Int,
    @ColorRes private val statusBarColor:Int = R.color.white,
    private val isBottomNavVisible: Boolean = true
) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(!isBottomNavVisible)
        val mInflater =
            requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return mInflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setStatusBarColor()
        isBottomNavVisible()
    }

    private fun setStatusBarColor() {
        val window = requireActivity().window
        window.statusBarColor = resources.getColor(statusBarColor)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            findNavController().popBackStack()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun isBottomNavVisible() {
        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNav.isVisible = isBottomNavVisible
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onResume() {
        super.onResume()
    }


    fun addFragment(
            fragment: Fragment,
            tag: String = fragment.hashCode().toString()
    ) {
        hideKeyboard()
        activity?.supportFragmentManager?.commit(allowStateLoss = true) {
            if (!fragment.isAdded) addToBackStack(tag)
            setCustomAnimations(
                    R.anim.fade_in,
                    R.anim.fade_in,
                    R.anim.fade_in,
                    R.anim.fade_in
            )
            add(id, fragment)
        }
    }

     fun hideKeyboard() {
        view?.let {
            val imm =
                    it.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
    fun FragmentActivity.finishFragment() {
        supportFragmentManager.popBackStack()
    }
    abstract fun initialize()
}

fun FragmentActivity.finishFragment() {
    supportFragmentManager.popBackStack()
}

fun FragmentActivity.addFragment(
    fragment: BaseFragment,
    @IdRes containerId: Int
) {
    supportFragmentManager.commit(allowStateLoss = true) {
        setReorderingAllowed(true)
        setCustomAnimations(
            R.anim.fade_out,
            R.anim.fade_out,
            R.anim.fade_in,
            R.anim.fade_in
        )
        addToBackStack(fragment.hashCode().toString())
        add(containerId, fragment)
    }
}
