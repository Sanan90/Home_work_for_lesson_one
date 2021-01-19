package com.example.android.homeworkforlessonone;

import android.widget.TextView;

import java.io.Serializable;
import java.text.DecimalFormat;

class Operations implements Serializable {

    private static String operationDisplay;
    private double mPlusMemory = 0;
    private double num = 0;
    private String maths = null;
    private String point = ".";
    private int restart = 0;
    private String lastButton;
    private String start = null;
    private double num2 = -123456789;
    private String lastAtiphmeticSymbol = null;

    public Operations() {
    }



    public void setOperationDisplay(String operationDisplay) {
        this.operationDisplay = operationDisplay;
    }

    public void setmPlusMemory(double mPlusMemory) {
        this.mPlusMemory = mPlusMemory;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public void setMaths(String maths) {
        this.maths = maths;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public void setRestart(int restart) {
        this.restart = restart;
    }

    public void setLastButton(String lastButton) {
        this.lastButton = lastButton;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setLastAtiphmeticSymbol(String lastAtiphmeticSymbol) {
        this.lastAtiphmeticSymbol = lastAtiphmeticSymbol;
    }

    public String getOperationDisplay() {
        return operationDisplay;
    }

    public double getmPlusMemory() {
        return mPlusMemory;
    }

    public double getNum() {
        return num;
    }

    public String getMaths() {
        return maths;
    }

    public String getPoint() {
        return point;
    }

    public int getRestart() {
        return restart;
    }

    public String getLastButton() {
        return lastButton;
    }

    public String getStart() {
        return start;
    }

    public double getNum2() {
        return num2;
    }

    public String getLastAtiphmeticSymbol() {
        return lastAtiphmeticSymbol;
    }

    public Operations(String operationDisplay) {
        this.operationDisplay = operationDisplay;
    }


    public void display(String a, String b) {

        if (lastButton == point) {
            b = b + point;
        }
        lastButton = a;
        if (restart != 1) {
            if (b.equals("0") && a.equals("0")) {
                return;
            } else if (b.length() < 10) {
                if (b.equals("0")) {
                    operationDisplay = a;
                } else {
                    operationDisplay = b + a;
                }
            }
        } else {
            operationDisplay = a;
            restart = 0;
            return;
        }
    }


    public void display(Double a) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String forDisplay = decimalFormat.format(a);
        operationDisplay = forDisplay;
//        rounding(operationDisplay);
    }


    public void math(String math) {

        if (lastButton == "+" || lastButton == "-" || lastButton == "*" || lastButton == "/") {
            maths = math;
            return;
        }

        if (start == null) {
            num = (double) Double.valueOf((String) operationDisplay);
            maths = math;
            display((double) num);
            restart = 1;
            start = "2";
            lastButton = math;
            lastAtiphmeticSymbol = math;
        } else if (start == "1") {
            maths = math;
            display((double) num);
            restart = 1;
            start = "2";
            lastButton = math;
            lastAtiphmeticSymbol = math;
        } else {
            if (maths.equals("-")) {
                num -= (double) Double.valueOf((String) operationDisplay);
                display((double) num);
                maths = math;
                restart = 1;
                lastButton = math;
                lastAtiphmeticSymbol = math;
            } else if (maths.equals("+")) {
                num += Double.valueOf((String) operationDisplay);
                display((double) num);
                maths = math;
                restart = 1;
                lastButton = math;
                lastAtiphmeticSymbol = math;
            } else if (maths.equals("*")) {
                num *= Double.valueOf((String) operationDisplay);
                display((double) num);
                maths = math;
                restart = 1;
                lastButton = math;
                lastAtiphmeticSymbol = math;
            } else if (maths.equals("/")) {
                num /= Double.valueOf((String) operationDisplay);
                display((double) num);
                maths = math;
                restart = 1;
                lastButton = math;
                lastAtiphmeticSymbol = math;
            }
        }
    }


    public void equal() {

        if (lastButton == "=") {
            return;
        }

        lastButton = "=";
        lastAtiphmeticSymbol = "=";
        if (maths == null) {
            return;

        } else {
            if (maths == "-") {
                if (num2 == Double.valueOf((String) operationDisplay)) {
                    num -= num2;
                    num2 = -123456789;
                    display((double) num);
                    restart = 1;
                    start = "1";
                    maths = null;
                } else {
                    num -= Double.valueOf((String) operationDisplay);
                    display((double) num);
                    restart = 1;
                    start = "1";
                    maths = null;
                }

            } else if (maths == "+") {
                if (num2 == Double.valueOf((String) operationDisplay)) {
                    num += num2;
                    num2 = -123456789;
                    display((double) num);
                    restart = 1;
                    start = "1";
                    maths = null;

                } else {
                    num += Double.valueOf((String) operationDisplay);
                    display((double) num);
                    restart = 1;
                    start = "1";
                    maths = null;
                }

            } else if (maths == "*") {
                if (num2 == Double.valueOf((String) operationDisplay)) {
                    num *= num2;
                    num2 = -123456789;
                    display((double) num);
                    restart = 1;
                    start = "1";
                    maths = null;
                } else {
                    num *= Double.valueOf((String) operationDisplay);
                    display((double) num);
                    restart = 1;
                    start = "1";
                    maths = null;
                }

            } else if (maths == "/") {
                if (num2 == Double.valueOf((String) operationDisplay)) {
                    num /= num2;
                    num2 = -123456789;
                    display((double) num);
                    restart = 1;
                    start = "1";
                    maths = null;
                } else {
                    num /= Double.valueOf((String) operationDisplay);
                    display((double) num);
                    restart = 1;
                    start = "1";
                    maths = null;
                }
            }
        }
    }

    public void ac() {
        num = 0;
        maths = null;
        restart = 0;
        lastButton = null;
        lastAtiphmeticSymbol = null;
        start = null;
        display((double) num);
    }


    public void point(String point) {
        if (operationDisplay.length() > 0 && operationDisplay.length() < 10) {
            for (int i = 0; i < operationDisplay.length(); i++) {
                String word = String.valueOf(operationDisplay.charAt(i));
                if (word.equals(point)) {
                    return;
                }
            }
//            operationDisplay = operationDisplay + point;
            lastButton = point;
        }
    }

    public void delete() {
        if (operationDisplay.length() < 1) {
            return;
        } else if (operationDisplay.length() == 1) {
            operationDisplay = "0";
            if (lastAtiphmeticSymbol == null || lastAtiphmeticSymbol == "=") {
                num = Double.valueOf((String) operationDisplay);
            } else {
                num2 = Double.valueOf((String) operationDisplay);
            }
        } else {
            String newText = "";
            for (int i = 0; i < operationDisplay.length() - 1; i++) {
                newText += String.valueOf(operationDisplay.charAt(i));
            }
            operationDisplay = newText;
            if (lastAtiphmeticSymbol == null || lastAtiphmeticSymbol == "=") {
                num = Double.valueOf((String) operationDisplay);
            } else {
                num2 = Double.valueOf((String) operationDisplay);
            }
        }
    }

    public void mPlus() {

    }



//    public void rounding(String numm) {
//        num = Double.valueOf((String)numm);
//    }
}
