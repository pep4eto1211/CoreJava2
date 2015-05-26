package com.hackbulgaria.corejava;

public class FaultyProblem2 {

    public int getNearestPowerOf2(int x) {
        int i = 1;
        while (Math.pow(2, i) <= x) {
            i++;
        }

        return (int) Math.pow(2, --i);
    }
}
