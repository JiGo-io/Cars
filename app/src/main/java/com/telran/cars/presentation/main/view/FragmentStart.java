package com.telran.cars.presentation.main.view;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.arellomobile.mvp.MvpAppCompatDialogFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.telran.cars.R;

public class FragmentStart extends MvpAppCompatDialogFragment implements MainFragment, View.OnClickListener {
    TextInputEditText inputFrom, inputLocation, inputTill;
    AppCompatButton yallaBtn;
    ProgressBar myProgress;
    AlertDialog errorDialog;

    public FragmentStart() {}

    public static FragmentStart newInstance(){
        FragmentStart fragmentStart = new FragmentStart();
        return fragmentStart;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.start_layout,container,false);
        return view;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showNextView() {

    }

    @Override
    public void hideErrorDialog() {

    }
}
