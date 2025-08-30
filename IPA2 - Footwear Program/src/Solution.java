import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        Footwear[] footwears=new Footwear[n];
        for(int i=0;i<n;i++){
            int footwearId=scan.nextInt();
            scan.nextLine();
            String footwearName=scan.nextLine();
            String footwearType=scan.nextLine();
            int price=scan.nextInt();
            footwears[i]=new Footwear(footwearId,footwearName,footwearType,price);
        }
        scan.nextLine();
        String footwearType=scan.nextLine();
        String footwearName=scan.nextLine();
        int countType=getCountByType(footwears,footwearType);
        if(countType>0){
            System.out.println(countType);
        }
        else{
            System.out.println("Footwear not available");
        }

        Footwear secondHighestPriceFootwear=getSecondHighestPriceByBrand(footwears,footwearName);
        if(secondHighestPriceFootwear!=null){
            System.out.println(secondHighestPriceFootwear.getFootwearId());
            System.out.println(secondHighestPriceFootwear.getFootwearName());
            System.out.println(secondHighestPriceFootwear.getPrice());
        }
        else{
            System.out.println("Brand not available");
        }

    }
    public static int getCountByType(Footwear[] footwears, String footwearType){
        int count=0;
        for(Footwear fw: footwears){
            if(fw.getFootwearType().equalsIgnoreCase(footwearType)){
                count++;
            }
        }
        return Math.max(count, 0);
    }
    public static Footwear getSecondHighestPriceByBrand(Footwear[] footwears,String footwearName){
        ArrayList<Footwear> secondHighestPriceFootwear=new ArrayList<>();
        for(Footwear fw: footwears){
            if(fw.getFootwearName().equalsIgnoreCase(footwearName)){
                secondHighestPriceFootwear.add(fw);
            }
        }
        secondHighestPriceFootwear.sort(Comparator.comparing(Footwear::getPrice).reversed());

        if(secondHighestPriceFootwear.size()>2){
            return secondHighestPriceFootwear.get(1);
        }
        return null;
    }

}

class Footwear{
    private int footwearId;
    private String footwearName;
    private String footwearType;
    private int price;

    public Footwear(int footwearId, String footwearName, String footwearType, int price) {
        this.footwearId = footwearId;
        this.footwearName = footwearName;
        this.footwearType = footwearType;
        this.price = price;
    }

    public int getFootwearId() {
        return footwearId;
    }

    public void setFootwearId(int footwearId) {
        this.footwearId = footwearId;
    }

    public String getFootwearName() {
        return footwearName;
    }

    public void setFootwearName(String footwearName) {
        this.footwearName = footwearName;
    }

    public String getFootwearType() {
        return footwearType;
    }

    public void setFootwearType(String footwearType) {
        this.footwearType = footwearType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}