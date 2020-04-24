package com.telran.cars.presentation.main.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.material.textfield.TextInputEditText;
import com.telran.cars.R;
import com.telran.cars.data.dto.CarForUsersDto;
import com.telran.cars.data.dto.CarsFiltersDto;
import com.telran.cars.data.dto.ResponseCarsFiltersDto;
import com.telran.cars.presentation.main.presenter.MainSearchPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentStartNew extends MvpAppCompatFragment implements MainFragment, View.OnClickListener, MyAdapter.OnRowClickListener {
    TextInputEditText inputFrom, inputLocation, inputTill;
    AppCompatButton yallaBtn;
    ProgressBar myProgress;
    @InjectPresenter
    MainSearchPresenter presenter;
    MyAdapter adapter;
    RecyclerView rv;

    public FragmentStartNew() {
    }

    public static FragmentStartNew newInstance() {
        FragmentStartNew fragmentStart = new FragmentStartNew();
        return fragmentStart;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        inputFrom = view.findViewById(R.id.inputFrom);
        inputLocation = view.findViewById(R.id.inputLocation);
        inputTill = view.findViewById(R.id.inputTill);
        myProgress = view.findViewById(R.id.myProgress);
        yallaBtn = view.findViewById(R.id.yallaBtn);
        yallaBtn.setOnClickListener(this);
        rv = view.findViewById(R.id.my_rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);

        rv.setLayoutManager(layoutManager);
        rv.addItemDecoration(divider);
        presenter.getThreeBestCar();
        return view;
    }

    @Override
    public void displayCars(List<CarForUsersDto> listCars) {
        adapter = new MyAdapter(requireContext());
        adapter.setCars(listCars);
        rv.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.yallaBtn) {
            Boolean ascending = false;
            Integer currentPage = 1;
//        String endDate = inputTill.getText().toString();
            String endDate = "2020-08-01 12:00";
            Integer itemsOnPage = 7;
            Number latitude = 32.0879;
            Number longitude = 34.7272;
            Number maxAmount = 10000.0;
            Number minAmount = 0.0;
//        String startDate = inputFrom.getText().toString();
            String startDate = "2020-04-30 12:00";
            presenter.getCarByDateLocationPrice(ascending, currentPage, endDate, itemsOnPage, latitude, longitude, maxAmount, minAmount, startDate);
        }
    }

    @Override
    public void showProgress() {
        myProgress.setVisibility(View.VISIBLE);
        yallaBtn.setEnabled(false);
        inputFrom.setEnabled(false);
        inputLocation.setEnabled(false);
        inputTill.setEnabled(false);
    }

    @Override
    public void hideProgress() {
        myProgress.setVisibility(View.INVISIBLE);
        yallaBtn.setEnabled(true);
        inputFrom.setEnabled(true);
        inputLocation.setEnabled(true);
        inputTill.setEnabled(true);
    }

    @Override
    public void showError(String error) { }

    @Override
    public void showNextView(ResponseCarsFiltersDto responseCars) {
        MapFragment mapFragment = MapFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putParcelable("cars", responseCars);
        mapFragment.setArguments(bundle);
        Objects.requireNonNull(getFragmentManager()).beginTransaction()
                .replace(R.id.root, mapFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void hideErrorDialog() {

    }

    @Override
    public void onClickAdapter(int position, CarForUsersDto car) {
        Toast.makeText(requireContext(), "Clicked " + car.getModel(), Toast.LENGTH_SHORT).show();
    }


}
