package com.codility;

import java.util.Arrays;

class TapeEquilibrium {
    int getMinimalDifference(int[] A) {
        long leftSumm = A[0];
        long rightSumm = Arrays.stream(A).sum() - leftSumm;
        long minDiff = Math.abs(rightSumm - leftSumm);

        for (int P = 1; P < A.length; P++) {
            leftSumm += A[P];
            rightSumm -= A[P];
            long diff = Math.abs(rightSumm - leftSumm);
            minDiff = minDiff < diff ? minDiff : diff;
        }
        return (int) minDiff;
    }
}
