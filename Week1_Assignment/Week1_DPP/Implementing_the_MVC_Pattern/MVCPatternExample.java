public class MVCPatternExample {

    // Model class
    public static class Student {
        private String name;
        private String id;
        private String grade;

        // Constructor
        public Student(String name, String id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    // View class
    public static class StudentView {
        public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
            System.out.println("Student Details:");
            System.out.println("Name: " + studentName);
            System.out.println("ID: " + studentId);
            System.out.println("Grade: " + studentGrade);
        }
    }

    // Controller class
    public static class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public String getStudentName() {
            return model.getName();
        }

        public void setStudentId(String id) {
            model.setId(id);
        }

        public String getStudentId() {
            return model.getId();
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public String getStudentGrade() {
            return model.getGrade();
        }

        public void updateView() {
            view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
        }
    }

    // Main method to test the MVC implementation
    public static void main(String[] args) {
        // Create a Student object (Model)
        Student student = new Student("John Doe", "12345", "A");

        // Create a StudentView object (View)
        StudentView view = new StudentView();

        // Create a StudentController object (Controller)
        StudentController controller = new StudentController(student, view);

        // Update the view
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Smith");
        controller.setStudentId("67890");
        controller.setStudentGrade("B");

        // Update the view with new details
        controller.updateView();
    }
}

