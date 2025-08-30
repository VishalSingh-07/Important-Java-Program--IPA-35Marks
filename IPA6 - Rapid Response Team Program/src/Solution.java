import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        RRT[] rrts=new RRT[n];
        for(int i=0;i<n;i++){
            int ticketNo=scan.nextInt();
            scan.nextLine();
            String raisedBy=scan.nextLine();
            String assignedTo=scan.nextLine();
            int priority=scan.nextInt();
            scan.nextLine();
            String project=scan.nextLine();

            rrts[i]=new RRT(ticketNo,raisedBy,assignedTo,priority,project);
        }
        String givenProject=scan.nextLine();
        RRT highestPriorityTicket=getHighestPriorityTicket(rrts,givenProject);
        if(highestPriorityTicket!=null){
            System.out.println(highestPriorityTicket.getTicketNo());
            System.out.println(highestPriorityTicket.getRaisedBy());
            System.out.println(highestPriorityTicket.getAssignedTo());
        }
        else{
            System.out.println("No such Ticket");
        }

    }
    public static RRT getHighestPriorityTicket(RRT[] rrts, String givenProject){
        ArrayList<RRT> highestPriorityTicket=new ArrayList<>();
        for(RRT rt: rrts){
            if(rt.getProject().equalsIgnoreCase(givenProject)){
                highestPriorityTicket.add(rt);
            }
        }
        if(highestPriorityTicket.isEmpty()){
            return null;
        }
        highestPriorityTicket.sort(Comparator.comparing(RRT::getPriority));
        return highestPriorityTicket.get(0);
    }
}


class RRT{
    private int ticketNo;
    private String raisedBy;
    private String assignedTo;
    private int priority;
    private String project;


    public RRT(int ticketNo, String raisedBy, String assignedTo, int priority, String project) {
        this.ticketNo = ticketNo;
        this.raisedBy = raisedBy;
        this.assignedTo = assignedTo;
        this.priority = priority;
        this.project = project;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getRaisedBy() {
        return raisedBy;
    }

    public void setRaisedBy(String raisedBy) {
        this.raisedBy = raisedBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}