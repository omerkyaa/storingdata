package com.omerkaya.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText2);

        textView = findViewById(R.id.textView);

        //veri kaydetme
        sharedPreferences = this.getSharedPreferences("com.omerkaya.stoingdata", Context.MODE_PRIVATE);

        //kayıtlı veriyi geri alma
        int storedAge = sharedPreferences.getInt("storedAge", 0); //kayıtlı bişey yoksa bu değeri alır.

        if (storedAge == 0) {
            textView.setText("Your Age: ");
        }
        else {
            textView.setText("Your Age: " + storedAge);

        }


    }

    public void save (View view) {
        if (!editText.getText().toString().matches("")){
            int userAge = Integer.parseInt(editText.getText().toString());

            textView.setText("Your age: " + userAge);

            sharedPreferences.edit().putInt("storedAge",userAge).apply();


        }


    }

    public void delete (View view) {
        //verileri silme böyle yapılır.

        int storedData = sharedPreferences.getInt("storedAge", 0);

        if (storedData != 0) {
            //eğer storedData 0'a eşit değilse anlamına gelir.
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("Your Age: ");
        }
    }




}