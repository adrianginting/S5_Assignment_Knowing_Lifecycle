package com.example.s5assignmentknowinglifecycle;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);

        SharedPreferences prefs = getSharedPreferences("user_datail", MODE_PRIVATE);
        String PreferencesUsernameKey = prefs.getString("username","");

        if (!PreferencesUsernameKey.equals("")){
            username.setText(PreferencesUsernameKey);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Siklus hidup onStop()", Toast.LENGTH_SHORT).show();

        String usernameKey = username.getText().toString();

        SharedPreferences.Editor editor = getSharedPreferences("user_datail", MODE_PRIVATE).edit();
        editor.putString("username",usernameKey);
        editor.apply();

    }
}