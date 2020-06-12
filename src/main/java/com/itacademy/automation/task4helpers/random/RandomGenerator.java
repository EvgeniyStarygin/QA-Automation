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

    // [a, b)
    private static double generateDoubleValueFromInterval(double min, double max) {
        double value = (random.nextDouble() * (max - min)) + min;
        return DoubleRounder.round(value, 3);
    }

    // (0; 1_000_000)
    public static double generateRandomWealthBetweenZeroAndMillion() {
        double value;
        do {
            value = generateDoubleValueFromInterval(0, 1_000_000);
        } while (value == 0.0);
        return value;
    }

    // (1_000_000; 1_000_001)
    public static double generateRandomWealthMoreThanMillion() {
        double value;
        do {
            value = generateDoubleValueFromInterval(1_000_000, 1_000_001);
        } while (value == 1_000_000.0);
        return value;
    }

    // [-1; 0)
    public static double generateRandomNegativeWealth() {
        return generateDoubleValueFromInterval(-1, 0);
    }

    // (0; 1_000_001)
    public static double generateRandomPositiveWealth() {
        double value;
        do {
            value = generateDoubleValueFromInterval(0, 1_000_001);
        } while (value == 0.0);
        return value;
    }


    public static void main(String[] args) {
        System.out.println(generateRandomPositiveWealth());
    }
}
