class Student {
    String name;
    int rollNo;
    double[] marks;

    // creating a constructor

    Student(String name, int rollNo, double[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    // the average marks of a atudent

    public double averageMarks() {
        double totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }
        return totalMarks / marks.length;
    }

    // display the student details

    public void studentDetails() {
        System.out.println("the name of the student: " + name);
        System.out.println("the roll no  of the student: " + rollNo);
        System.out.println("the marks of the student: " + marks);
        for (double mark : marks) {
            System.out.println(mark + "");

        }
        System.out.println("the average marks:" + averageMarks());
        System.out.println("status:" + (isPassed() ? "passed " : "faild"));
    }

    // this method identify the student weather a student is passed or faild

    public boolean isPassed() {
        return averageMarks() >= 50;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        // System.out.println("muhammad awais ");
        Student[] students = {
                new Student("muhammad awais ", 78, new double[] { 23, 43, 54 }),
                new Student("Ali hyder", 34, new double[] { 66, 87, 90 }),
                new Student("muhammad yaseen", 45, new double[] { 67, 43, 98 }),
                new Student("haseeb ali", 32, new double[] { 64, 98, 56 }),
                new Student("Asad ahmed", 21, new double[] { 45, 67, 98 })
        };

        // calculate class average

        double classAverage = calculateClassAverage(students);
        System.out.println("the class average is : " + classAverage);

        // we are now display students details

        for (Student student : students) {
            System.out.println("student details...");
            student.studentDetails();

        }

    }

    // the method to calculate the class average students
    public static double calculateClassAverage(Student[] students) {
        double total = 0;
        for (Student student : students) {
            total += student.averageMarks();
        }
        return total / students.length;
    }

}
