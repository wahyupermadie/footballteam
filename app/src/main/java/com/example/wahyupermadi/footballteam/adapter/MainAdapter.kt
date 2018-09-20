package com.example.wahyupermadi.footballteam.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.wahyupermadi.footballteam.R
import com.example.wahyupermadi.footballteam.model.Team
import kotlinx.android.synthetic.main.team_list.view.*

class MainAdapter (private val context: Context?, private val teams: List<Team>, private val listener:(Team)->Unit): RecyclerView.Adapter<TeamViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {

        val rootview = LayoutInflater.from(context).inflate(R.layout.team_list,parent,false)
        return TeamViewHolder(rootview)
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position], listener)
    }
}

class TeamViewHolder(view : View) : RecyclerView.ViewHolder(view){
    fun bindItem(teams: Team, listener: (Team) -> Unit) {
        Glide.with(itemView.context).load(teams.strTeamLogo).into(itemView.iv_team)
        itemView.tv_team.text = teams.strTeam
        itemView.setOnClickListener(){
            listener(teams)
        }
    }
}
