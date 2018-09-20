package com.example.wahyupermadi.footballteam.view.MainView

import android.support.v4.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.wahyupermadi.footballteam.R
import com.example.wahyupermadi.footballteam.R.array.league
import com.example.wahyupermadi.footballteam.adapter.MainAdapter
import com.example.wahyupermadi.footballteam.model.Team
import com.example.wahyupermadi.footballteam.view.DetailView.DetailActivity
import kotlinx.android.synthetic.main.fragment_main.*
import org.jetbrains.anko.support.v4.toast


class MainFragment : Fragment(), MainContract.View {
    var teams: MutableList<Team> = mutableListOf()
    lateinit var teamAdapter: MainAdapter
    lateinit var recyclerView: RecyclerView
    private lateinit var spinner : Spinner
    lateinit var leagueName: String
    lateinit var mPresenter : MainPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
//        recyclerView = rootView.findViewById(R.id.rv_android_list) as RecyclerView
//        recyclerView.layoutManager = LinearLayoutManager(activity)
//        recyclerView.setHasFixedSize(true)
//        mPresenter = MainPresenter(this)
//        init()
//
//        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        spinner = spinner_team
        mPresenter = MainPresenter(this)
        init()
    }

    override fun displayDataTeam(team: List<Team>) {
        teams.clear()
        teams.addAll(team)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_android_list.layoutManager = layoutManager
        rv_android_list.adapter = MainAdapter(context,teams) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("id", it.idTeam)
            startActivity(intent)
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
        val spinnerItems = resources.getStringArray(league)
        val spinnerAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        spinner_team.adapter = spinnerAdapter
        spinner_team.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                leagueName = spinner.selectedItem.toString()
                mPresenter.getDataTeam(leagueName)
            }
        }
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}
