package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText ed_username, ed_pass;
    private Button btn_login;

    public static final String CREDENTIAL_SHARED_PREF = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed_username = (EditText) findViewById(R.id.ed_username);
        ed_pass = (EditText) findViewById(R.id.ed_password);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
                String strUsername = credentials.getString("Username", "");
                String strPass = credentials.getString("Password", "");

                String ed_from_user = ed_username.getText().toString();
                String ed_from_pass = ed_pass.getText().toString();

                if (ed_from_user != null && strUsername != null && strUsername.equalsIgnoreCase(ed_from_user)){
                    if (ed_from_pass != null && strPass != null && strPass.equalsIgnoreCase(ed_from_pass)){
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
