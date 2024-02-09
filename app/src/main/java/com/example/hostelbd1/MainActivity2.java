package com.example.hostelbd1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {

    BottomNavigationView bottomNavagation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main2);

        bottomNavagation = findViewById(R.id.bottomNavagation);


        if (!isConnected(this)) {

            costomdailog();

        }


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framlayout, new BlankFragment());
        fragmentTransaction.commit();


        bottomNavagation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                if (item.getItemId() == R.id.home) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.framlayout, new BlankFragment());
                    fragmentTransaction.commit();
                    Toast.makeText(MainActivity2.this, "HOME", Toast.LENGTH_SHORT).show();


                } else if (item.getItemId() == R.id.search) {


                    Toast.makeText(MainActivity2.this, "SEARCH", Toast.LENGTH_SHORT).show();

                } else if (item.getItemId() == R.id.favourite) {

                    Toast.makeText(MainActivity2.this, "FAVOURITR", Toast.LENGTH_SHORT).show();

                } else if (item.getItemId() == R.id.profile) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.framlayout, new ProfileBLank2());
                    fragmentTransaction.addToBackStack("nul");
                    fragmentTransaction.commit();

                    Toast.makeText(MainActivity2.this, "PROFILE", Toast.LENGTH_SHORT).show();


                }


                return true;
            }
        });


    }


//    public void onclick(View view) {
//
//
//
//    }


    private boolean isConnected(MainActivity2 mainActivity) {

        ConnectivityManager connectivityManager = (ConnectivityManager) mainActivity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wificonnation = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileconnation = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wificonnation != null && wificonnation.isConnected() || mobileconnation != null && mobileconnation.isConnected())) {


            return true;

        } else
            return false;


    }


    private void costomdailog() {

        new AlertDialog.Builder(MainActivity2.this)

                .setMessage("plase connacted to  internet connation")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

//                        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
//                        startActivity(intent);

                        finishAffinity();
                        dialog.dismiss();


                    }
                })

//                .setNegativeButton("cencle", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        finish();
//                    }
//                })

                .show();


    }
}
