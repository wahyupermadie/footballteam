package com.example.wahyupermadi.footballteam.view.MainView

import com.example.wahyupermadi.footballteam.model.Team

interface MainContract {

    interface View {
        fun displayDataTeam(team: List<Team>)
        fun showProgressBar()
        fun hideProgressBar()
    }

    interface Presenter{
        fun getDataTeam(l : String)
    }
}