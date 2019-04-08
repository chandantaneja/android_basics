package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Credentials;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    private EditText ed_username, ed_pass, cnf_pass;
    private Button Signup;

    public static final String CREDENTIAL_SHARED_PREF = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ed_username = (EditText)findViewById(R.id.ed_username);
        ed_pass = (EditText)findViewById(R.id.ed_password);
        cnf_pass = (EditText)findViewById(R.id.confirm_pass);
        Signup = (Button)findViewById(R.id.signup);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strPass = ed_pass.getText().toString();
                String strCnfPass = cnf_pass.getText().toString();
                String strUser = ed_username.getText().toString();


                if (strPass != null && cnf_pass != null && strPass.equalsIgnoreCase(strCnfPass)) {
                    SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = credentials.edit();
                    editor.putString("Password", strPass);
                    editor.putString("Username", strUser);
                    editor.commit();

                    Signup.this.finish();
                }

                else if (!(strPass.equalsIgnoreCase(strCnfPass))){
                    Toast.makeText(Signup.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
