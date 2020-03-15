package com.telran.cars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayoutStart,FragmentStart.newInstance())
                .replace(R.id.frameLayoutEnd,FragmentEnd.newInstance())
                .commit();
        dl = findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.search) {
                    Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.letTheCarWork) {
                    Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.login) {
                    Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.singUp) {
                    Toast.makeText(MainActivity.this, "4", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.favorites) {
                    Toast.makeText(MainActivity.this, "5", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.termsOfUse) {
                    Toast.makeText(MainActivity.this, "6", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        MenuItem search = menu.findItem(R.id.searchRight);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.searchRight){
            Toast.makeText(MainActivity.this,"saerch right",Toast.LENGTH_SHORT).show();
        }
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
