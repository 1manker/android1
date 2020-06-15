package com.helloWorld;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class BlankFragment extends Fragment{
    Button button;
    TextView txt;
    TextInputEditText input;
    private OnFragmentInteractionListener mListener;

    public BlankFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        button = rootView.findViewById(R.id.button);
        txt = rootView.findViewById(R.id.txt);
        input = rootView.findViewById(R.id.input);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    String temp = input.getText().toString();
                    txt.setText("Hello, " + temp + " !");
                    Log.v(temp, "this is what the main activity is being sent");

                    mListener.onFragmentInteraction(temp);
                }

            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Activity activity = getActivity();
        try{
            mListener = (OnFragmentInteractionListener) activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString()
            + "must have frag listenener");
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String name);
    }
}
