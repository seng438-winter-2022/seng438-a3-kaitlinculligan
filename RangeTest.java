package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    }


    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void centralValueShouldBeZero2() {
    	exampleRange = new Range(-2, 2);
        assertEquals("The central value of -2 and 2 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void centralValueShouldBeFour() {
    	exampleRange = new Range(2, 6);
        assertEquals("The central value of 2 and 6 should be 4",
        4, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void centralValueShouldBeOne() {
    	exampleRange = new Range(1, 1);
        assertEquals("The central value of 1 and 1 should be 1",
        1, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test(expected = NullPointerException.class)
    public void centralValueWithNulls() {
    	exampleRange = null;
        assertNull("The central value should not exist.", exampleRange.getCentralValue());
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    @Test
    public void getLowerBoundTest() {
    	exampleRange = new Range(1.5, 7.6);
    	
    	assertEquals("Lower bound should equal 1.5.", 1.5, exampleRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundTestWithEqualBoundaries() {
    	exampleRange = new Range(2.0, 2.0);
    	
    	assertEquals("Lower bound should equal 2.0.", 2.0, exampleRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundTestWithNegativeLowerBoundary() {
    	exampleRange = new Range(-2.015, 2.0);
    	
    	assertEquals("Lower bound should equal -2.015.", -2.015, exampleRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundTestWithNegativeBoundaries() {
    	exampleRange = new Range(-2.015, -2.0);
    	
    	assertEquals("Lower bound should equal -2.015.", -2.015, exampleRange.getLowerBound(), .000000001d);
    }
    
    @Test(expected = NullPointerException.class)
    public void getLowerBoundWithNull() {
    	exampleRange = null;
        assertNull("The lower bound should not exist.", exampleRange.getCentralValue());

    }
    
    
    @Test
    public void getUpperBoundTest() {
    	exampleRange = new Range(1.5, 7.6);
    	
    	assertEquals("Upper bound should equal 7.6.", 7.6, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundTestWithEqualBoundaries() {
    	exampleRange = new Range(2.0, 2.0);
    	
    	assertEquals("Upper bound should equal 2.0.", 2.0, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundTestWithNegativeUpperBoundary() {
    	exampleRange = new Range(-2.015, 2.0);
    	
    	assertEquals("Upper bound should equal 2.0.", 2.0, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundTestWithNegativeBoundaries() {
    	exampleRange = new Range(-2.015, -2.0);
    	
    	assertEquals("Upper bound should equal -2.0.", -2.0, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test(expected = NullPointerException.class)
    public void getUpperBoundWithNull() {
    	exampleRange = null;
        assertNull("The lower bound should not exist.", exampleRange.getCentralValue());
    }
    
    @Test
    public void getLengthShouldBeSeventyTwo() {
    	exampleRange = new Range(24, 96);
    	assertEquals("Length should equal 72.", 72, exampleRange.getLength(), .000000001d);
    }
    
    @Test
    public void getLengthShouldBeZero() {
    	exampleRange = new Range(0, 0);
    	assertEquals("Length should equal 0.", 0, exampleRange.getLength(), .000000001d);
    }
    
    @Test
    public void getLengthNegativeLowerBoundary() {
    	exampleRange = new Range(-24.5, 96);
    	assertEquals("Length should equal 120.5.", 120.5, exampleRange.getLength(), .000000001d);
    }
    
    @Test
    public void getLengthNegativeBoundaries() {
    	exampleRange = new Range(-96, -10);
    	assertEquals("Length should equal 86.", 86, exampleRange.getLength(), .000000001d);
    }
    
    @Test(expected = NullPointerException.class)
    public void getLengthWithNull() {
    	exampleRange = null;
        assertNull("The length should not exist.", exampleRange.getCentralValue());
    }
    
    @Test
    public void containsTestLowerBoundary() {
    	exampleRange = new Range(-96, -10);
    	assertTrue("Contains should return true.", exampleRange.contains(-96));
    }
    
    @Test
    public void containsTestUpperBoundary() {
    	exampleRange = new Range(-96, -10);
    	assertTrue("Contains should return true.", exampleRange.contains(-10));
    }
    
    @Test
    public void containsTestAboveUpperBoundary() {
    	exampleRange = new Range(-96, -10);
    	assertFalse("Contains should return false.", exampleRange.contains(-9));
    }
    
    @Test
    public void containsTestBelowLowerBoundary() {
    	exampleRange = new Range(-96, -10);
    	assertFalse("Contains should return false.", exampleRange.contains(-97));
    }
    
    @Test
    public void containsTestMiddleValue() {
    	exampleRange = new Range(-50, 23);
    	assertTrue("Contains should return true.", exampleRange.contains(10));
    }
    
    @Test
    public void containsTestWithDouble() {
    	exampleRange = new Range(-50.25, 23);
    	assertTrue("Contains should return true.", exampleRange.contains(-50.23));
    }
    
    @Test
    public void containsTestBelowLowerBoundaryWithDoubles() {
    	exampleRange = new Range(-50.25, 23);
    	assertFalse("Contains should return false.", exampleRange.contains(-50.26));
    }
    
    @Test(expected = NullPointerException.class)
    public void containsTestWithNull() {
    	exampleRange = null;
        assertNull("The this range should not contain anything.", exampleRange.getCentralValue());
    }
}