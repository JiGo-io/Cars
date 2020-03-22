package com.telran.cars.presentation.main.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.telran.cars.R;

public class FragmentEnd extends Fragment {
    public static FragmentEnd newInstance(){
        FragmentEnd fragmentEnd = new FragmentEnd();
        return fragmentEnd;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.end_layout,container,false);
        return view;
    }
}