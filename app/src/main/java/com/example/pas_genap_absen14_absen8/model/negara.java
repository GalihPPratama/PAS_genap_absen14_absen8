package com.example.pas_genap_absen14_absen8.model;

import com.google.gson.annotations.SerializedName;

public class negara {
    @SerializedName("name_en")
    private String name;
    @SerializedName("flag_url_32")
    private String strFlag;

    public String getName() {
        return name;
    }

    public String getStrFlag() {
        return strFlag;
    }
}
