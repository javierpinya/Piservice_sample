package com.javierpinya.piservice.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.javierpinya.piservice.Activities.DashboardActivity;
import com.javierpinya.piservice.Activities.LoginActivity;
import com.javierpinya.piservice.R;

import static com.javierpinya.piservice.Utils.Util.getUserMailPrefs;
import static com.javierpinya.piservice.Utils.Util.getUserPassPrefs;

public class SplashActivity extends AppCompatActivity {

    //private Button btnEmpezar;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE);

        Intent intentLogin = new Intent(this, LoginActivity.class);
        Intent intentDashboard = new Intent(this, DashboardActivity.class);

        if(!TextUtils.isEmpty(getUserMailPrefs(prefs)) && !TextUtils.isEmpty(getUserPassPrefs(prefs))){
            startActivity(intentDashboard);
        }else {
            startActivity(intentLogin);
        }
    }
}
