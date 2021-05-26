package com.example.sd2.di.component

import com.example.myapplication.network.di.BindingModule
import com.example.sd2.di.module.APIModule
import com.example.sd2.di.paging.UserDataSource
import com.squareup.picasso.Picasso
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [APIModule::class,BindingModule::class])
interface AppComponent  {
    fun picasso(): Picasso
    fun inject(userDataSource: UserDataSource)
}