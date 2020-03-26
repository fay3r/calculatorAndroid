package com.pl.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edit,sign,history;
    boolean plus = true;
    Button but1,but2,but3,but4,but5,but6,but7,but8,but9,but0,butAdd,butSub,butMult,butDiv,
            butPlusMinus,butDel,result,butAC,butDot,butPercentage;
    Button sqrt,log10,silnia,butDouble,butTriple;
    Double input1,input2;
    Character action;
    String savedHistory,savedResult;
    Integer mode=1;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("savedResultTag",savedResult);
        outState.putString("savedHistoryTag",savedHistory);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
            savedResult = savedInstanceState.getString("savedResultTag");
            savedHistory = savedInstanceState.getString("savedHistoryTag");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(null);

        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.textField);
        sign = findViewById(R.id.sign);
        history = findViewById(R.id.history);
        sqrt = findViewById(R.id.operSqrt);
        log10 = findViewById(R.id.operLog);
        silnia = findViewById(R.id.operSilnia);
        butDouble = findViewById(R.id.operDouble);
        butTriple = findViewById(R.id.operTriple);

        but1 = findViewById(R.id.num1);
        but2 = findViewById(R.id.num2);
        but3 = findViewById(R.id.num3);
        but4 = findViewById(R.id.num4);
        but5 = findViewById(R.id.num5);
        but6 = findViewById(R.id.num6);
        but7 = findViewById(R.id.num7);
        but8 = findViewById(R.id.num8);
        but9 = findViewById(R.id.num9);
        but0 = findViewById(R.id.num0);
        butAdd = findViewById(R.id.operAdd);
        butSub = findViewById(R.id.operSub);
        butMult = findViewById(R.id.operMultiply);
        butDiv = findViewById(R.id.operDivide);
        butPlusMinus = findViewById(R.id.plusMinus);
        butDel = findViewById(R.id.delete);
        result = findViewById(R.id.result);
        butAC = findViewById(R.id.actionClear);
        butDot = findViewById(R.id.dot);
        butPercentage = findViewById(R.id.operationPercent);

        if(savedResult==null){
            savedResult="0";
            savedHistory="";
        }
        clickingNumb();
        operations();
        finalResult();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            landscapeButtons();
        }
    }

    private void landscapeButtons() {
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(plus){
                    input2=Math.sqrt(Double.valueOf(edit.getText().toString()));
                    savedResult= input2.toString();
                    edit.setText(savedResult);
                }else {
                    savedResult="NaN";
                    edit.setText("NaN");
                    mode=0;
                    blocker();
                }
            }
        });

        log10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(plus){
                    input2=Math.log10(Double.valueOf(edit.getText().toString()));
                    savedResult= input2.toString();
                    edit.setText(savedResult);
                }else {
                    savedResult="NaN";
                    edit.setText("NaN");
                    mode=0;
                    blocker();
                }
            }
        });

        silnia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(plus) {
                    int i = 1, s = 1, n;
                    n = Math.round(Integer.parseInt(edit.getText().toString()));
                    while (i <= n) {
                        s = s * i;
                        i++;
                    }
                    savedResult= Integer.toString(s);
                    edit.setText(savedResult);
                }
                else{
                    savedResult="NaN";
                    edit.setText("NaN");
                    mode=0;
                    blocker();
                }
            }
        });

        butDouble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input2=Double.valueOf(edit.getText().toString());
                if(!plus) {
                    input2=-input2;
                }
                input2=Math.pow(input2,2);
                savedResult= input2.toString();
                edit.setText(savedResult);
            }
        });

        butTriple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input2=Double.valueOf(edit.getText().toString());
                if(!plus) {
                    input2=-input2;
                }
                input2=Math.pow(input2,3);
                savedResult= input2.toString();
                edit.setText(savedResult);
            }
        });
    }

    public void clickingNumb(){
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedResult.equals("0")){
                    savedResult="1";
                    edit.setText(savedResult);
                }else {
                    savedResult= savedResult+"1";
                    edit.setText(savedResult);
                }
            }
        });


        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedResult.equals("0")){
                    savedResult="2";
                    edit.setText(savedResult);
                }else {
                    savedResult= savedResult+"2";
                    edit.setText(savedResult);
                }
            }
        });

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedResult.equals("0")){
                    savedResult="3";
                    edit.setText(savedResult);
                }else {
                    savedResult= savedResult+"3";
                    edit.setText(savedResult);
                }
            }
        });

        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedResult.equals("0")){
                    savedResult="4";
                    edit.setText(savedResult);
                }else {
                    savedResult= savedResult+"4";
                    edit.setText(savedResult);
                }
            }
        });

        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedResult.equals("0")){
                    savedResult="5";
                    edit.setText(savedResult);
                }else {
                    savedResult= savedResult+"5";
                    edit.setText(savedResult);
                }
            }
        });

        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedResult.equals("0")){
                    savedResult="6";
                    edit.setText(savedResult);
                }else {
                    savedResult= savedResult+"6";
                    edit.setText(savedResult);
                }
            }
        });

        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedResult.equals("0")){
                    savedResult="7";
                    edit.setText(savedResult);
                }else {
                    savedResult= savedResult+"7";
                    edit.setText(savedResult);
                }
            }
        });

        but8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedResult.equals("0")){
                    savedResult="8";
                    edit.setText(savedResult);
                }else {
                    savedResult= savedResult+"8";
                    edit.setText(savedResult);
                }
            }
        });

        but9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedResult.equals("0")){
                    savedResult="9";
                    edit.setText(savedResult);
                }else {
                    savedResult= savedResult+"9";
                    edit.setText(savedResult);
                }
            }
        });

        but0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedResult.equals("0")){
                    savedResult="0";
                    edit.setText(savedResult);
                }else {
                    savedResult= savedResult+"0";
                    edit.setText(savedResult);
                }
            }
        });
    }

    public void finalResult(){

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input2=Double.parseDouble(edit.getText().toString());
                if(!plus){
                    input2=-input2;
                }
                if(input1 !=null && input2!=null){
                    switch (action){
                        case '+':
                            savedHistory=savedHistory+savedResult;
                            history.setText(savedHistory);
                            savedResult=String.valueOf(input1+input2);
                            edit.setText(savedResult);
                            action='x';
                            break;
                        case '-':
                            savedHistory=savedHistory+savedResult;
                            history.setText(savedHistory);
                            savedResult=String.valueOf(input1-input2);
                            edit.setText(savedResult);
                            action='x';
                            break;

                        case '*':
                            savedHistory=savedHistory+savedResult;
                            history.setText(savedHistory);
                            savedResult=String.valueOf(input1*input2);
                            edit.setText(savedResult);
                            action='x';
                            break;

                        case '/':
                            if(input2!=0){
                                savedHistory=savedHistory+savedResult;
                                history.setText(savedHistory);
                                savedResult=String.valueOf(input1/input2);
                                edit.setText(savedResult);
                                action='x';
                            break;
                            }else
                            {
                                savedHistory=savedHistory+savedResult;
                                history.setText(savedHistory);
                                savedResult="NaN";
                                edit.setText(savedResult);
                                mode=0;
                                blocker();
                                action='x';
                            }
                    }
                }
            }
        });

    }
    @SuppressLint("ClickableViewAccessibility")
    public void operations(){

        butAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedResult="0";
                edit.setText(savedResult);
                savedHistory="";
                history.setText(savedHistory);
                plus=true;
                sign.setText("");
                mode=1;
                blocker();
            }
        });

        butAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!savedResult.isEmpty()){
                    input1 = Double.parseDouble(edit.getText().toString());
                    if(plus==false) {
                        input1 = -input1;
                    }
                    savedHistory=input1 +" + ";
                    history.setText(savedHistory);
                    savedResult="0";
                    edit.setText(savedResult);
                    plus=true;
                    sign.setText("");
                    action='+';
                }
            }
        });

        butSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!savedResult.isEmpty()){
                    input1 = Double.parseDouble(edit.getText().toString());
                    if(plus==false) {
                        input1 = -input1;
                    }
                    savedHistory=input1 +" - ";
                    history.setText(savedHistory);
                    savedResult="0";
                    edit.setText(savedResult);
                    plus=true;
                    sign.setText("");
                    action='-';
                }
            }
        });

        butMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!savedResult.isEmpty()){
                    input1 = Double.parseDouble(edit.getText().toString());
                    if(plus==false) {
                        input1 = -input1;
                    }
                    savedHistory=input1 +" * ";
                    history.setText(savedHistory);
                    savedResult="0";
                    edit.setText(savedResult);
                    plus=true;
                    sign.setText("");
                    action='*';
                }
            }
        });

        butDiv.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(!savedResult.isEmpty()){
                    input1 = Double.parseDouble(edit.getText().toString());
                    if(plus==false) {
                        input1 = -input1;
                    }
                    savedHistory=input1 +" / ";
                    history.setText(savedHistory);
                    savedResult="0";
                    edit.setText(savedResult);
                    plus=true;
                    sign.setText("");
                    action='/';
                }
            }
        });

        butPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(plus){
                    plus=false;
                    sign.setText("-");
                }else{
                    plus=true;
                    sign.setText("");
                }

            }
        });

        butPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedResult=String.valueOf(Double.parseDouble(savedResult)*0.01);
                edit.setText(savedResult);
            }
        });


        butDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!savedResult.contains(".")){
                    savedResult+=".";
                    edit.setText(savedResult);
                }

            }
        });

        butDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!savedResult.isEmpty()){
                    savedResult=savedResult.subSequence(0,savedResult.length()-1).toString();
                    if(savedResult.equals("")) {
                        savedResult="0";
                        edit.setText(savedResult);
                    }else{
                        edit.setText(savedResult);
                    }
                }
            }
        });
    }

    public void blocker(){
        if(mode!=0) {
            but1.setEnabled(true);
            but2.setEnabled(true);
            but3.setEnabled(true);
            but4.setEnabled(true);
            but5.setEnabled(true);
            but6.setEnabled(true);
            but7.setEnabled(true);
            but8.setEnabled(true);
            but9.setEnabled(true);
            but0.setEnabled(true);
            butAdd.setEnabled(true);
            butSub.setEnabled(true);
            butMult.setEnabled(true);
            butDiv.setEnabled(true);
            butPlusMinus.setEnabled(true);
            butDel.setEnabled(true);
            result.setEnabled(true);
            butDot.setEnabled(true);
            butPercentage.setEnabled(true);
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                sqrt.setEnabled(true);
                log10.setEnabled(true);
                silnia.setEnabled(true);
                butDouble.setEnabled(true);
                butTriple.setEnabled(true);
            }
        }else{
            but1.setEnabled(false);
            but2.setEnabled(false);
            but3.setEnabled(false);
            but4.setEnabled(false);
            but5.setEnabled(false);
            but6.setEnabled(false);
            but7.setEnabled(false);
            but8.setEnabled(false);
            but9.setEnabled(false);
            but0.setEnabled(false);
            butAdd.setEnabled(false);
            butSub.setEnabled(false);
            butMult.setEnabled(false);
            butDiv.setEnabled(false);
            butPlusMinus.setEnabled(false);
            butDel.setEnabled(false);
            result.setEnabled(false);
            butDot.setEnabled(false);
            butPercentage.setEnabled(false);
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                sqrt.setEnabled(false);
                log10.setEnabled(false);
                silnia.setEnabled(false);
                butDouble.setEnabled(false);
                butTriple.setEnabled(false);
            }
        }

    }
}
