package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] names = {"blue", "green", "red", "yellow", "black"};
        String[] color = {"#0027FF","#11FB00","#E91E1E", "#FFEB3B", "#000000"};

        ArrayAdapter<String> AA = new ArrayAdapter<String>(
                this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,names
        );

        RadioButton radbtn1 = findViewById(R.id.radbtn1);
        RadioButton radbtn2 = findViewById(R.id.radbtn2);
        RadioButton radbtn3 = findViewById(R.id.radbtn3);
        SeekBar seek = findViewById(R.id.seek);
        Spinner spinner = findViewById(R.id.spin);
        spinner.setAdapter(AA);
        ConstraintLayout main = findViewById(R.id.main);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                main.setBackgroundColor(Color.parseColor(color[i]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        radbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radbtn1.isChecked()) {
                    radbtn1.setTextColor(Color.parseColor("#11FB00"));
                    radbtn2.setTextColor(Color.parseColor("#FFFFFFFF"));
                    radbtn3.setTextColor(Color.parseColor("#FFFFFFFF"));
                }
            }
        });

        radbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radbtn2.isChecked()) {
                    radbtn2.setTextColor(Color.parseColor("#0027FF"));
                    radbtn1.setTextColor(Color.parseColor("#FFFFFFFF"));
                    radbtn3.setTextColor(Color.parseColor("#FFFFFFFF"));
                }
            }
        });

        radbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radbtn3.isChecked()){
                    radbtn3.setTextColor(Color.parseColor("#E91E1E"));
                    radbtn1.setTextColor(Color.parseColor("#FFFFFFFF"));
                    radbtn2.setTextColor(Color.parseColor("#FFFFFFFF"));
                }

            }
        });

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(getApplicationContext(), "Value = " + i, Toast.LENGTH_LONG).show();
                if(i <= 33){
                    radbtn1.setTextColor(Color.parseColor("#11FB00"));
                    radbtn2.setTextColor(Color.parseColor("#FFFFFFFF"));
                    radbtn3.setTextColor(Color.parseColor("#FFFFFFFF"));
                }
                else if(i <= 66){
                    radbtn2.setTextColor(Color.parseColor("#0027FF"));
                    radbtn1.setTextColor(Color.parseColor("#FFFFFFFF"));
                    radbtn3.setTextColor(Color.parseColor("#FFFFFFFF"));
                }
                else {
                    radbtn3.setTextColor(Color.parseColor("#E91E1E"));
                    radbtn1.setTextColor(Color.parseColor("#FFFFFFFF"));
                    radbtn2.setTextColor(Color.parseColor("#FFFFFFFF"));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }



}