package com.helloWorld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener{

    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fragmentManager = getSupportFragmentManager();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new BlankFragment())
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(String name) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Log.v(name, "this is what the fragment sent");
        transaction.commit();
    }
}
