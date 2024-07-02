package com.example.testapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.lights.LightsManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.testapp.controller.Controller;
import com.example.testapp.data.TestData;

import java.util.ArrayList;
import java.util.List;

public class TestScreen extends AppCompatActivity {


    private List<RadioButton> radios;
    private List<TextView> variants;
    private TextView question;

    private  TextView currentNumber;

    private AppCompatButton buttonSkip;

    private AppCompatButton buttonNext;

    private Controller controller;

    private Dialog dialog;

    private TextView textCorrectinDialog;

    private TextView textWronginDialog;

    private TextView textSkipinDialog;

    private AppCompatButton buttonNewTestInDialog;
    private ImageView buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_screen);

        loadViews();
        describeData(controller.getDataByPosition());

    }

    private void loadViews()
    {


        dialog=new Dialog(this);

        buttonNext=findViewById(R.id.button_next);
        buttonSkip=findViewById(R.id.button_skip);
        buttonBack=findViewById(R.id.button_back);

        controller=new Controller();

        question=findViewById(R.id.text_question);
        currentNumber=findViewById(R.id.text_number);

        radios=new ArrayList<>(4);

        radios.add(findViewById(R.id.radio_1));
        radios.add(findViewById(R.id.radio_2));
        radios.add(findViewById(R.id.radio_3));
        radios.add(findViewById(R.id.radio_4));

        variants=new ArrayList<>();
        variants.add(findViewById(R.id.button_1));
        variants.add(findViewById(R.id.button_2));
        variants.add(findViewById(R.id.button_3));
        variants.add(findViewById(R.id.button_4));

        buttonBack.setOnClickListener(view -> {
            finish();
        });

        for (int i = 0; i < radios.size(); i++) {
            int finali = i;
            radios.get(i).setOnCheckedChangeListener((button, bool) -> {
                if(!bool) return;
                clearOldCheked();

                button.setChecked(true);
                buttonNext.setEnabled(true);
            });
        }


        buttonNext.setOnClickListener(view -> {

            controller.checkUserAnswer(getSelectVariant());
            clearOldCheked();

            lastquestion();


        });


        buttonSkip.setOnClickListener(view -> {

            controller.setSkipAnswer();

            lastquestion();

        });

    }

    private void lastquestion()
    {
        if(!controller.isLastQuestion()){
            Toast.makeText(this, "Finish", Toast.LENGTH_SHORT).show();
            showDialog();
        }
        else {
            describeData(controller.getDataByPosition());
            buttonNext.setEnabled(false);}
    }

    private void clearOldCheked() {
        for (int i = 0; i < radios.size(); i++) {
            radios.get(i).setChecked(false);
        }
    }

    private void describeData(TestData data)
    {
        question.setText(data.getQuestion());

        variants.get(0).setText(data.getVariant1());
        variants.get(1).setText(data.getVariant2());
        variants.get(2).setText(data.getVariant3());
        variants.get(3).setText(data.getVariant4());

        int currenPos=controller.getPosition();
        currentNumber.setText(controller.getPosition()+"/"+controller.getMAX_COUNT());

    }

    private String getSelectVariant()
    {
        int pos=0;
        for (int i = 0; i < radios.size(); i++) {
            if(radios.get(i).isChecked())
            {
                pos=i;
                break;
            }
        }
        return variants.get(pos).getText().toString();
    }

    private void showDialog()
    {
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textCorrectinDialog=dialog.findViewById(R.id.text_correct_in_dialog);

        textWronginDialog=dialog.findViewById(R.id.text_wrong_in_dialog);

        textSkipinDialog=dialog.findViewById(R.id.text_skip_in_dialog);

        buttonNewTestInDialog=dialog.findViewById(R.id.button_new_test_in_dialog);

        textCorrectinDialog.setText(String.valueOf(controller.getCorrectAnswer()));

        textWronginDialog.setText((String.valueOf(controller.getWrongAnswer())));

        textSkipinDialog.setText(String.valueOf(controller.getSkipAnswer()));

        buttonNewTestInDialog.setOnClickListener(view -> {
            Intent intent1=new Intent(this,TestScreen.class);
            startActivity(intent1);
            finish();

        });

        dialog.show();
    }
}