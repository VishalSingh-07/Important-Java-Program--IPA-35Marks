import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        Student[] students=new Student[n];
        for(int i=0;i<n;i++){
            int rollNo=scan.nextInt();
            scan.nextLine();
            String name=scan.nextLine();
            String branch=scan.nextLine();
            double score=scan.nextDouble();
            scan.nextLine();
            boolean dayScholar=scan.nextBoolean();
            students[i]=new Student(rollNo,name,branch,score,dayScholar);
        }
        int countDayScholar=findCountOfDayscholarStudents(students);
        if(countDayScholar>0){
            System.out.println(countDayScholar);
        }
        else{
            System.out.println("There are no such dayscholar students");
        }
        Student studentSecondHighestScore=findStudentwithSecondHighestScore(students);
        if(studentSecondHighestScore!=null){
            System.out.println(studentSecondHighestScore.getRollNo()+"#"+studentSecondHighestScore.getName()+"#"+studentSecondHighestScore.getScore());
        }
        else{
            System.out.println("There are no student from non day scholar");
        }
        scan.close();
    }
    public static int findCountOfDayscholarStudents(Student[] students){
        int count=0;
        for(Student st: students){
            if(st.isDayScholar() && st.getScore()>80){
                count++;
            }
        }
        return Math.max(count,0);
    }
    public static Student findStudentwithSecondHighestScore(Student[] students){
        ArrayList<Student> studentSecondHighestScore=new ArrayList<>();
        for(Student st: students){
            if(!st.isDayScholar()){
                studentSecondHighestScore.add(st);
            }
        }
        studentSecondHighestScore.sort(Comparator.comparing(Student::getScore).reversed());
        if(studentSecondHighestScore.size()<2){
            return null;
        }
        return studentSecondHighestScore.get(1);
    }
}
class Student{
    private int rollNo;
    private String name;
    private String branch;
    private double score;
    private boolean dayScholar;

    public Student(int rollNo, String name, String branch, double score, boolean dayScholar) {
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.score = score;
        this.dayScholar = dayScholar;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isDayScholar() {
        return dayScholar;
    }

    public void setDayScholar(boolean dayScholar) {
        this.dayScholar = dayScholar;
    }
}