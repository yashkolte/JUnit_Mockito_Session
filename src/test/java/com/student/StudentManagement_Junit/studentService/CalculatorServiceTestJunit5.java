package com.student.StudentManagement_Junit.studentService;

import com.student.StudentManagement_Junit.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// This class contains JUnit 5 test cases for the CalculatorService class
public class CalculatorServiceTestJunit5 {

    // @Test annotation marks this method as a test case in JUnit
    // This test checks if the addTwoNumbers method correctly adds two positive numbers
    @Test
    public void addTwoNumbersTest(){
        int res = CalculatorService.addTwoNumbers(20,20);
        int expected = 40;
        // Assertions.assertEquals verifies that the expected and actual results match
        Assertions.assertEquals(expected, res, "Test case passed");
        // Assertions.assertNotNull ensures the result is not null
        Assertions.assertNotNull(res, "Result should not be null");
    }

    // This test verifies the addition operation when one number is zero
    @Test
    public void addTwoNumbersWithZeroTest(){
        int res = CalculatorService.addTwoNumbers(20,0);
        int expected = 20;
        Assertions.assertEquals(expected, res, "Test case passed");
        Assertions.assertNotNull(res, "Result should not be null");
    }

    // This test checks the addition of a negative and a positive number
    @Test
    public void addTwoNumbersWithNegativeTest(){
        int res = CalculatorService.addTwoNumbers(-10,5);
        int expected = -5;
        Assertions.assertEquals(expected, res, "Test case passed");
        Assertions.assertNotNull(res, "Result should not be null");
    }

    // This test validates the sumAnyNumbers method for multiple positive numbers
    @Test
    public void sumAnyNumbersTest(){
        int result = CalculatorService.sumAnyNumbers(2,3,4,5,6,7);
        int expected = 27;
        Assertions.assertEquals(expected, result, "Test case passed");
        Assertions.assertNotNull(result, "Result should not be null");
        Assertions.assertTrue(result > 0, "Sum should be positive");
    }

    // This test checks if sumAnyNumbers correctly handles all zeros as input
    @Test
    public void sumAnyNumbersWithZeroTest(){
        int result = CalculatorService.sumAnyNumbers(0,0,0,0);
        int expected = 0;
        Assertions.assertEquals(expected, result, "Test case passed");
        Assertions.assertNotNull(result, "Result should not be null");
    }

    // This test case ensures that sumAnyNumbers correctly sums multiple negative numbers
    @Test
    public void sumAnyNumbersWithNegativeTest(){
        int result = CalculatorService.sumAnyNumbers(-1,-2,-3,-4);
        int expected = -10;
        Assertions.assertEquals(expected, result, "Test case passed");
        Assertions.assertNotNull(result, "Result should not be null");
        Assertions.assertTrue(result < 0, "Sum should be negative");
    }

    // This test case verifies the summation of mixed positive and negative numbers
    @Test
    public void sumAnyNumbersWithMixedTest(){
        int result = CalculatorService.sumAnyNumbers(-1,2,-3,4,-5,6);
        int expected = 3;
        Assertions.assertEquals(expected, result, "Test case passed");
        Assertions.assertNotNull(result, "Result should not be null");
    }
}
