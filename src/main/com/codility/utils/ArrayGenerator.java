package com.codility.utils;

import java.util.Random;

public class ArrayGenerator {
    private Random random = new Random();
    public int[] generateArray(int arraySize, int lowerRange, int upperRange){
        int[] result = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            result[i] = lowerRange + (int) (random.nextDouble() * (upperRange - lowerRange));
        }
        return result;
    }

}
