package com.example.sd2.di.module

import android.content.Context
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.okhttp.OkHttpClient

import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
    class PicassoModule {
    @Provides
    fun picasso(context: Context?, okHttp3Downloader: OkHttp3Downloader?): Picasso {
        return Picasso.Builder(context).downloader(okHttp3Downloader).build()
    }

    @Provides
    fun okHttp3Downloader(okHttpClient:  Context?): OkHttp3Downloader {
        return OkHttp3Downloader(okHttpClient)
    }
}