package com.telran.cars.presentation.main.view;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    TextInputEditText inputEmail, inputPassword;
    AppCompatButton yallaBtn;

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
        inputEmail = view.findViewById(R.id.inputEmail);
        inputPassword = view.findViewById(R.id.inputPassword);
        yallaBtn = view.findViewById(R.id.yallaBtn);
        yallaBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.yallaBtn) {
            presenter.onLogin(inputEmail.getText().toString(), inputPassword.getText().toString());
//            presenter.onLogin("VolkovAlex@mail.ru", "Aa12345~");
        }
    }


    @Override
    public void showNextView() {
        Objects.requireNonNull(getFragmentManager()).beginTransaction()
                .replace(R.id.root, new MapFragment())
                .commit();
    }
}
