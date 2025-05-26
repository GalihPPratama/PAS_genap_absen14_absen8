package com.example.pas_genap_absen14_absen8.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamResponse {

    @SerializedName("teams")
    private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }
}
