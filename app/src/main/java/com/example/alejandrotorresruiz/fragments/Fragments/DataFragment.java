package com.example.alejandrotorresruiz.fragments.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.alejandrotorresruiz.fragments.R;

public class DataFragment extends Fragment {

    private EditText text;
    private Button btn;
    private Datalistener callback;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            callback = (Datalistener) context;
        }catch (Exception e){
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_data,container,false);

        text = (EditText) view.findViewById(R.id.editText);
        btn = (Button) view.findViewById(R.id.buttonEnviar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textEnviar = text.getText().toString();
                callback.sendData(textEnviar);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    /*
    private void sendText(String text){
    }*/


    public interface Datalistener{
        void sendData(String texto);
    }

}
