package sit707_week2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    public MainTest() {
        System.out.println("MainTest");
    }

    @Before
    public void setup() {
        System.out.println("Before...");
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "225280351";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Srikar Boske";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testAssertTrue() {
        Assert.assertTrue(true);
    }

    @Test
    public void testAssertFalse() {
        Assert.assertFalse(false);
    }
}