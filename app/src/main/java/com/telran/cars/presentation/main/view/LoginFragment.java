package com.telran.cars.presentation.main.view;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.material.textfield.TextInputEditText;
import com.telran.cars.R;
import com.telran.cars.presentation.main.presenter.AuthPresenter;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends MvpAppCompatFragment implements IAuthFragment, View.OnClickListener {
    TextInputEditText inputEmail, inputPassword, inputName, inputLastName;
    TextView logText, regText, agreeText, forgotText, clickText, typeYallaText;
    AppCompatButton yallaBtn, restoreBtn;
    int key;

    @InjectPresenter
    AuthPresenter presenter;

    public LoginFragment() {
    }

    public static LoginFragment newInstance(){
        LoginFragment loginFragment = new LoginFragment();
        return loginFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Bundle bundle = getArguments();
        key = bundle.getInt("login", 0);
        inputEmail = view.findViewById(R.id.inputEmail);
        inputPassword = view.findViewById(R.id.inputPassword);
        inputName = view.findViewById(R.id.inputName);
        inputLastName = view.findViewById(R.id.inputLastName);
        logText = view.findViewById(R.id.logText);
        regText = view.findViewById(R.id.regText);
        typeYallaText = view.findViewById(R.id.typeYallaText);
        agreeText = view.findViewById(R.id.agreeText);
        forgotText = view.findViewById(R.id.forgotText);
        clickText = view.findViewById(R.id.clickText);
        yallaBtn = view.findViewById(R.id.yallaBtn);
        restoreBtn = view.findViewById(R.id.restoreBtn);
        visible(key);
        yallaBtn.setOnClickListener(this);
        restoreBtn.setOnClickListener(this);
        clickText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            inputPassword.setVisibility(View.GONE);
            yallaBtn.setVisibility(View.GONE);
            restoreBtn.setVisibility(View.VISIBLE);
            forgotText.setVisibility(View.GONE);
            clickText.setVisibility(View.GONE);
            typeYallaText.setText("Let's restore access using email. \n We will send you a letter with instructions");
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.yallaBtn) {
            if (key == 1) {
                presenter.onLogin(inputEmail.getText().toString(), inputPassword.getText().toString());
//            presenter.onLogin("VolkovAlex@mail.ru", "Aa12345~");
            } else if (key == 0) {
                presenter.onRegistration(inputEmail.getText().toString(), inputPassword.getText().toString(),
                        inputName.getText().toString(), inputLastName.getText().toString());
            }
        } else if (v.getId() == R.id.restoreBtn) {
            presenter.remindPassword(inputEmail.getText().toString());
        }
    }


    @Override
    public void showNextView() {
        Objects.requireNonNull(getFragmentManager()).beginTransaction()
                .replace(R.id.root, new MapFragment())
                .addToBackStack(null)
                .commit();
    }

    public void visible(int i) {
            if (i == 0) {
                logText.setText("Registration");
                inputName.setVisibility(View.VISIBLE);
                inputLastName.setVisibility(View.VISIBLE);
                agreeText.setVisibility(View.VISIBLE);
                forgotText.setVisibility(View.GONE);
                clickText.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
