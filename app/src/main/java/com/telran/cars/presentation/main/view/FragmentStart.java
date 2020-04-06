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
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.material.textfield.TextInputEditText;
import com.telran.cars.R;
import com.telran.cars.presentation.main.presenter.MainSearchPresentor;

import java.util.Objects;

public class FragmentStart extends MvpAppCompatFragment implements MainFragment, View.OnClickListener {
    TextInputEditText inputFrom, inputLocation, inputTill;
    AppCompatButton yallaBtn;
    ProgressBar myProgress;
    AlertDialog errorDialog;

    @InjectPresenter
    MainSearchPresentor presentor;

    public FragmentStart() {}

    public static FragmentStart newInstance(){
        FragmentStart fragmentStart = new FragmentStart();
        return fragmentStart;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.start_layout,container,false);
        inputFrom = view.findViewById(R.id.inputFrom);
        inputLocation = view.findViewById(R.id.inputLocation);
        inputTill = view.findViewById(R.id.inputTill);
        yallaBtn = view.findViewById(R.id.yallaBtn);
        yallaBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
    if (v.getId() == R.id.yallaBtn){
        Boolean ascending = false;
        Integer currentPage = 1;
//        String endDate = inputTill.getText().toString();
        String endDate = "2020-08-01 12:00";
        Integer itemsOnPage = 3;
        Number latitude = 32.0879;
        Number longitude = 34.7272;
        Number maxAmount = 10000.0;
        Number minAmount = 0.0;
//        String startDate = inputFrom.getText().toString();
        String startDate = "2020-04-10 12:00";
//        presentor.getCarByDateLocationPrice(ascending,currentPage,endDate,itemsOnPage,latitude,longitude,maxAmount,minAmount,startDate);
//        presentor.getThreeBestCar();

    }
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
        Objects.requireNonNull(getFragmentManager()).beginTransaction()
                .replace(R.id.root, new MapFragment())
                .commit();
    }

    @Override
    public void hideErrorDialog() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
