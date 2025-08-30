import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Student[] students = new Student[2];
        Faculty[] faculties = new Faculty[2];
        for (int i = 0; i < students.length; i++) {
            String firstName = scan.nextLine();
            String lastName = scan.nextLine();
            int age = scan.nextInt();
            scan.nextLine();
            char gender = scan.nextLine().charAt(0);
            String rollNo = scan.nextLine();
            String course = scan.nextLine();
            int semester = scan.nextInt();
            scan.nextLine();
            double GPA = scan.nextDouble();
            scan.nextLine();

            students[i] = new Student(firstName,lastName,age,gender,rollNo,course,semester,GPA);
        }
        for (int j = 0; j < faculties.length; j++) {
            String firstName = scan.nextLine();
            String lastName = scan.nextLine();
            int age = scan.nextInt();
            scan.nextLine();
            char gender = scan.nextLine().charAt(0);
            String employeeId = scan.nextLine();
            String department = scan.nextLine();
            String designation = scan.nextLine();
            double salary = scan.nextDouble();
            scan.nextLine();

            faculties[j] = new Faculty(firstName,lastName,age,gender,employeeId,department,designation,salary);
        }
        Student ans1 = findHighestGPAStudent(students);
        if(ans1!=null)
        {
            System.out.println(ans1.getRollNo());
            System.out.println(ans1.getCourse());
            System.out.println(ans1.getGPA());
        }
        else
        {
            System.out.println("Sorry - No student is available");
        }

        Faculty ans2 = findHighestPaidFaculty(faculties);
        if(ans2!=null)
        {
            System.out.println(ans2.getEmployeeId());
            System.out.println(ans2.getDepartment());
            System.out.println(ans2.getSalary());
        }
        else
        {
            System.out.println("Sorry - No faculty is available");
        }
    }
    public static Student findHighestGPAStudent(Student[] students){
        Student studentGPA=null;
        double maxGPA=Double.MIN_VALUE;
        for(Student st: students){
            if(st.getGPA()>maxGPA){
                maxGPA=st.getGPA();
                studentGPA=st;
            }
        }
        return studentGPA;
    }
    public static Faculty findHighestPaidFaculty(Faculty[] faculties){
        Faculty facultyHighestSalary=null;
        double maxSalary=Double.MIN_VALUE;
        for(Faculty ft: faculties){
            if(ft.getSalary()>maxSalary){
                maxSalary=ft.getSalary();
                facultyHighestSalary=ft;
            }
        }
        return facultyHighestSalary;
    }

}
class Person{
    private String firstName;
    private String lastName;
    private int age;
    private char gender;


    public Person(String firstName, String lastName, int age, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}

class Student extends Person{
    private String rollNo;
    private String course;
    private int semester;
    private double GPA;

    public Student(String firstName, String lastName, int age, char gender, String rollNo, String course, int semester, double GPA) {
        super(firstName, lastName, age, gender);
        this.rollNo = rollNo;
        this.course = course;
        this.semester = semester;
        this.GPA = GPA;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}

class Faculty extends Person{
    private String employeeId;
    private String department;
    private String designation;
    private double salary;

    public Faculty(String firstName, String lastName, int age, char gender, String employeeId, String department, String designation, double salary) {
        super(firstName, lastName, age, gender);
        this.employeeId = employeeId;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}