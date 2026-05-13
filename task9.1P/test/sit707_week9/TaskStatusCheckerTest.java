package sit707_week9;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TaskStatusCheckerTest {

    @Test
    public void testGetTasksByStudentId() {

        TaskStatusChecker checker = new TaskStatusChecker();

        List<Task> tasks = checker.getTasksByStudentId("S123");

        assertEquals(5, tasks.size());
    }

    @Test
    public void testNoTasksForUnknownStudent() {

        TaskStatusChecker checker = new TaskStatusChecker();

        List<Task> tasks = checker.getTasksByStudentId("S999");

        assertEquals(0, tasks.size());
    }

    @Test
    public void testGetTaskStatus() {

        TaskStatusChecker checker = new TaskStatusChecker();

        String status = checker.getTaskStatus("S123", "SIT707 9.1P");

        assertEquals("Submitted", status);
    }

    @Test
    public void testTaskStatusNotFound() {

        TaskStatusChecker checker = new TaskStatusChecker();

        String status = checker.getTaskStatus("S999", "Unknown Task");

        assertEquals("Not Found", status);
    }
}
