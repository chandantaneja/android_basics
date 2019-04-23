package com.example.bluetoothchatapp;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;
    // used to find, turn on/off bluetooth device

    private BluetoothAdapter bluetoothAdapter;
    private final int LOCATION_PERMISSION_REQUEST = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        initBluetooth();
    }

    private void initBluetooth(){
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null){
            Toast.makeText(context, "NO BLUETOOTH FOUND", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search_devices:
                Toast.makeText(context, "Clicked Search Devices", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_enable_bluetooth:
                enableBluetooth();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    private void checkPermissions(){
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager
                                                        .PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_PERMISSION_REQUEST );

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == LOCATION_PERMISSION_REQUEST){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED ) {

         }
         else
         {
         new AlertDialog.Builder(context).setCancelable(false).setMessage("Location Permission is Requires \n Please Grant")
         .setPositiveButton("Grant", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
        checkPermissions();
        }
        })
        .setNegativeButton("DENY", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
        MainActivity.this.finish();
        }
        }).create();
        }
        }else {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        }

private void enableBluetooth()
        {
        if (bluetoothAdapter.isEnabled()) {
        Toast.makeText(context, "Bluetooth Enabled", Toast.LENGTH_SHORT).show();
        }
        else
        {
        bluetoothAdapter.enable();
        }

        }
        }
