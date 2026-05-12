package sit707;

public class Task {

    private String studentId;
    private String taskName;

    public Task(String studentId, String taskName) {
        this.studentId = studentId;
        this.taskName = taskName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getTaskName() {
        return taskName;
    }
}