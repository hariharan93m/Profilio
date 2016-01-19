package com.example.hariharanm.profilio;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by hariharanm on 9/10/2015.
 */
public class LM_Fragment extends Fragment {

    private Button submit;
    private EditText username;
    private EditText password;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /**
         * Inflate the layout for this fragment
         */
        setRetainInstance(true);
        return inflater.inflate(
                R.layout.lm_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        submit = (Button) view.findViewById(R.id.button);
        username = (EditText) view.findViewById(R.id.editText);
        password = (EditText) view.findViewById(R.id.editText2);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().equals("user") && (password.getText().toString().equals("hari"))) {
                    Intent intent = new Intent(getActivity(),com.example.hariharanm.profilio.DetailActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
