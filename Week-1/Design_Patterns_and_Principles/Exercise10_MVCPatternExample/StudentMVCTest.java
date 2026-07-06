public class StudentMVCTest {
    public static void main(String[] args) {
        Student student = new Student("Aditya Sharma", "S1023", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentGrade("A+");
        controller.updateView();
    }
}
