package com.example.arrayadapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);

        CustomAdapters adapter = new CustomAdapters(this, getAndroidVersions());
        listView.setAdapter(adapter);

//        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , getResources().getStringArray(R.array.Android));
//        listView.setAdapter(arrayAdapter);
//      this could be done using Custom Adapters
//        listView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "You Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

    }
    private ArrayList<AndroidVersion> getAndroidVersions(){
        AndroidVersion version = new AndroidVersion();
        version.setVersionNum(4.1);
        version.setVersionName("Ice Cream Sandwich");

        AndroidVersion version1 = new AndroidVersion();
        version1.setVersionNum(4.2);
        version1.setVersionName("Jelly Bean");

        AndroidVersion version3 = new AndroidVersion();
        version3.setVersionNum(4.3);
        version3.setVersionName("Kit Kat");

        AndroidVersion version4 = new AndroidVersion();
        version4.setVersionNum(4.4);
        version4.setVersionName("Lollipop");

        AndroidVersion version5 = new AndroidVersion();
        version5.setVersionNum(4.5);
        version5.setVersionName("Marshmallow");

        AndroidVersion version6 = new AndroidVersion();
        version6.setVersionNum(4.6);
        version6.setVersionName("Nougat");

        AndroidVersion version7 = new AndroidVersion();
        version7.setVersionNum(4.7);
        version7.setVersionName("Oreo");

        AndroidVersion version8 = new AndroidVersion();
        version8.setVersionNum(4.8);
        version8.setVersionName("Pie");

        ArrayList <AndroidVersion> versionArrayList = new ArrayList<>();

        versionArrayList.add(version);
        versionArrayList.add(version1);
        versionArrayList.add(version3);
        versionArrayList.add(version4);
        versionArrayList.add(version5);
        versionArrayList.add(version6);
        versionArrayList.add(version7);
        versionArrayList.add(version8);
        versionArrayList.add(version);
        versionArrayList.add(version1);
        versionArrayList.add(version3);
        versionArrayList.add(version4);
        versionArrayList.add(version5);
        versionArrayList.add(version6);
        versionArrayList.add(version7);
        versionArrayList.add(version8);
        versionArrayList.add(version);
        versionArrayList.add(version1);
        versionArrayList.add(version3);
        versionArrayList.add(version4);
        versionArrayList.add(version5);
        versionArrayList.add(version6);
        versionArrayList.add(version7);
        versionArrayList.add(version8);
        versionArrayList.add(version);
        versionArrayList.add(version1);
        versionArrayList.add(version3);
        versionArrayList.add(version4);
        versionArrayList.add(version5);
        versionArrayList.add(version6);
        versionArrayList.add(version7);
        versionArrayList.add(version8);

        return versionArrayList;


    }
}
