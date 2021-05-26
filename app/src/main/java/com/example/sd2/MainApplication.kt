package com.example.sd2

import android.app.Application
import com.example.sd2.di.component.AppComponent
import com.example.sd2.di.component.DaggerAppComponent
import com.example.sd2.di.module.APIModule
import com.example.sd2.di.repository.APIURL


class MainApplication:Application() {

    companion object {
        lateinit var mAppComponent:AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        mAppComponent = initDaggerComponent()

    }
    fun initDaggerComponent():AppComponent{
        mAppComponent =   DaggerAppComponent
            .builder().
            aPIModule(APIModule(APIURL.BASE_URL))
            .build()
        return  mAppComponent

    }

    fun getAppComponent(): AppComponent{
        return mAppComponent
    }
}

