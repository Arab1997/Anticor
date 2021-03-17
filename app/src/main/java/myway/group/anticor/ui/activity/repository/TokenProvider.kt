package myway.group.anticor.ui.activity.repository

import android.content.Context
import myway.group.anticor.ui.activity.util.Constants.Companion.PREF_NAME
import myway.group.anticor.ui.activity.util.Constants.Companion.TOKEN

class TokenProvider {
    companion object {
        private var token: String? = null
        fun getToken(context: Context): String {
            if (token == null) {
                token =
                    context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getString(TOKEN,"")
            }
            return token!!
        }

        fun resetToken() {
            token = null
        }
    }
}