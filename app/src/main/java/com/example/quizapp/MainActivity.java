package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.view.View;

import com.example.quizapp.Model.Quesstion;
import com.example.quizapp.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

        private ActivityMainBinding binding;
        private int CurrentQuestion =0;
    private Quesstion [] quesstions = new Quesstion[]{
      new Quesstion(R.string.india,true)
      ,new Quesstion(R.string.bangaldesh,false),
      new Quesstion(R.string.apj,true),
      new Quesstion(R.string.sachin,false),
      new Quesstion(R.string.zero,true),
      new Quesstion(R.string.awesome,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.textView2.setText(quesstions[CurrentQuestion].getAnswerResId());

        binding.nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               CurrentQuestion= (CurrentQuestion + 1) % (quesstions.length) ;
                binding.textView2.setText(quesstions[CurrentQuestion].getAnswerResId());


            }
        });

        binding.prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(CurrentQuestion >0)
               {
                   CurrentQuestion = (CurrentQuestion - 1) ;
                   binding.textView2.setText(quesstions[CurrentQuestion].getAnswerResId());
               }
            }
        });


        binding.Truebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalRelsult(true);
            }
        });

        binding.falsebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalRelsult(false);
            }
        });


    }

    private void finalRelsult(boolean result) {

        boolean isCorrect = quesstions[CurrentQuestion].getAnserTrue();
        int ansTextl;
        if(result==isCorrect)
        {
            ansTextl= R.string.correct;
            Snackbar.make(binding.textView2,ansTextl,Snackbar.LENGTH_SHORT).show();
        }
        else
            ansTextl= R.string.inCorrect;
        Snackbar.make(binding.textView2,ansTextl,Snackbar.LENGTH_SHORT).show();

    }
}