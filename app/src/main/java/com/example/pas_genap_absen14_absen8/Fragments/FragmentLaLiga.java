package com.example.pas_genap_absen14_absen8.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_genap_absen14_absen8.R;
import com.example.pas_genap_absen14_absen8.adapter.teamAdapter;
import  com.example.pas_genap_absen14_absen8.api.ApiService;
import  com.example.pas_genap_absen14_absen8.api.RetrofitClient;
import  com.example.pas_genap_absen14_absen8.model.TeamResponse;
import  com.example.pas_genap_absen14_absen8.model.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentLaLiga extends Fragment {

    private RecyclerView recyclerViewTeam;
    private teamAdapter teamadapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laliga, container, false);
        recyclerViewTeam = view.findViewById(R.id.recyclerviewTeam);
        recyclerViewTeam.setLayoutManager(new LinearLayoutManager(getContext()));
        loadTeams();
        return view;
    }
    private void loadTeams() {
        RetrofitClient.getRetrofitInstance()
                .create(ApiService.class)
                .getAllTeams2()
                .enqueue(new Callback<TeamResponse>() {
                    @Override
                    public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<Team> teams = response.body().getTeams();
                            teamadapter = new teamAdapter(requireContext(), teams);
                            recyclerViewTeam.setAdapter(teamadapter);
                        } else {
                            Toast.makeText(getContext(), "No Data", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<TeamResponse> call, Throwable t) {
                        Toast.makeText(getContext(), "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
