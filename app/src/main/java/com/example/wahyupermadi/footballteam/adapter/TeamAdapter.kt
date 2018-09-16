package com.example.wahyupermadi.footballteam.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wahyupermadi.footballteam.R
import com.example.wahyupermadi.footballteam.model.Android
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.team_list.view.*

class TeamAdapter (private val context: Context, private val dataList: List<Android>, private val listener:(Android)->Unit): RecyclerView.Adapter<TeamViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {

        val rootview = LayoutInflater.from(context).inflate(R.layout.team_list,parent,false)
        return TeamViewHolder(rootview)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(dataList[position], listener)
    }
}

class TeamViewHolder(view : View) : RecyclerView.ViewHolder(view){
    fun bindItem(team: Android, listener: (Android) -> Unit) {
        itemView.tv_name.text = team.name
        itemView.tv_api_level.text = team.apiLevel
        itemView.tv_version.text = team.version

        itemView.setOnClickListener(){
            listener(team)
        }
    }
}
