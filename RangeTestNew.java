package org.jfree.data;

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
        //assertNull("The central value should not exist.", exampleRange.getCentralValue());
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
        //assertNull("The lower bound should not exist.", exampleRange.getCentralValue());

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
        //assertNull("The lower bound should not exist.", exampleRange.getCentralValue());
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
        //assertNull("The length should not exist.", exampleRange.getCentralValue());
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
        //assertNull("The this range should not contain anything.", exampleRange.getCentralValue());
    }
    
    ///////////////////////////////////////////////
    
    @Test
    public void createLargerLowerCoverageTest() {
    	exampleRange = new Range(4, 3);

    	//assertEquals("Upper bound should equal -2.0.", -2.0, exampleRange.getUpperBound(), .000000001d);
    }
    
    
    @Test
    public void intersectsCoverageTest() {
    	exampleRange = new Range(3, 6);
    	exampleRange.intersects(3,7);
   }
    
    @Test
    public void intersectsCoverageTest2() {
    	exampleRange = new Range(3, 6);
    	exampleRange.intersects(3,3);
    }
    
//    @Test
//    public void intersectsCoverageTest3() {
//    	exampleRange = new Range(3, 6);
//    	exampleRange.intersects(9,6);
//
//    	//assertEquals("Upper bound should equal -2.0.", -2.0, exampleRange.getUpperBound(), .000000001d);
//    }
    
    @Test
    public void intersectsCoverageTest4() {
    	exampleRange = new Range(3, 6);
    	exampleRange.intersects(5,6);
    }
  
    
    @Test
    public void intersectsOneParameterCoverageTest() {
    	exampleRange = new Range(3, 6);
    	Range testRange = new Range(1,5);
    	exampleRange.intersects(testRange);
    	    }
    
    
    @Test
    public void constrainCoverageTest() {
    	exampleRange = new Range(3, 6);
    	exampleRange.constrain(4);
    	    }
    
    @Test
    public void constrainCoverageTest2() {
    	exampleRange = new Range(4, 6);
    	exampleRange.constrain(1);
    	    }
    
   
    
    @Test
    public void constrainCoverageTest4() {
    	exampleRange = new Range(3, 3);
    	exampleRange.constrain(4);
    	    }
    
    
    @Test
    public void combineCoverageTest() {
    	exampleRange = new Range(6, 7);
    	Range.combine(null, exampleRange);
    	    }
    
    @Test
    public void combineCoverageTest2() {
    	exampleRange = new Range(6, 7);
    	Range.combine(exampleRange, null);
    	    }
    
    @Test
    public void combineCoverageTest3() {
    	exampleRange = new Range(6, 7);
    	Range testRange = new Range (3,6);
    	Range.combine(exampleRange, testRange);
    }
    
    
    
    
    @Test
    public void combineIgnoringNaNCoverageTest() {
    	exampleRange = new Range(1, 8);
    	Range.combineIgnoringNaN(null, exampleRange);
    }
    
    @Test
    public void combineIgnoringNaNCoverageTest2() {
    	exampleRange = new Range(1, 8);
    	Range.combineIgnoringNaN(exampleRange, null);
    }
    
    @Test
    public void combineIgnoringNaNCoverageTest3() {
    	exampleRange = new Range(1, 8);
    	Range.combineIgnoringNaN(exampleRange, null);
    }
    
    @Test
    public void combineIgnoringNaNCoverageTest4() {
    	exampleRange = new Range (3, 4);
    	Range exampleRange2 = new Range(1, 8);
    	Range.combineIgnoringNaN(exampleRange2, exampleRange);
    }
    
//    @Test
//    public void minCoverageTest() {
//    	exampleRange = new Range (2,7);
//    	Range.;
//    }
    
    
    
    @Test
    public void expandToIncludeCoverageTest() {
    	exampleRange = new Range (3, 4);
    	Range.expandToInclude(exampleRange, 5);
    }
    
    @Test
    public void expandToIncludeCoverageTest2() {
    	exampleRange = new Range (3, 5);
    	Range.expandToInclude(exampleRange, 4);
    }
    
    @Test
    public void expandToIncludeCoverageTest3() {
    	exampleRange = new Range (3, 5);
    	Range.expandToInclude(exampleRange, 2);
    }
    
    @Test
    public void expandToIncludeCoverageTest4() {
    	exampleRange = null;
    	Range.expandToInclude(exampleRange, 2);
    }
    
    
    
    @Test
    public void expandCoverageTest() {
    	exampleRange = new Range (3, 5);
    	Range.expand(exampleRange, 2, 7);
    }
    
    @Test
    public void expandCoverageTest2() {
    	exampleRange = new Range (3, 5);
    	Range.expand(exampleRange, 1, -4);
    }
    
    @Test
    public void shiftCoverageTest() {
        Range range = new Range (3, 15);
        Range range1 = new Range(8.0,20.0);
        assertEquals(range1, Range.shift(range, 5));
    }
    
    @Test
    public void shiftThreeParamsCoverageTest() {
    	exampleRange = new Range (3, 5);
    	Range.shift(exampleRange, 5, true);
    }
    
    
//    @Test
//    public void shiftWithNoZeroCrossingCoverageTest() {
//    	exampleRange = new Range (3, 5);
//    	Range.shiftWithNoZeroCrossing(2,6);
//    }
    
    @Test
    public void scaleCoverageTest() {
    	exampleRange = new Range (3, 5);
    	Range.scale(exampleRange, 5);
    }
    
    @Test
    public void scaleCoverageTest2() {
    	exampleRange = new Range (3, 5);
    	Range.scale(exampleRange, -7);
    }
    
    
    @Test
    public void equalsTest() {
    	exampleRange = new Range (3, 5);
    	Range testRange = new Range (3,5);
    	exampleRange.equals(testRange);
    }
    
    
    @Test
    public void equalsTest2() {
    	exampleRange = new Range (3, 5);
    	Range testRange = new Range (3,6);
    	exampleRange.equals(testRange);
    }
    
    @Test
    public void equalsTest3() {
    	exampleRange = new Range (3, 5);
    	exampleRange.equals(6);
    }
    
    @Test
    public void equalsTest4() {
    	exampleRange = new Range (3, 5);
    	Range testRange = new Range (4,5);
    	exampleRange.equals(testRange);
    }
    
   @Test
    public void isNaNRangeCoverageTest() {
        exampleRange = new Range (3, 5);
        assertEquals(exampleRange.isNaNRange(), false);
    }
    
    
    @Test
    public void hashCodeCoverageTest() {
        exampleRange = new Range (3, 5);
        assertEquals(-2.130968576E9, exampleRange.hashCode(), 0.01);
    }
    
     @Test
    public void toStringCoverageTest() {
        exampleRange = new Range (1, 5);
        assertEquals(examplesRange.toString(), "Range[1.0,5.0]");
    }
    
}

