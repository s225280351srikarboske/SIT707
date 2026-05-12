package sit707_week9;

public class Task {

    private String studentId;
    private String taskName;
    private String status;

    public Task(String studentId, String taskName, String status) {
        this.studentId = studentId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }
}
