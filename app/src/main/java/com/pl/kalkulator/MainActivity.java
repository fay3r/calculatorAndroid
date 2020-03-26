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
    String helper;
    Integer mode=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                    edit.setText(input2.toString());
                }else {
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
                    edit.setText(input2.toString());
                }else {
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
                    edit.setText(Integer.toString(s));
                }
                else{
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
                edit.setText(input2.toString());
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
                edit.setText(input2.toString());
            }

        });
    }

    public void clickingNumb(){
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().toString().equals("0")){
                    edit.setText("1");
                }else {
                    edit.setText(edit.getText() + "1");
                }
            }
        });


        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit.getText().toString().equals("0")) {
                    edit.setText("2");
                } else {
                    edit.setText(edit.getText() + "2");
                }
            }
        });

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit.getText().toString().equals("0")) {
                    edit.setText("3");
                } else {
                    edit.setText(edit.getText() + "3");
                }
            }
        });

        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().toString().equals("0")){
                    edit.setText("4");
                }else {
                    edit.setText(edit.getText() + "4");
                }
            }
        });

        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().toString().equals("0")){
                    edit.setText("5");
                }else {
                    edit.setText(edit.getText() + "5");
                }
            }
        });

        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().toString().equals("0")){
                    edit.setText("6");
                }else {
                    edit.setText(edit.getText() + "6");
                }
            }
        });

        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().toString().equals("0")){
                    edit.setText("7");
                }else {
                    edit.setText(edit.getText() + "7");
                }
            }
        });

        but8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().toString().equals("0")){
                    edit.setText("8");
                }else {
                    edit.setText(edit.getText() + "8");
                }
            }
        });

        but9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit.getText().toString().equals("0")) {
                    edit.setText("9");
                } else {
                    edit.setText(edit.getText() + "9");
                }
            }
        });

        but0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().toString().equals("0")){
                    edit.setText("0");
                }else {
                    edit.setText(edit.getText() + "0");
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
                            history.append(edit.getText());
                            edit.setText(String.valueOf(input1+input2));
                            action='x';
                            break;
                        case '-':
                            history.append(edit.getText());
                            edit.setText(String.valueOf(input1-input2));
                            action='x';
                            break;

                        case '*':
                            history.append(edit.getText());
                            edit.setText(String.valueOf(input1*input2));
                            action='x';
                            break;

                        case '/':
                            if(input2!=0){
                                history.append(edit.getText());
                                edit.setText(String.valueOf(input1/input2));
                                action='x';
                            break;
                            }else
                            {
                                history.append(edit.getText());
                                edit.setText("NaN");
                                mode=0;
                                blocker();
                                action='x';
                            }

                        default:
                            break;
                    }

                }
                else{

                }
            }
        });

    }
    @SuppressLint("ClickableViewAccessibility")
    public void operations(){

        butAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText("0");
                history.setText("");
                plus=true;
                sign.setText("");
                mode=1;
                blocker();
            }
        });

        butAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edit.getText().toString().isEmpty()){
                    input1 = Double.parseDouble(edit.getText().toString());
                    if(plus==false) {
                        input1 = -input1;
                    }
                    history.setText(input1 +" + ");
                    edit.setText("0");
                    plus=true;
                    sign.setText("");
                    action='+';
                }
            }
        });

        butSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edit.getText().toString().isEmpty()){
                    input1 = Double.parseDouble(edit.getText().toString());
                    if(plus==false) {
                        input1 = -input1;
                    }
                    history.setText(input1 +" - ");
                    edit.setText("0");
                    plus=true;
                    sign.setText("");
                    action='-';
                }
            }
        });

        butMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edit.getText().toString().isEmpty()){
                    input1 = Double.parseDouble(edit.getText().toString());
                    if(plus==false) {
                        input1 = -input1;
                    }
                    history.setText(input1 +" * ");
                    edit.setText("0");
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
                if(!edit.getText().toString().isEmpty()){
                    input1 = Double.parseDouble(edit.getText().toString());
                    if(plus==false) {
                        input1 = -input1;
                    }
                    history.setText(input1 +" / ");
                    edit.setText("0");
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
                edit.setText(String.valueOf(Double.parseDouble(edit.getText().toString())*0.01));
            }
        });


        butDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper=edit.getText().toString();
                if(!helper.contains(".")){
                    helper+=".";
                    edit.setText(helper);
                }

            }
        });

        butDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper=edit.getText().toString();
                if(!helper.isEmpty()){
                    helper=helper.subSequence(0,helper.length()-1).toString();
                    if(helper.equals("")) {
                        edit.setText("0");
                    }else{
                        edit.setText(helper);
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
