package com.javierpinya.piservice.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.javierpinya.piservice.R;

import static com.javierpinya.piservice.Utils.Util.getUserMailPrefs;
import static com.javierpinya.piservice.Utils.Util.getUserPassPrefs;

public class LoginActivity extends AppCompatActivity {

    private EditText etUser, etPass;
    private Switch recordar;
    private Button btnLogin;
    private ImageView imglogin;

    private SharedPreferences prefs;
    private final int PERMISSION_REQUEST_STORAGE = 10;
    private boolean permiso_version_antigua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE);

        etUser = findViewById(R.id.username);
        etPass = findViewById(R.id.pass);
        recordar = findViewById(R.id.recordar);
        btnLogin = findViewById(R.id.btnLogin);
        imglogin = findViewById(R.id.imglogin);

        setCredentialsIfExists();

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = etUser.getText().toString();
                String password = etPass.getText().toString();

                if(login(email,password)){
                    permissions();
                    gotoDashboard();
                    saveOnPreferences(email,password);
                }
            }
        });

    }

    private void setCredentialsIfExists() {
        String email = getUserMailPrefs(prefs);
        String pass = getUserPassPrefs(prefs);
        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)){
            etUser.setText(email);
            etPass.setText(pass);
        }
    }

    private boolean login(String email, String password){
        if(!isValidEmail(email)){
            Toast.makeText(this, "Email is not valid", Toast.LENGTH_LONG).show();
            return false;
        }else if(!isValidPassword(password)){
            Toast.makeText(this, "Password is not valid, 4 characters or more", Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }

    private void saveOnPreferences(String email, String pass){
        if(recordar.isChecked()){
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("email",email);
            editor.putString("etPass",pass);
            editor.apply();
        }
    }

    private boolean isValidEmail(String email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password){
        return password.length()>=4;
    }

    private void gotoDashboard(){
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Para que desde la siguient activity no se vuelva a esta si damos a aatŕas
        intent.setClass(LoginActivity.this, DashboardActivity.class);
        startActivity(intent);
    }

    public void permissions(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_STORAGE);
        }else{
            permiso_version_antigua = ChekPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
    }

    private boolean ChekPermission(String permission){
        //Este método comprueba si el persmiso que se pasa está declarado o disponemos de el
        //Si el permiso está granted (está declarado con uses-permission) devolverá true.
        int result = this.checkCallingOrSelfPermission(permission);
        return result==PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 10:
                if(requestCode == PERMISSION_REQUEST_STORAGE){
                    if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "Permisos aceptados!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(this, "Persmisos rechazados!", Toast.LENGTH_SHORT).show();
                    }
                }

        }

    }



    private boolean isExternalStorageWritable(){
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            Log.i("State", "Yes, it is writable");
            return true;
        }else{
            return false;
        }
    }
}
