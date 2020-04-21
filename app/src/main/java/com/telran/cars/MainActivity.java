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
import com.telran.cars.presentation.main.view.FragmentStartNew;
import com.telran.cars.presentation.main.view.LoginFragment;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.root, FragmentStartNew.newInstance())
                    .commit();
        }

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
                    LoginFragment loginFragment = LoginFragment.newInstance();
                    Bundle bundle = new Bundle();
                    bundle.putInt("login", 1);
                    loginFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.root, loginFragment)
                            .commit();
                } else if (id == R.id.singUp) {
                    LoginFragment loginFragment = LoginFragment.newInstance();
                    Bundle bundle = new Bundle();
                    bundle.putInt("login", 0);
                    loginFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.root, loginFragment)
                            .commit();
                } else if (id == R.id.favorites) {
                    Toast.makeText(MainActivity.this, "5", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.termsOfUse) {
                    Toast.makeText(MainActivity.this, "6", Toast.LENGTH_SHORT).show();
                }
                dl.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem search = menu.findItem(R.id.searchRight);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.searchRight) {
            Toast.makeText(MainActivity.this, "saerch right", Toast.LENGTH_SHORT).show();
        }
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
