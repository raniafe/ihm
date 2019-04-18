package com.example.gaspimiamva.activites;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.gaspimiamva.R;

public class StockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock);

        /*
        //get items from XML layout
        TabLayout tabLayout = findViewById(R.id.menu);
        final ViewPager viewPager = findViewById(R.id.myContainer);

        //create 3 new tabs named "Cowboys", "Indians" and "All"
        tabLayout.addTab(tabLayout.newTab().setText("Cowboys"));
        tabLayout.addTab(tabLayout.newTab().setText("Indians"));
        tabLayout.addTab(tabLayout.newTab().setText("All"));

        TabFragment3 testFragment = (TabFragment3) getSupportFragmentManager().findFragmentById(R.id.test);
        if (testFragment == null) {
            testFragment = new TabFragment3();
            getSupportFragmentManager().beginTransaction().add(R.id.test, testFragment).commit();
        }
        */

    }
}
