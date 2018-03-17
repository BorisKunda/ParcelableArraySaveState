package com.example.jbt.singers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Singer> allSingers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null)
        {
            //first time activity opened
        }
        else
        {
           //after screen rotation savedInstanceState != null
            allSingers= savedInstanceState.getParcelableArrayList("singers");

            ((ListView) findViewById(R.id.allSingersLV)).setAdapter(
                    new ArrayAdapter<Singer>(MainActivity.this,
                            android.R.layout.simple_list_item_1, allSingers));
        }

        findViewById(R.id.loadListBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                allSingers= new ArrayList<>();
                allSingers.add(new Singer("Beyonce", false) );
                allSingers.add(new Singer("Dana international", false) );
                allSingers.add(new Singer("Madonna", false) );
                allSingers.add(new Singer("Brian Adams", true) );
                allSingers.add(new Singer("Justin Beiber", true) );

                ((ListView) findViewById(R.id.allSingersLV)).setAdapter(
                        new ArrayAdapter<Singer>(MainActivity.this,
                                android.R.layout.simple_list_item_1, allSingers));

            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("singers",allSingers);

    }
}
