package com.example.t0u000c.lab1;

/**
 * Created by t0u000c on 9/24/17.
 */

public class SecondOperandState implements ICalculatorState {

    private MainActivity calculatorControl;

    public SecondOperandState(MainActivity calculatorControl){
        this.calculatorControl  = calculatorControl;
    }

    @Override
    public void pressNumber(String input) {
        if(calculatorControl.getOperator().equals("=")){
            calculatorControl.setTexResultView(input);
            calculatorControl.setSign("");
            calculatorControl.setOperator("");
            calculatorControl.setState(calculatorControl.getFirsOperandState());
        }else {
            if (calculatorControl.getTextResultView().length() <= 6) {
                if (calculatorControl.getTextResultView().equals("0") && input.equals("0")) {
                    calculatorControl.setTexResultView(input);
                } else if (calculatorControl.getTextResultView().equals("0") && !input.equals("0")) {
                    calculatorControl.setTexResultView(input);
                } else {
                    calculatorControl.setTexResultView(calculatorControl.getTextResultView() + input);
                }
            }else{
                calculatorControl.setTexResultView("!ERROR");
                calculatorControl.setFirstOperand(0);
                calculatorControl.setSign("");
                calculatorControl.setState(calculatorControl.getStartState());
            }
        }
    }

    @Override
    public void pressOperator(String input) {
        //calculate the result
        String temp = calculatorControl.getTextResultView();
        String sign = temp.substring( temp.length()-1).equals("-")? "-":"";

        int secondOperand = sign.equals("-") ? -1*Integer.parseInt((temp+"").substring(0, temp.length()-1))
                : Integer.parseInt(temp+"");

        int firstOperand = calculatorControl.getFirstOperand();
        int result = 0;
        switch(calculatorControl.getOperator()){
            case "+": result = firstOperand + secondOperand;break;
            case "-": result = firstOperand - secondOperand;break;
            case "*": result = firstOperand * secondOperand;break;
            case "/": {
                if(secondOperand == 0)
                {
                    calculatorControl.setTexResultView("!ERROR");
                    calculatorControl.setSign("");
                    calculatorControl.setFirstOperand(0);
                    calculatorControl.setState(calculatorControl.getStartState());
                    return;
                }

                result = ((firstOperand < 0) ? -1: 1 ) * Math.round((float) (Math.abs(firstOperand)) / secondOperand);break;
            }
            default : result = firstOperand;
        }

        if(result > 9999999 || result < -9999999)
        {
            calculatorControl.setTexResultView("!ERROR");
            calculatorControl.setSign("");
            calculatorControl.setFirstOperand(0);
            calculatorControl.setState(calculatorControl.getStartState());
            return;
        }
        calculatorControl.setOperator(input);
        calculatorControl.setFirstOperand(result);
        calculatorControl.setTexResultView(result >= 0 ? result + "" : Math.abs(result) + "" + "-");
        if(!input.equals("="))
            calculatorControl.setState(calculatorControl.getOperatorState());

    }

    @Override
    public void pressClear() {
        calculatorControl.reSet();
    }

}
