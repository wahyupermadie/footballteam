package com.example.wahyupermadi.footballteam

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ProgressBar
import com.example.wahyupermadi.footballteam.adapter.TeamAdapter
import com.example.wahyupermadi.footballteam.api.ApiClient
import com.example.wahyupermadi.footballteam.model.Android
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var teamAdapter: TeamAdapter
    lateinit var android: List<Android>
    lateinit var progressBar: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = this.findViewById(R.id.rv_android_list) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        setData()
    }

    private fun setData() {
        progressBar = indeterminateProgressDialog("Hello! Please wait...")
        progressBar.show()

        val queue = ApiClient.create()
                .getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            data -> getData(data)
                            progressBar.hide()},
                        { error -> Log.e("ERROR", error.message) }
                )
    }

    private fun getData(data: List<Android>?) {
        android = ArrayList(data)
        teamAdapter = TeamAdapter(this,android){
            toast("wkkwkw")
        }
        recyclerView.adapter = teamAdapter
    }

}
