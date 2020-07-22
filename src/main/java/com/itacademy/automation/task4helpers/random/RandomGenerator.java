package com.itacademy.automation.task4helpers.random;

import org.decimal4j.util.DoubleRounder;

import java.time.Month;
import java.util.Random;

public abstract class RandomGenerator {

    private static Random random = new Random();

    public static Month generateRandomMonth() {
        Month[] months = Month.values();
        int index = random.nextInt(months.length);
        return months[index];
    }

    public static Month generateRandomSummerMonth() {
        Month[] summerMonths = {Month.JUNE, Month.JULY, Month.AUGUST};
        int index = random.nextInt(summerMonths.length);
        return summerMonths[index];
    }

    public static Month generateRandomNotSummerMonth() {
        Month[] notSummerMonths = {Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER, Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.APRIL, Month.MAY};
        int index = random.nextInt(notSummerMonths.length);
        return notSummerMonths[index];
    }

    public static boolean generateRandomBooleanValue() {
        boolean[] values = {true, false};
        int index = random.nextInt(values.length);
        return values[index];
    }

    private static double generateDoubleValueFromInterval(double min, double max) {
        double value = (random.nextDouble() * (max - min)) + min;
        return DoubleRounder.round(value, 3);
    }

    public static double generateRandomWealthBetweenZeroAndMillion() {
        double minValue = 0.0;
        double maxValue = 1_000_000.0;
        double generatedValue;
        do {
            generatedValue = generateDoubleValueFromInterval(minValue, maxValue);
        } while (generatedValue == minValue);
        return generatedValue;
    }

    public static double generateRandomWealthMoreThanMillion() {
        double minValue = 1_000_000.0;
        double maxValue = 1_000_001.0;
        double generatedValue;
        do {
            generatedValue = generateDoubleValueFromInterval(minValue, maxValue);
        } while (generatedValue == minValue);
        return generatedValue;
    }

    public static double generateRandomNegativeWealth() {
        double minValue = -1.0;
        double maxValue = 0.0;
        return generateDoubleValueFromInterval(minValue, maxValue);
    }

    public static double generateRandomPositiveWealth() {
        double minValue = 0.0;
        double maxValue = 1_000_001.0;
        double generatedValue;
        do {
            generatedValue = generateDoubleValueFromInterval(minValue, maxValue);
        } while (generatedValue == 0.0);
        return generatedValue;
    }
}
