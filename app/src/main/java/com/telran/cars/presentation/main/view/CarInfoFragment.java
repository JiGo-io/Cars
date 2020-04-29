package com.telran.cars.presentation.main.view;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.telran.cars.R;
import com.telran.cars.data.dto.CarsFiltersDto;
import com.telran.cars.presentation.main.presenter.CarInfoPresenter;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarInfoFragment extends MvpAppCompatFragment implements ICarInfoFragment, View.OnClickListener {
    TextView modelTxt, engineTxt, hpTxt, fuelTxt, torqueTxt, gearTxt, doorsTxt, fuelConsTxt, seatsTxt, wdTxt, classTxt, descriptionTxt, priceTxt, sumTxt;
    RecyclerView rvCar;
    AppCompatButton rentBtn, calcBtn, payBtn;
    LinearLayout calcLayout, payLayout;
    int key;

    @InjectPresenter
    CarInfoPresenter presenter;

    public CarInfoFragment() {
        // Required empty public constructor
    }

    public static CarInfoFragment newInstanse() {
        CarInfoFragment carInfoFragment = new CarInfoFragment();
        return carInfoFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_car_info, container, false);
        modelTxt = view.findViewById(R.id.modelTxt);
        engineTxt = view.findViewById(R.id.engineTxt);
        hpTxt = view.findViewById(R.id.hpTxt);
        fuelTxt = view.findViewById(R.id.fuelTxt);
        torqueTxt = view.findViewById(R.id.torqueTxt);
        gearTxt = view.findViewById(R.id.gearTxt);
        doorsTxt = view.findViewById(R.id.doorsTxt);
        fuelConsTxt = view.findViewById(R.id.fuelConsTxt);
        seatsTxt = view.findViewById(R.id.seatsTxt);
        wdTxt = view.findViewById(R.id.wdTxt);
        classTxt = view.findViewById(R.id.classTxt);
        descriptionTxt = view.findViewById(R.id.descriptionTxt);
        priceTxt = view.findViewById(R.id.priceTxt);
        sumTxt = view.findViewById(R.id.sumTxt);

        rentBtn = view.findViewById(R.id.rentBtn);
        calcBtn = view.findViewById(R.id.calcBtn);
        payBtn = view.findViewById(R.id.payBtn);
        rvCar = view.findViewById(R.id.rvCar);
        calcLayout = view.findViewById(R.id.calcLayout);
        payLayout = view.findViewById(R.id.payLayout);

        Bundle bundle = getArguments();
        key = bundle.getInt("carInfo", -1);
        setInfo(key);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false);
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(requireContext(),DividerItemDecoration.HORIZONTAL);
        rvCar.setLayoutManager(layoutManager);
        rvCar.addItemDecoration(divider);

        rentBtn.setOnClickListener(this);
        calcBtn.setOnClickListener(this);
        payBtn.setOnClickListener(this);

        return view;
    }

    private void setInfo(int key) {
        if (key>=0) {
            CarInfoAdapter adapter = new CarInfoAdapter(presenter.images(key));
            rvCar.setAdapter(adapter);
            CarsFiltersDto car = presenter.carsFilters(key);
            modelTxt.setText(car.getMake() + " " + car.getModel());
            engineTxt.setText(car.getEngine());
            hpTxt.setText(String.valueOf(car.getHorsepower()));
            fuelTxt.setText(car.getFuel());
            torqueTxt.setText(String.valueOf(car.getTorque()));
            gearTxt.setText(car.getGear());
            doorsTxt.setText(String.valueOf(car.getDoors()));
            fuelConsTxt.setText(String.valueOf(car.getFuel_consumption()));
            seatsTxt.setText(String.valueOf(car.getSeats()));
            wdTxt.setText(car.getWheels_drive());
            classTxt.setText(car.getCar_class());
            descriptionTxt.setText(car.getAbout());
        }
    }

    @Override
    public void showLogView() {
        LoginFragment loginFragment = LoginFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putInt("login", 1);
        loginFragment.setArguments(bundle);
        Objects.requireNonNull(getFragmentManager()).beginTransaction()
                .replace(R.id.root, loginFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showNextView() {
        Objects.requireNonNull(getFragmentManager()).beginTransaction()
                .replace(R.id.root, new AboutFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void addCalculate() {
        rentBtn.setVisibility(View.GONE);
        calcBtn.setVisibility(View.VISIBLE);
        calcLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rentBtn) {
            presenter.rent();
        } else if (v.getId() == R.id.calcBtn) {
            calcLayout.setVisibility(View.GONE);
            payLayout.setVisibility(View.VISIBLE);
            calcBtn.setVisibility(View.GONE);
            payBtn.setVisibility(View.VISIBLE);
            priceTxt.setText("2 days X " + String.valueOf(presenter.carsFilters(key).getPrice_per_day()) + " $ perday");
            sumTxt.setText(String.valueOf((presenter.carsFilters(key).getPrice_per_day()*2)));
        } else if (v.getId() == R.id.payBtn) {
            presenter.reserv(key);
        }
    }
}
