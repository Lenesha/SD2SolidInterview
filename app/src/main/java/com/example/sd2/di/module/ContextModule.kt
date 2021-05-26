package com.example.sd2.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(context: Context) {
    var context: Context
    @Provides
    fun context(): Context {
        return context.getApplicationContext()
    }

    init {
        this.context = context
    }
}