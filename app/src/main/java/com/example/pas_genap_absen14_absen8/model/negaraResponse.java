package com.example.pas_genap_absen14_absen8.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class negaraResponse {
    @SerializedName("countries")
    private List<negara> countries;

    public List<negara> getCountries() {
        return countries;
    }
}
