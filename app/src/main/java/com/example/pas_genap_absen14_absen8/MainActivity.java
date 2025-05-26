package com.example.pas_genap_absen14_absen8;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.pas_genap_absen14_absen8.Fragments.FragmentJadwal;
import com.example.pas_genap_absen14_absen8.Fragments.FragmentLaLiga;
import com.example.pas_genap_absen14_absen8.Fragments.FragmentProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, new FragmentLaLiga())
                .commit();

        bottomNavigationView.setOnItemSelectedListener( item ->{
            Fragment fragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_spanish) {
                fragment = new FragmentLaLiga();
            } else if (itemId == R.id.nav_jadwal) {
                fragment = new FragmentJadwal();
            } else if (itemId == R.id.nav_profile) {
                fragment = new FragmentProfile();
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, fragment)
                        .commit();
                return true;
            }
            return false;
        });

    }
}