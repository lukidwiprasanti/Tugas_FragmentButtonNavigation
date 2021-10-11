package com.example.fragmentbuttonnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView; //inisialisasi bottomNavigationView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation); //Untuk mengatur fragmen yang dipilih secara default

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChatsFragment()).commit(); //digunakan untuk memuat fragmen tertentu, ketika layar ini terbuka.

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() { //digunakan untuk menavigasi fragmen.
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) { //digunakan untuk menghandle navigation view item clicks here.
                Fragment selectedFragment = null; //digunakan untuk menampilkan fragmen yang benar tanpa memulai ulang.

                switch (item.getItemId()){ // digunakan untuk mengalihkan fragment
                    case R.id.nav_chats: //memanggil chats untuk menggunakan salah satu elemen yang sudah diberikan
                        selectedFragment = new ChatsFragment(); //mengeset atau membuka default nya ke ChatFragment
                        break; //menghentikan fragment
                    case R.id.nav_status: //memanggil status untuk menggunakan salah satu elemen yang sudah diberikan
                        selectedFragment = new StatusFragment(); //mengeset atau membuka default nya ke StatusFragment
                        break; //menghentikan fragment
                    case R.id.nav_calls: //memanggil calls untuk menggunakan salah satu elemen yang sudah diberikan
                        selectedFragment = new CallsFragment(); ////mengeset atau membuka default nya ke CallsFragment
                        break; //menghentikan fragment
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit(); //digunakan untuk menampilkan fragment pada layar yang sama

                return true;
            }
        });
    }
}
