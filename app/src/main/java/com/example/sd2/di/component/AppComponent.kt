package com.example.sd2.di.component

import com.example.sd2.di.module.APIModule
import com.example.sd2.di.paging.UserDataSource
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [APIModule::class])
interface AppComponent {

    fun inject(userDataSource: UserDataSource)
}