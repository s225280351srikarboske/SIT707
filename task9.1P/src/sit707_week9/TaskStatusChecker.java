package sit707_week9;

import java.util.ArrayList;
import java.util.List;

public class TaskStatusChecker {

    private List<Task> tasks = new ArrayList<>();

    public TaskStatusChecker() {
        tasks.add(new Task("S123", "SIT707 9.1P", "Submitted"));
        tasks.add(new Task("S123", "SIT707 8.1P", "Complete"));
        tasks.add(new Task("S456", "SIT707 7.1P", "Resubmit"));
    }

    public List<Task> getTasksByStudentId(String studentId) {

        List<Task> result = new ArrayList<>();

        for (Task task : tasks) {
            if (task.getStudentId().equals(studentId)) {
                result.add(task);
            }
        }

        return result;
    }

    public String getTaskStatus(String studentId, String taskName) {

        for (Task task : tasks) {
            if (task.getStudentId().equals(studentId) && task.getTaskName().equals(taskName)) {
                return task.getStatus();
            }
        }

        return "Not Found";
    }
}
