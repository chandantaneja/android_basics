package com.example.fragmentsintroduction;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragments extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getContext()).inflate(R.layout.detailed_fragment_layou, container, false);

        TextView versionName = view.findViewById(R.id.version_name);

        if (getArguments() != null && getArguments().getString("VersionName") != null) {
            versionName.setText(getArguments().getString("VersionName"));
        }
        return view;
    }
}
