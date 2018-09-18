package com.example.wahyupermadi.footballteam.MainView

import com.example.wahyupermadi.footballteam.model.Team
import com.example.wahyupermadi.footballteam.model.TeamResponse

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