package com.telran.cars.presentation.main.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.telran.cars.R;
import com.telran.cars.data.dto.CarsFiltersDto;
import com.telran.cars.data.dto.ResponseCarsFiltersDto;
import com.telran.cars.presentation.main.presenter.MapPresenter;

import java.util.Arrays;

public class MapFragment extends MvpAppCompatFragment implements OnMapReadyCallback, IMapFragment, View.OnClickListener, MapAdapter.OnRowClickListener {
    RecyclerView rvMap, rvAllCar;
    LinearLayout mapCont;
    @InjectPresenter
    MapPresenter presenter;
    MapAdapter adapter;
    GoogleMap map;

    private static final float DEFAULT_ZOOM = 15f;

    public MapFragment() {

    }

    public static MapFragment newInstance() {
        MapFragment fragmentMap = new MapFragment();
        return fragmentMap;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_map, container, false);
        Bundle bundle = getArguments();
        ResponseCarsFiltersDto responseCars = bundle.getParcelable("cars");
        adapter = new MapAdapter(requireContext());
        adapter.setCars(Arrays.asList(responseCars.getCars()));
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        rvMap = view.findViewById(R.id.rvMap);
        rvAllCar = view.findViewById(R.id.rvAllCar);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false);
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL);
        rvMap.setLayoutManager(layoutManager);
        rvMap.addItemDecoration(divider);
        rvMap.setAdapter(adapter);


        FloatingActionButton listBtn = view.findViewById(R.id.listBtn);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapCont = view.findViewById(R.id.mapCont);
                mapCont.setVisibility(View.INVISIBLE);
                rvAllCar.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
                rvMap.setVisibility(View.INVISIBLE);
                rvAllCar.setVisibility(View.VISIBLE);
                rvAllCar.setAdapter(adapter);
            }
        });
        FloatingActionButton mapBtn = view.findViewById(R.id.mapBtn);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapCont.setVisibility(View.VISIBLE);
                rvMap.setVisibility(View.VISIBLE);
                rvAllCar.setVisibility(View.INVISIBLE);
            }
        });

        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng lng = new LatLng(32.0740814, 34.7900141);
        map.addMarker(new MarkerOptions().position(lng).title("Azriel"));
//        map.moveCamera(CameraUpdateFactory.newLatLng(lng));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(lng, DEFAULT_ZOOM));
    }
    @Override
    public void showNextView(CarsFiltersDto car) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onClickAdapter(int position, CarsFiltersDto car) {
        showNextView(car);
    }
}
