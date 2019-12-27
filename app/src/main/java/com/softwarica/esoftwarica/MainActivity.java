package com.softwarica.esoftwarica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.softwarica.esoftwarica.Fragments.AboutFragment;
import com.softwarica.esoftwarica.Fragments.HomeFragment;
import com.softwarica.esoftwarica.Fragments.StudentFragment;
import com.softwarica.esoftwarica.Models.Students;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<Students> studentsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.btmNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (studentsList.isEmpty()) {

            studentsList.add(new Students("Sabina Sunuwar","female", 20, "Boudha"));
            studentsList.add(new Students("Bigem Maharjan","male", 21, "Patan"));
            studentsList.add(new Students("Sumina Maharjan","female", 20, "Sundhara"));

        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.navHome:
                    selectedFragment = new HomeFragment();
                    break;

                case R.id.navStudent:
                    selectedFragment = new StudentFragment();
                    break;

                case R.id.navAbout:
                    selectedFragment = new AboutFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };
}
