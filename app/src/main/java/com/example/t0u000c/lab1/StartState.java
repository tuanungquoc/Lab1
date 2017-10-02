package com.example.t0u000c.lab1;

/**
 * Created by t0u000c on 9/24/17.
 */

public class StartState implements ICalculatorState {
    private MainActivity calculatorControl;

    public StartState(MainActivity calculatorControl){
        this.calculatorControl  = calculatorControl;
    }

    @Override
    public void pressNumber(String input) {
        if(!input.equals("0")) {
            calculatorControl.setOperator("");
            calculatorControl.setState(calculatorControl.getFirsOperandState());
            calculatorControl.setTexResultView(input + (calculatorControl.getSign().equals("-") ? "-" :""));
        }
    }

    @Override
    public void pressOperator(String input) {
        // record the sign of the first operand
        if(input.equals("-"))
            calculatorControl.setSign("-");
        else if(input.equals("+"))
            calculatorControl.setSign("");
        else
            calculatorControl.setSign(input);
    }

    @Override
    public void pressClear() {
        calculatorControl.reSet();
    }
}
