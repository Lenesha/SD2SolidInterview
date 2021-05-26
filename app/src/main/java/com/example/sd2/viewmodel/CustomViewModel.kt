package com.example.myapplication.network.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.sd2.State
import com.example.sd2.di.network.User
import com.example.sd2.di.paging.UserDataSource
import com.example.sd2.di.paging.UsersDataSourceFactory
import io.reactivex.disposables.CompositeDisposable


class CustomViewModel() : ViewModel() {

    private var usersDataSourceFactory: UsersDataSourceFactory
    var userList: LiveData<PagedList<User>>
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
        private val pageSize = 9

    private val mutableSelectedItem = MutableLiveData<User>()
    val selectedItem: LiveData<User> get() = mutableSelectedItem

    init {

        usersDataSourceFactory = UsersDataSourceFactory(compositeDisposable)
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize)
            .setEnablePlaceholders(false)
            .build()
        userList =
            LivePagedListBuilder<Int, User>(usersDataSourceFactory, config).build()
    }



    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
    fun selectItem(item: User) {
        mutableSelectedItem.value = item
    }
}


