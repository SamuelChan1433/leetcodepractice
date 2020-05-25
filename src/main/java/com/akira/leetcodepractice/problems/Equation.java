package com.akira.leetcodepractice.problems;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 题目：LeetCode 640 求解方程
 * 本次解法：拆分方程
 */
public class Equation {
    public static void main(String[] args) {
        String equation = "x+5-3+x=6+x-2";
        String equation2 = "x=x";
        String equation3 = "2x=x";
        String equation4 = "2x+3x-6x=x+2";
        String equation5 = "x=x+2";
        String test = "2x-x+3+2-1+2+3+33+67-x+x=2x-x+3+2-1+2+3+33+67-2x+3x";

        System.out.println(new Equation().solveEquation(equation)); // x=2
        System.out.println(new Equation().solveEquation(equation2)); // Infinite solutions
        System.out.println(new Equation().solveEquation(equation3)); // x=0
        System.out.println(new Equation().solveEquation(equation4)); // x=-1
        System.out.println(new Equation().solveEquation(equation5)); // No solution
        System.out.println(new Equation().solveEquation(test)); // x=0
    }

    private static final String NO_SOLUTION = "No solution";
    private static final String INFINITE = "Infinite solutions";

    public String solveEquation(String equation) {
        String left = equation.split("=")[0];
        String right = equation.split("=")[1];
        if (left.equals(right)) {
            return INFINITE;
        }

        double coefficient = 0;
        double constant = 0;

        for (String str : breakEquation(left)) {
            if (str.indexOf('x') >= 0) {
                coefficient += getCoeff(str);
            } else {
                constant -= getConstant(str);
            }
        }

        for (String str : breakEquation(right)) {
            if (str.indexOf('x') >= 0) {
                coefficient -= getCoeff(str);
            } else {
                constant += getConstant(str);
            }
        }

        if (coefficient == 0) {
            return constant == 0 ? INFINITE : NO_SOLUTION;
        }

        DecimalFormat decimalFormat = new DecimalFormat("#############.##");
        return "x=" + decimalFormat.format(constant == 0 ? 0 : constant/coefficient);
    }

    private double getConstant(String str) {
        return Double.parseDouble(str);
    }

    private double getCoeff(String str) {
        if (str.length() == 1) {
            return Double.parseDouble(str.replace("x", "1"));
        }

        char preX = str.charAt(str.length() - 2);
        if (preX >= '0' && preX <= '9') {
            return Double.parseDouble(str.replace("x", ""));
        }

        return Double.parseDouble(str.replace("x", "1"));
    }

    private List<String> breakEquation(String inputEquation) {
        List<String> broken = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < inputEquation.length(); i++) {
            if (inputEquation.charAt(i) == '+' || inputEquation.charAt(i) == '-') {
                if (stringBuilder.length() > 0) {
                    broken.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            }
            stringBuilder.append(inputEquation.charAt(i));
        }
        broken.add(stringBuilder.toString());
        return broken;
    }

}

