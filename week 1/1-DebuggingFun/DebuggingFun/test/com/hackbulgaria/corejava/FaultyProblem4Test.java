package com.hackbulgaria.corejava;

import static org.junit.Assert.*;

import org.junit.Test;

public class FaultyProblem4Test {

    @Test
    public void testFloats() {
        for (int i = 2; i < 97; i++) {
            for (int j = 3; j < i * 17; j++) {
                float a = (float) i / j;
                float b = 1 / ((float) j / i);
                System.out.println(a + ", " + b);
                assertEquals(true, FaultyProblem4.areEqual(a, b));
            }
        }
    }
    
    @Test
    public void testAgainFloats(){
        assertEquals(true, FaultyProblem4.areEqual(0f / 6, 0f / 5));
        assertEquals(true, FaultyProblem4.areEqual(401f / 399f, 1f / (399f / 401f)));
    }

    @Test
    public void testInts() {
        assertEquals(true, FaultyProblem4.areEqual(4, 4));
        assertEquals(true, FaultyProblem4.areEqual(0, 0));
        assertEquals(true, FaultyProblem4.areEqual(500, 500));

        // Защо са верни горните, а този тест фейлва? ^^
        // Защото new Integer създава нова инстанция на обект и също като при String не можем да сравняваме с ==
        // Ако използваме equals() вече наистина ще сравняваме стойностите
        assertEquals(true,FaultyProblem4.areEqual(new Integer(511), (Integer) 511));
    }
    
    @Test
    public void testSubstringEquality() throws Exception {
        String a = "how do you do";
        String b = "how do you do";

        assertEquals(true, FaultyProblem4.haveEqualSubstrings(a, b));

        a = "Bearded Man";
        b = "Non-bearded Man";
        assertEquals(false, FaultyProblem4.haveEqualSubstrings(a, b));

        a = "Speaks";
        b = "Freaky";
        assertEquals(false, FaultyProblem4.haveEqualSubstrings(a, b));
    }

}
