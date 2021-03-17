package myway.group.anticor.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import myway.group.anticor.R
import myway.group.anticor.ui.activity.util.Constants.Companion.PREF_NAME
import myway.group.anticor.ui.activity.util.Constants.Companion.SESSION_ID

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
       Handler().postDelayed({
           val mIntent = Intent(this@SplashActivity, MainActivity::class.java)
           startActivity(mIntent)
           finish()
       }, 3000)
    }
}