package com.example.t0u000c.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private static final String CURRENT_STATE = "CURRENTSTATE";
    private static final String FIRST_OPERAND_STATE = "FIRSTOPERANDSTATE";
    private static final String SECOND_OPERAND_STATE = "SECONDOPERANDSTATE";
    private static final String OPERATE_STATE = "OPERATORSTATE";
    private static final String START_STATE = "STARTSTATE";


    private TextView textResult;
    private Button mButton0;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;

    private Button mButtonPlus;
    private Button mButtonSub;
    private Button mButtonMul;
    private Button mButtonDiv;

    private Button mButtonC;
    private Button mButtonEqual;


    public void setTexResultView(String input){
        this.textResult.setText(input);
    }

    public String getTextResultView(){
        return this.textResult.getText()+"";
    }
    /////////////


    private ICalculatorState currentState;
    private FirstOperandState firstOperandState;
    private SecondOperandState secondOperandState;
    private OperatorState operatorState;
    private StartState startState;

    public void setState(ICalculatorState state){
        this.currentState = state;
    }

    public ICalculatorState getCurrentState(){
        return this.currentState;
    }

    public ICalculatorState getFirsOperandState(){
        return this.firstOperandState;
    }

    public ICalculatorState getSecondOperandState(){
        return this.secondOperandState;
    }

    public ICalculatorState getStartState(){
        return this.startState;
    }

    public ICalculatorState getOperatorState(){
        return this.operatorState;
    }




    ///////////
    private int firstOperand = 0;
    private String operator="";
    private String sign="";

    public void setSign(String sign){
        this.sign = sign;
    }

    public String getSign(){
        return this.sign;
    }


    public int getFirstOperand(){
        return firstOperand;
    }

    public void setFirstOperand(int firstOperand){
        this.firstOperand = firstOperand;
    }

    public String getOperator(){
        return this.operator;
    }

    public void setOperator(String operator){
        this.operator = operator;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up state

        this.startState = new StartState(this);
        this.firstOperandState = new FirstOperandState(this);
        this.secondOperandState = new SecondOperandState(this);
        this.operatorState = new OperatorState(this);
        this.currentState = startState;


        //////////////////////


        textResult = (TextView) findViewById(R.id.result);

        mButton0 = (Button) findViewById(R.id.button_0);
        mButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressNumber(((Button)view).getText()+"");

            }
        });
        mButton1 = (Button) findViewById(R.id.button_1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressNumber(((Button)view).getText()+"");
            }
        });
        mButton2 = (Button) findViewById(R.id.button_2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressNumber(((Button)view).getText()+"");
            }
        });
        mButton3 = (Button) findViewById(R.id.button_3);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressNumber(((Button)view).getText()+"");
            }
        });
        mButton4 = (Button) findViewById(R.id.button_4);
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressNumber(((Button)view).getText()+"");
            }
        });
        mButton5 = (Button) findViewById(R.id.button_5);
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressNumber(((Button)view).getText()+"");
            }
        });
        mButton6 = (Button) findViewById(R.id.button_6);
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressNumber(((Button)view).getText()+"");
            }
        });
        mButton7 = (Button) findViewById(R.id.button_7);
        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressNumber(((Button)view).getText()+"");
            }
        });
        mButton8 = (Button) findViewById(R.id.button_8);
        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressNumber(((Button)view).getText()+"");
            }
        });
        mButton9 = (Button) findViewById(R.id.button_9);
        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressNumber(((Button)view).getText()+"");
            }
        });

        mButtonPlus = (Button) findViewById(R.id.button_plus);
        mButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressOperator(((Button)view).getText()+"");
            }
        });
        mButtonSub = (Button) findViewById(R.id.button_sub);
        mButtonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressOperator(((Button)view).getText()+"");
            }
        });
        mButtonMul = (Button) findViewById(R.id.button_mul);
        mButtonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressOperator(((Button)view).getText()+"");
            }
        });
        mButtonDiv = (Button) findViewById(R.id.button_div);
        mButtonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressOperator(((Button)view).getText()+"");
            }
        });

        mButtonC = (Button) findViewById(R.id.button_C);
        mButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressClear();
            }
        });

        mButtonEqual = (Button) findViewById(R.id.button_equal);
        mButtonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState.pressOperator(((Button)view).getText()+"");
            }
        });
    }

    public void reSet(){
        textResult.setText("0");
        firstOperand = 0;
        operator = "";
        sign = "";
        currentState = startState;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

    }
}
