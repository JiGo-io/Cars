package com.telran.cars.presentation.main.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.telran.cars.R;
import com.telran.cars.presentation.main.presenter.AboutPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends MvpAppCompatFragment implements IAboutFragment{
    TextView amountTxt, bookingDateTxt, orderNumberTxt;

    @InjectPresenter
    AboutPresenter presenter;

    public AboutFragment() {

    }

    public static AboutFragment newInstance(){
        AboutFragment aboutFragment = new AboutFragment();
        return aboutFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        amountTxt = view.findViewById(R.id.amountTxt);
        bookingDateTxt = view.findViewById(R.id.bookingDateTxt);
        orderNumberTxt = view.findViewById(R.id.orderNumberTxt);

        amountTxt.setText(String.valueOf(presenter.getPersonData().getAmount()));
        bookingDateTxt.setText(presenter.getPersonData().getBooking_period());
        orderNumberTxt.setText(presenter.getPersonData().getOrder_number());
        return view;
    }
}
