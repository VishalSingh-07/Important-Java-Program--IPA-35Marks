import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Sim [] sims=new Sim[5];
        for(int i=0;i<5;i++){
            int simId=scan.nextInt();
            scan.nextLine();
            String customerName=scan.nextLine();
            Double balance=scan.nextDouble();
            Double ratePerSecond=scan.nextDouble();
            scan.nextLine();
            String circle=scan.nextLine();

            sims[i]=new Sim(simId,customerName,balance,ratePerSecond,circle);
        }
        String circle1=scan.nextLine();
        String circle2=scan.nextLine();

        Sim[] transferCircle=transferCustomerCircle(sims,circle1,circle2);

        if(transferCircle!=null){
            for(int i=0;i<transferCircle.length;i++){
                System.out.println(transferCircle[i].getSimId()+" "+transferCircle[i].getCustomerName()+" "+transferCircle[i].getRatePerSecond());
            }
        }
        scan.nextLine();
    }
    public static Sim[] transferCustomerCircle(Sim[] sims, String circle1, String circle2){
        ArrayList<Sim> transferCircle=new ArrayList<>();
        for(Sim sm: sims){
            if(sm.getCircle().equalsIgnoreCase(circle1)){
                sm.setCircle(circle2);
                transferCircle.add(sm);
            }
        }
        if(transferCircle.isEmpty()){
            return null;
        }
        transferCircle.sort(Comparator.comparing(Sim::getRatePerSecond).reversed());

        return transferCircle.toArray(new Sim[0]);
    }
}

class Sim{
    private int simId;
    private String customerName;
    private double balance;
    private double ratePerSecond;
    private String circle;

    public Sim(int simId, String customerName, double balance, double ratePerSecond, String circle) {
        this.simId = simId;
        this.customerName = customerName;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }

    public int getSimId() {
        return simId;
    }

    public void setSimId(int simId) {
        this.simId = simId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRatePerSecond() {
        return ratePerSecond;
    }

    public void setRatePerSecond(double ratePerSecond) {
        this.ratePerSecond = ratePerSecond;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }
}