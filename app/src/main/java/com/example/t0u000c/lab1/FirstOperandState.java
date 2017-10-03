package com.example.t0u000c.lab1;

/**
 * Created by t0u000c on 9/24/17.
 */

public class FirstOperandState implements ICalculatorState {

    private MainActivity calculatorControl;

    public FirstOperandState(MainActivity calculatorControl){
        this.calculatorControl  = calculatorControl;
    }
    @Override
    public void pressNumber(String input) {

        if(calculatorControl.getOperator().equals("=") && input.equals("0")){
            //return;
        }else if(calculatorControl.getOperator().equals("=") && !input.equals("0")){
            calculatorControl.setOperator("");
            calculatorControl.setSign("");
            calculatorControl.setTexResultView(input);
            //return;
        }else {
            String currentTextView = calculatorControl.getTextResultView();
            String sign = calculatorControl.getSign();

            if ((currentTextView.length() <= 6 && !sign.equals("-")) || (currentTextView.length() <= 7 && sign.equals("-"))) {

                int resultInt = Integer.parseInt((sign.equals("-") ? currentTextView.substring(0, currentTextView.length() - 1) : currentTextView) + "" + input);
                String temp = resultInt + "" + (sign.equals("-") ? "-" : "");
                calculatorControl.setTexResultView(temp);
            } else {
                calculatorControl.setTexResultView("!ERROR");
                calculatorControl.setSign("");
                calculatorControl.setFirstOperand(0);
                calculatorControl.setState(calculatorControl.getStartState());
            }
        }
    }

    @Override
    public void pressOperator(String input) {
            if(calculatorControl.getSign().equals("*") || calculatorControl.getSign().equals("/"))
            {
                calculatorControl.setTexResultView("!ERROR");
                calculatorControl.setSign("");
                calculatorControl.setFirstOperand(0);
                calculatorControl.setState(calculatorControl.getStartState());
                //return;
            }else {
                String temp = calculatorControl.getTextResultView();
                String sign = temp.substring(temp.length() - 1).equals("-") ? "-" : "";

                int firstOperand = sign.equals("-") ? -1 * Integer.parseInt((temp + "").substring(0, temp.length() - 1))
                        : Integer.parseInt(temp + "");
                if (!input.equals("=")) {
                    calculatorControl.setFirstOperand(firstOperand);
                    calculatorControl.setState(calculatorControl.getOperatorState());
                    calculatorControl.setOperator(input);
                } else {
                    if (calculatorControl.getSign().equals("*") || calculatorControl.getSign().equals("/")) {
                        calculatorControl.setTexResultView("!ERROR");
                        calculatorControl.setFirstOperand(0);
                        calculatorControl.setSign("");
                        calculatorControl.setState(calculatorControl.getStartState());
                        return;
                    }
                    calculatorControl.setOperator(input);
                }
            }
    }

    @Override
    public void pressClear() {
        calculatorControl.reSet();
    }

}
