package com.example.pas_genap_absen14_absen8.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_genap_absen14_absen8.R;
import com.example.pas_genap_absen14_absen8.adapter.negaraAdapter;
import com.example.pas_genap_absen14_absen8.adapter.teamAdapter;
import com.example.pas_genap_absen14_absen8.api.ApiService;
import com.example.pas_genap_absen14_absen8.api.RetrofitClient;
import com.example.pas_genap_absen14_absen8.model.Team;
import com.example.pas_genap_absen14_absen8.model.TeamResponse;
import com.example.pas_genap_absen14_absen8.model.negara;
import com.example.pas_genap_absen14_absen8.model.negaraResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentJadwal extends Fragment {

    private RecyclerView recyclerViewTeam;
    private negaraAdapter negaraAdapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jadwal, container, false);
        recyclerViewTeam = view.findViewById(R.id.recycleviewJadwal);
        recyclerViewTeam.setLayoutManager(new LinearLayoutManager(getContext()));
        loadTeams();
        return view;
    }
    private void loadTeams() {
        RetrofitClient.getRetrofitInstance()
                .create(ApiService.class)
                .getCountries()
                .enqueue(new Callback<negaraResponse>() {
                    @Override
                    public void onResponse(Call<negaraResponse> call, Response<negaraResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<negara> negara = response.body().getCountries();
                            negaraAdapter = new negaraAdapter(negara, requireContext());
                            recyclerViewTeam.setAdapter(negaraAdapter);
                        } else {
                            Toast.makeText(getContext(), "No Data", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<negaraResponse> call, Throwable t) {
                        Toast.makeText(getContext(), "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
