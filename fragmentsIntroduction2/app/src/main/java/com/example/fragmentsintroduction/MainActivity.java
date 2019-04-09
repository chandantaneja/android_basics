package com.example.fragmentsintroduction;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AndroidVersionInterface{
    private FrameLayout container;

    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container =  findViewById(R.id.fragment_container);

         fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        demoFragment demoFragment = new demoFragment();
        fragmentTransaction.add(container.getId(), demoFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onVersionItemClick(String versionName) {
        Toast.makeText(this, " Clicked" + versionName , Toast.LENGTH_SHORT).show();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString("VersionName" , versionName);
        DetailFragments detailFragments = new DetailFragments();
        detailFragments.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragment_detail_container, detailFragments);
        fragmentTransaction.commit();
    }
}
