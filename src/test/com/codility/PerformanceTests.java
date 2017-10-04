package com.codility;

import com.codility.utils.ArrayGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertTrue;

public class PerformanceTests {
    private TapeEquilibrium tapeEquilibrium;
    private ArrayGenerator arrayGenerator;

    private String generateErrorMessage(double runningTime, double timeLimit){
        return String.format("Running time = %f	sec, Time limit: %f sec", runningTime / 1000.0, timeLimit / 1000.0);
    }

    @Before
    public void init(){
        tapeEquilibrium = new TapeEquilibrium();
        arrayGenerator = new ArrayGenerator();
    }

    @Test
    public void MediumRandom() {
        Date startTime = new Date();
        tapeEquilibrium.getMinimalDifference(arrayGenerator.generateArray(10000, 0, 100));
        Date endTime = new Date();
        long runningTimeMs = endTime.getTime() - startTime.getTime();
        long timeLimitMs = 100;
        assertTrue(generateErrorMessage(runningTimeMs, timeLimitMs),runningTimeMs < timeLimitMs);
    }

    @Test
    public void MediumRandom2() {
        Date startTime = new Date();
        tapeEquilibrium.getMinimalDifference(arrayGenerator.generateArray(10000, -1000, 50));
        Date endTime = new Date();
        long runningTimeMs = endTime.getTime() - startTime.getTime();
        long timeLimitMs = 100;
        assertTrue(generateErrorMessage(runningTimeMs, timeLimitMs),runningTimeMs < timeLimitMs);
    }

    @Test
    public void LargeOnes() {
        Date startTime = new Date();
        tapeEquilibrium.getMinimalDifference(arrayGenerator.generateArray(100000, -1, 1));
        Date endTime = new Date();
        long runningTimeMs = endTime.getTime() - startTime.getTime();
        long timeLimitMs = 100;
        assertTrue(generateErrorMessage(runningTimeMs, timeLimitMs),runningTimeMs < timeLimitMs);
    }

    @Test
    public void LargeRandom() {
        Date startTime = new Date();
        tapeEquilibrium.getMinimalDifference(arrayGenerator.generateArray(100000, Integer.MIN_VALUE, Integer.MAX_VALUE));
        Date endTime = new Date();
        long runningTimeMs = endTime.getTime() - startTime.getTime();
        long timeLimitMs = 300;
        assertTrue(generateErrorMessage(runningTimeMs, timeLimitMs),runningTimeMs < timeLimitMs);
    }

    @Test
    public void LargeSequence() {
        int[] maximalNumbers = (arrayGenerator.generateArray(100000, Integer.MAX_VALUE - 2, Integer.MAX_VALUE));
        Date maximalNumbersStartTime = new Date();
        tapeEquilibrium.getMinimalDifference(maximalNumbers);
        Date maximalNumbersEndTime = new Date();
        long maximalNumbersRunningTimeMs = maximalNumbersEndTime.getTime() - maximalNumbersStartTime.getTime();

        int[] minimumNumbers = (arrayGenerator.generateArray(100000, Integer.MIN_VALUE, Integer.MIN_VALUE + 2));
        Date minimumNumbersStartTime = new Date();
        tapeEquilibrium.getMinimalDifference(minimumNumbers);
        Date minimumNumbersEndTime = new Date();
        long minimumNumbersRunningTimeMs = minimumNumbersEndTime.getTime() - minimumNumbersStartTime.getTime();

        long timeLimitMs = 100;
        assertTrue(generateErrorMessage(maximalNumbersRunningTimeMs, timeLimitMs),maximalNumbersRunningTimeMs < timeLimitMs);
        assertTrue(generateErrorMessage(minimumNumbersRunningTimeMs, timeLimitMs),minimumNumbersRunningTimeMs < timeLimitMs);
    }
}
