package com.example.sd2.di.component

import com.example.sd2.di.module.APIModule
import com.example.sd2.di.module.PicassoModule
import com.example.sd2.di.paging.UserDataSource
import com.squareup.picasso.Picasso
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [APIModule::class,PicassoModule::class])
interface AppComponent  {
    fun inject(userDataSource: UserDataSource)
    fun getPicasso(): Picasso?

}