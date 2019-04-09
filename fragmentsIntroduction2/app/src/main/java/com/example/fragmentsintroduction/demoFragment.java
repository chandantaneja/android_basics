package com.example.fragmentsintroduction;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class demoFragment extends Fragment {

    AndroidVersionInterface androidVersionInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            androidVersionInterface = (AndroidVersionInterface) context;
        }catch (ClassCastException e){
            Log.e("Class Cast Exception", e.toString());
        }

    }

    @Nullable
    @Override
      public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getContext()).inflate(R.layout.fragment_layout, container, false);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.AndroiidVersions));
        ListView listView = view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String strVersionName = ((TextView) view) . getText().toString();
            androidVersionInterface.onVersionItemClick(strVersionName);

            }
        });


        return view;
    }
}
