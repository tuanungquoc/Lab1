package com.example.t0u000c.lab1;

/**
 * Created by t0u000c on 9/24/17.
 */

public class OperatorState implements ICalculatorState {
    private MainActivity calculatorControl;

    public OperatorState(MainActivity calculatorControl){
        this.calculatorControl  = calculatorControl;
    }

    @Override
    public void pressNumber(String input) {
        calculatorControl.setState(calculatorControl.getSecondOperandState());
        calculatorControl.setTexResultView(input);
    }

    @Override
    public void pressOperator(String input) {

        calculatorControl.setOperator(input);
        if(input.equals("=")) {
            //calculatorControl.setState(calculatorControl.getSecondOperandState());
            calculatorControl.setTexResultView("!ERROR");
            calculatorControl.setSign("");
            calculatorControl.setFirstOperand(0);
            calculatorControl.setState(calculatorControl.getStartState());
        }

    }

    @Override
    public void pressClear() {
        calculatorControl.reSet();
    }
}
