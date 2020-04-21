package com.telran.cars.presentation.main.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.telran.cars.business.withoutauth.WithoutAuthInteractorImpl;
import com.telran.cars.data.dto.CarForUsersDto;
import com.telran.cars.data.dto.test.Person;
import com.telran.cars.data.provider.store.StoreProvider;
import com.telran.cars.data.repository.withoutauth.WithoutAuthRepositoryImpl;
import com.telran.cars.presentation.main.presenter.MainSearchPresentor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentStartNew extends MvpAppCompatFragment implements MainFragment, View.OnClickListener, MyAdapter.OnRowClickListener {
    TextInputEditText inputFrom, inputLocation, inputTill;
    AppCompatButton yallaBtn;
    @InjectPresenter
    MainSearchPresentor presentor;
    MyAdapter adapter;
    List<CarForUsersDto> cars;
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
        yallaBtn = view.findViewById(R.id.yallaBtn);
        yallaBtn.setOnClickListener(this);
        rv = view.findViewById(R.id.my_rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);

        rv.setLayoutManager(layoutManager);
        rv.addItemDecoration(divider);
        presentor.getThreeBestCar();
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
            Integer itemsOnPage = 3;
            Number latitude = 32.0879;
            Number longitude = 34.7272;
            Number maxAmount = 10000.0;
            Number minAmount = 0.0;
//        String startDate = inputFrom.getText().toString();
            String startDate = "2020-04-30 12:00";
            presentor.getCarByDateLocationPrice(ascending, currentPage, endDate, itemsOnPage, latitude, longitude, maxAmount, minAmount, startDate);
        }
    }

    @Override
    public void showProgress() { }

    @Override
    public void hideProgress() { }

    @Override
    public void showError(String error) { }

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

    @Override
    public void onClickAdapter(int position, CarForUsersDto car) {
        Toast.makeText(requireContext(), "Clicked " + car.getModel(), Toast.LENGTH_SHORT).show();
    }


}
