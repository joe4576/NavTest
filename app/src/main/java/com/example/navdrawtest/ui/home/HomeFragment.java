package com.example.navdrawtest.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.navdrawtest.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView textView;
    private boolean clicked = false;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class); // ignore view model stuff for now

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        textView = root.findViewById(R.id.text_home);


        /*homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        //textView.setText("Test");
        textView.setText("New test");

        Log.d("debug_string", "Home fragment onCreateView");

        Button button = (Button) root.findViewById(R.id.button_test);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(clicked){
                    textView.setText("Button not clicked");
                } else {
                    textView.setText("Button clicked");
                }
                clicked = !clicked;
            }
        });

        return root;
    }

}