package com.example.sd2.di.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.sd2.MainApplication
import com.example.sd2.State
import com.example.sd2.di.component.AppComponent
import com.example.sd2.di.network.NetworkResponse
import com.example.sd2.di.network.User
import com.example.sd2.di.repository.NetworkInterface
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import javax.inject.Inject

class UserDataSource(
    private val compositeDisposable: CompositeDisposable
) : PageKeyedDataSource<Int, User>() {

    var state: MutableLiveData<State> = MutableLiveData()
    var limit: Int = 9

    @Inject
    lateinit var retrofit: Retrofit

    var apiService: NetworkInterface

    init {
        val apiComponent: AppComponent = MainApplication.mAppComponent
        apiComponent.inject(this)
        apiService = retrofit.create(NetworkInterface::class.java)

    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, User>
    ) {
        updateState(State.LOADING)
        compositeDisposable.add(
            apiService.loadPosts(0, limit)
                .subscribe(
                    { response ->
                        updateState(State.DONE)
                        callback.onResult(
                            response.data.users,
                            null,
                            limit
                        )
                    },
                    {
                        updateState(State.ERROR)
                    }
                )
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        updateState(State.LOADING)
        compositeDisposable.add(
            apiService.loadPosts(params.key, limit)
                .subscribe(
                    { response ->
                        updateState(State.DONE)
                        callback.onResult(
                            response.data.users,
                            params.key + limit
                        )
                    },
                    {
                        updateState(State.ERROR)
                    }
                )
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
    }

    private fun updateState(state: State) {
        this.state.postValue(state)
    }


}