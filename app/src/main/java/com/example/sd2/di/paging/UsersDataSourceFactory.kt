package com.example.sd2.di.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.sd2.di.network.NetworkResponse
import com.example.sd2.di.network.User
import io.reactivex.disposables.CompositeDisposable

class UsersDataSourceFactory(

    private val compositeDisposable: CompositeDisposable
)
    : DataSource.Factory<Int, User>() {

    val userDataSourceLiveData = MutableLiveData<UserDataSource>()

    override fun create(): DataSource<Int, User> {
        val userDataSource = UserDataSource( compositeDisposable)
        userDataSourceLiveData.postValue(userDataSource)
        return userDataSource
    }
}