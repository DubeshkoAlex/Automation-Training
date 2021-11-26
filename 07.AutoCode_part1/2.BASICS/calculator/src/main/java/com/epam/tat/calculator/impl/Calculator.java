package com.epam.tat.calculator.impl;

import com.epam.tat.calculator.ICalculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator implements ICalculator {

    private int precision;

    public Calculator(int precision) {
        this.precision = precision;
    }

    @Override
    public double add(double a, double b) {
        double value = a+b;

        if(value!=Double.NEGATIVE_INFINITY && value!=Double.POSITIVE_INFINITY){
            value = BigDecimal.valueOf(value).setScale(precision,RoundingMode.HALF_EVEN).doubleValue();
        }

        return value;
    }

    @Override
    public double subtract(double a, double b) {
        double value = a-b;

        if(value!=Double.NEGATIVE_INFINITY && value!=Double.POSITIVE_INFINITY){
            value = BigDecimal.valueOf(value).setScale(precision,RoundingMode.HALF_EVEN).doubleValue();
        }

        return value;
    }

    @Override
    public double multiply(double a, double b) {
        double value = a*b;

        if(value!=Double.NEGATIVE_INFINITY && value!=Double.POSITIVE_INFINITY){
            value = BigDecimal.valueOf(value).setScale(precision,RoundingMode.HALF_EVEN).doubleValue();
        }

        return value;
    }

    @Override
    public double divide(double a, double b) {
        double value = a/b;

        if(value!=Double.NEGATIVE_INFINITY && value!=Double.POSITIVE_INFINITY){
            value = BigDecimal.valueOf(value).setScale(precision,RoundingMode.HALF_EVEN).doubleValue();
        }

        return value;
    }
}
