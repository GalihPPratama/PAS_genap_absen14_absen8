package com.example.pas_genap_absen14_absen8.api;
import com.example.pas_genap_absen14_absen8.model.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search_all_teams.php?s=Soccer&c=Spain")
    Call<TeamResponse> getAllTeams2();
}
