package com.akira.leetcodepractice.tmp;

import java.util.ArrayList;
import java.util.List;

public class Equation {
    public static void main(String[] args) {
        String equation = "a+5-3+a=6+a-2";
        String equation2 = "b=b";
        String equation3 = "2c=c";
        String equation4 = "2x+3x-6x=x+2";
        String equation5 = "d=d+2";
        String test = "2x-x+3+2-1+2+3+33+67-x+x=2x-x+3+2-1+2+3+33+67-2x+3x";
        String test2 = "14x+x-10x=4x+2";

        System.out.println(new Equation().solveEquation(equation)); // x=2
        System.out.println(new Equation().solveEquation(equation2)); // Infinite solutions
        System.out.println(new Equation().solveEquation(equation3)); // x=0
        System.out.println(new Equation().solveEquation(equation4)); // x=-1
        System.out.println(new Equation().solveEquation(equation5)); // No solution
        System.out.println(new Equation().solveEquation(test)); // x=0
        System.out.println(new Equation().solveEquation(test2)); // x=2
    }

    private static final String NO_SOLUTION = "No solution";
    private static final String INFINITE = "Infinite solutions";

    public String solveEquation(String equation) {
        String[] eq = equation.split("=");
        String eqLeft = eq[0];
        String eqRight = eq[1];

        List<String> left = new ArrayList<>();
        List<String> right = new ArrayList<>();

        // 拆解左多项式，常数项为负，多项式为正
        int idx = 0;
        for (int i = 0; i < eqLeft.length(); i++) {
            if (eqLeft.charAt(i) == '+' || eqLeft.charAt(i) == '-') {
                left.add(eqLeft.substring(idx, i));
                idx = i;
            }
        }
        left.add(eqLeft.substring(idx));

        idx = 0;
        for (int i = 0; i < eqRight.length(); i++) {
            if (eqRight.charAt(i) == '+' || eqRight.charAt(i) == '-') {
                right.add(eqRight.substring(idx, i));
                idx = i;
            }
        }
        right.add(eqRight.substring(idx));

//        left.forEach(System.out::println);
//        right.forEach(System.out::println);

        double changshu = 0;
        double weizhishu = 0;
        String x = null;

        // left
        for (int i = 0; i < left.size(); i++) {
            String item = left.get(i);
            if (item.charAt(item.length()-1) < '0' ||
                    item.charAt(item.length()-1) > '9') {
                x = "" + item.charAt(item.length()-1);
                if (item.length() == 1 || item.charAt(item.length()-2) >'9' || item.charAt(item.length()-2) <'0') {
                    item = item.replace(x, 1+"x");
                }

                weizhishu +=  Double.parseDouble(item.substring(0, item.length() -1));
            } else {
                changshu -= Double.parseDouble(item);
            }
        }

        // right
        for (int i = 0; i < right.size(); i++) {
            String item = right.get(i);
            if (item.charAt(item.length()-1) < '0' ||
                    item.charAt(item.length()-1) > '9') {
                x = "" + item.charAt(item.length()-1);
                if (item.length() == 1 || item.charAt(item.length()-2) >'9' || item.charAt(item.length()-2) <'0') {
                    item = item.replace(x, 1+"x");
                }

                weizhishu -=  Double.parseDouble(item.substring(0, item.length() -1));
            } else {
                changshu += Double.parseDouble(item);
            }
        }

        if (weizhishu == 0) {
            if (changshu == 0) {
                return INFINITE;
            } else {
                return NO_SOLUTION;
            }
        }

//        System.out.println("changshu=" + weizhishu);
//        System.out.println("weizhishu=" + changshu);
        return x + "=" + changshu/weizhishu;
    }
}
