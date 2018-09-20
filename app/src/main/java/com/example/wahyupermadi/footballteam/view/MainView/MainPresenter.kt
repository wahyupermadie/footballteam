package com.example.wahyupermadi.footballteam.view.MainView

import com.example.wahyupermadi.footballteam.api.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(val mView : MainContract.View) : MainContract.Presenter {
    val compositeDisposable = CompositeDisposable()
    override fun getDataTeam(l: String) {
        mView.showProgressBar()
        compositeDisposable.add(ApiClient.create().getTeam(l)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    mView.displayDataTeam(it.teams)
                    mView.hideProgressBar()
                })
    }
}