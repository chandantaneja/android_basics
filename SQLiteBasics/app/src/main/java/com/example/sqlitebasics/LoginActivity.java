package com.example.sqlitebasics;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitebasics.DbUtils.LocalDB;
import com.example.sqlitebasics.DbUtils.User;

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
//                SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
//                String strUsername = credentials.getString("Username", "");
//                String strPass = credentials.getString("Password", "");

                final String ed_from_user = ed_username.getText().toString();
                final String ed_from_pass = ed_pass.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LocalDB dbInstance = RoomImplementation.getmInstance().getDbInstance();
                        User user = dbInstance.userDao().getUserByUsername(ed_from_user);
                        if (user != null && user.getUsername() != null && ed_from_user.equalsIgnoreCase(user.getUsername())){
                            if (ed_from_pass != null && user.getPassword() != null && user.getPassword().equalsIgnoreCase(ed_from_pass)){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                                    }
                                });
                            }else
                            {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

                                    }
                                });
                            }
                        }
                        else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

                                }
                            });
                        }
                    }
                }).start();





            }
        });
    }
}
