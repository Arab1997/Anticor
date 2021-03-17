package myway.group.anticor.ui.activity

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.drawerLayout
import kotlinx.android.synthetic.main.fragment_home.*
import myway.group.anticor.R
import myway.group.anticor.ui.activity.util.MyContextWrapper
import myway.group.anticor.ui.activity.util.MyPreference

class MainActivity : BaseActivity(R.layout.activity_main) {
    private lateinit var myPref: MyPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val drawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host
                toggleDrawer()_fragment)
        navView.setupWithNavController(navController)
    }

    override fun attachBaseContext(newBase: Context?) {
        myPref = MyPreference(newBase!!)
        val lang = myPref.getLang()
        super.attachBaseContext(MyContextWrapper.wrap(newBase, lang))
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onActivityCreated() {


    }
    private fun toggleDrawer() {
        if (drawerLayout.isDrawerOpen(leftDrawerMenu)) {
            drawerLayout.closeDrawer(leftDrawerMenu)
        } else {
            drawerLayout.openDrawer(leftDrawerMenu)
        }
    }

}


