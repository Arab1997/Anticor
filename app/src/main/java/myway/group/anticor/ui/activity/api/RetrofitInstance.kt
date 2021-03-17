package myway.group.anticor.ui.activity.api

import com.google.gson.GsonBuilder
import myway.group.anticor.ui.activity.App
import myway.group.anticor.ui.activity.util.Constants.Companion.BASE_URL
import myway.group.anticor.ui.activity.util.MyPreference
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private val retrofit by lazy {
        val client = OkHttpClient.Builder()
//            .addInterceptor(ChuckerInterceptor(App.appInstance))
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    var request = chain.request()
                    val url = request.url.newBuilder().addQueryParameter("_lang", getLang()).build()
                    request = request.newBuilder().url(url).build()
                    return chain.proceed(request)
                }
            })
            .build()
        val gson = GsonBuilder().serializeNulls().create()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    private fun getLang(): String {
        return MyPreference(App.appInstance).getLang()
    }

    val api: Api by lazy {
        retrofit.create(Api::class.java)
    }
}