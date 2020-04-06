package com.telran.cars.presentation.main.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.telran.cars.R;
import com.telran.cars.data.dto.test.Person;

public class FragmentEnd extends Fragment implements MyAdapter.OnRowClickListener {
    public static FragmentEnd newInstance(){
        FragmentEnd fragmentEnd = new FragmentEnd();
        return fragmentEnd;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.end_layout,container,false);
        MyAdapter adapter = new MyAdapter();
        RecyclerView rv = view.findViewById(R.id.my_rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
        rv.setAdapter(adapter);
        rv.setLayoutManager(layoutManager);
        rv.addItemDecoration(divider);

        return view;
    }

    @Override
    public void onClick(int position, Person p) {
        Toast.makeText(requireContext(), "Clicked " + p.getName(), Toast.LENGTH_SHORT).show();
    }
}
