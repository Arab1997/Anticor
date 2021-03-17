package myway.group.anticor.ui.activity.fragment.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import myway.group.anticor.R
import myway.group.anticor.ui.activity.BaseFragment

class AsosiyFragment : BaseFragment(R.layout.fragment_asosiy) {
    companion object {
        private lateinit var data: AsosiyData
        fun newInstance(data: AsosiyData): AsosiyFragment {
            this.data = data
            return AsosiyFragment()
        }
    }


    override fun initialize() {


    }


}

data class AsosiyData(val name: String, val type: CalculatorMenus)

enum class CalculatorMenus {
    BASICS, CAPACITY, CONDUCTOR, ENGINE, CABEL
}