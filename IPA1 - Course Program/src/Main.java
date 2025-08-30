import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        Course[] courses=new Course[n];
        for(int i=0;i<n;i++){
            int courseId=scan.nextInt();
            scan.nextLine();
            String courseName=scan.nextLine();
            String courseAdmin=scan.nextLine();
            int quiz=scan.nextInt();
            int handsOn=scan.nextInt();

            courses[i]=new Course(courseId,courseName,courseAdmin,quiz,handsOn);
        }
        scan.nextLine();
        String admin=scan.nextLine();
        int hand=scan.nextInt();
        int AverageValue=findAvgOfQuizByAdmin(courses,admin);
        if(AverageValue!=0){
            System.out.println(AverageValue);
        }
        else{
            System.out.println("No Course found.");
        }
        Course[]  sortCourse=sortCourseByHandsOn(courses,hand);
        if(sortCourse!=null){
            for(Course cs: sortCourse){
                System.out.println(cs.getCourseName());
            }
        }
        else{
            System.out.println("No Course found with mentioned attribute.");
        }

    }
    public static int findAvgOfQuizByAdmin(Course[] courses, String courseAdmin){
        int sum=0,count=0;
        for(Course cs: courses){
            if(cs.getCourseAdmin().equalsIgnoreCase(courseAdmin)){
                sum+=cs.getQuiz();
                count++;
            }
        }
        if(count>0){
            return sum/count;
        }
        return 0;
    }
    /*
    public static Course[] sortCourseByHandsOn(Course[] courses, int handsOn){
        ArrayList<Course> sortedCourseByHandsOn=new ArrayList<>();
        for(Course cs: courses){
            if(cs.getHandsOn()<handsOn){
                sortedCourseByHandsOn.add(cs);
            }
        }
        if(sortedCourseByHandsOn.isEmpty()){
            return null;
        }
        Collections.sort(sortedCourseByHandsOn, Comparator.comparingInt(Course::getHandsOn));
        return sortedCourseByHandsOn.toArray(new Course[0]);
    }
    */


    // OR


    public static Course[] sortCourseByHandsOn(Course[] courses, int handsOn){
        Course[] sortedCourse=new Course[0];
        for(Course cs: courses){
            if(cs.getHandsOn()<handsOn){
                /*
                If the condition is met (i.e., the hands-on value is less than h), the array sortedCourse is resized to hold one additional element.
                This is done using Arrays.copyOf(), which creates a new array that is one element larger than the original.
                The current Course object (i.e., course[i]) is then added to the last position of the resized array (sortedCourse[sortedCourse.length - 1]).
                */
                sortedCourse=Arrays.copyOf(sortedCourse,sortedCourse.length+1);
                sortedCourse[sortedCourse.length-1]=cs;

            }
        }
        Course temp;
        for(int i=0;i<sortedCourse.length;i++){
            for(int j=i+1;j<sortedCourse.length;j++){
                if(sortedCourse[i].getHandsOn()>sortedCourse[j].getHandsOn()){
                    temp=sortedCourse[i];
                    sortedCourse[i]=sortedCourse[j];
                    sortedCourse[j]=temp;
                }
            }
        }
        return sortedCourse.length>0?sortedCourse:null;

    }

}

class Course{
    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handsOn;


    public Course(int courseId, String courseName, String courseAdmin, int quiz, int handson) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseAdmin = courseAdmin;
        this.quiz = quiz;
        this.handsOn = handson;
    }

    public int getCourseId(){
        return courseId;
    }
    public void setCourseId(int courseId){
        this.courseId=courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseAdmin() {
        return courseAdmin;
    }

    public void setCourseAdmin(String courseAdmin) {
        this.courseAdmin = courseAdmin;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    public int getHandsOn() {
        return handsOn;
    }

    public void setHandsOn(int handsOn) {
        this.handsOn = handsOn;
    }
}