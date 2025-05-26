package com.example.pas_genap_absen14_absen8.api;
import com.example.pas_genap_absen14_absen8.model.TeamResponse;
import com.example.pas_genap_absen14_absen8.model.negaraResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/api/v1/json/3/search_all_teams.php?s=Soccer&c=Spain")
    Call<TeamResponse> getAllTeams2();

    @GET("/api/v1/json/3/all_countries.php")
    Call<negaraResponse> getCountries();
}
