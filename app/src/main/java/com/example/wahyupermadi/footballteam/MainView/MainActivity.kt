package com.example.wahyupermadi.footballteam.MainView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import com.example.wahyupermadi.footballteam.R
import com.example.wahyupermadi.footballteam.R.array.league
import com.example.wahyupermadi.footballteam.adapter.MainAdapter
import com.example.wahyupermadi.footballteam.api.ApiClient
import com.example.wahyupermadi.footballteam.model.Team
import com.example.wahyupermadi.footballteam.model.TeamResponse
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), MainContract.View {
    var teams: MutableList<Team> = mutableListOf()

    lateinit var teamAdapter: MainAdapter

    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    private lateinit var spinner : Spinner
    lateinit var leagueName: String
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var mPresenter : MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = MainPresenter(this)
        init()
    }

    override fun displayDataTeam(team: List<Team>) {
        teams.clear()
        teams.addAll(team)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_android_list.layoutManager = layoutManager
        rv_android_list.adapter = MainAdapter(this,teams){
            toast("wkwkwkw")
        }

    }

    override fun showProgressBar() {
        mainProgressBar.visibility = View.VISIBLE
        rv_android_list.visibility = View.GONE
    }

    override fun hideProgressBar() {
        mainProgressBar.visibility = View.GONE
        rv_android_list.visibility = View.VISIBLE
    }

    private fun init() {
        spinner = spinner_team
        val spinnerItems = resources.getStringArray(league)
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerItems)
        spinner.adapter = spinnerAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                leagueName = spinner.selectedItem.toString()
                mPresenter.getDataTeam(leagueName)
            }
        }
    }
}
