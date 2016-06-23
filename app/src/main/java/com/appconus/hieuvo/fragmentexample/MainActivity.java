package com.appconus.hieuvo.fragmentexample;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentA.OnFragmentInteractionListener, FragmentB.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.root_view, FragmentA.newInstance("A", "B"), "A").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.root_view, FragmentB.newInstance("A", "B"), "B").commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void openA(View v) {
        getSupportFragmentManager().beginTransaction().show(getSupportFragmentManager().findFragmentByTag("A")).commit();
        getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentByTag("B")).commit();
    }

    public void openB(View v) {
        getSupportFragmentManager().beginTransaction().show(getSupportFragmentManager().findFragmentByTag("B")).commit();
        getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentByTag("A")).commit();
    }

    public void textViewClick(View v) {
        if (v.getId() == R.id.tvA) {
            Toast.makeText(this, "A", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.tvB) {
            Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
        }
    }
}
