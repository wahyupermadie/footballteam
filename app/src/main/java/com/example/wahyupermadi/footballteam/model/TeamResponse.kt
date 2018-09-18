package com.example.wahyupermadi.footballteam.model

import com.google.gson.annotations.SerializedName

data class TeamResponse(
        @SerializedName("teams")
        var teams: List<Team>
)