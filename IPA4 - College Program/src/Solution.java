import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        College[] colleges=new College[n];
        for(int i=0;i<n;i++){
            int id=scan.nextInt();
            scan.nextLine();
            String name=scan.nextLine();
            int contactNo=scan.nextInt();
            scan.nextLine();
            String address=scan.nextLine();
            int pinCode=scan.nextInt();

            colleges[i]=new College(id,name,contactNo,address,pinCode);
        }
        scan.nextLine();
        String address=scan.nextLine();
        College collegeWithMaximumPinCode=findCollegeWithMaximumPincode(colleges);
        if(collegeWithMaximumPinCode!=null){
            System.out.println("id-"+collegeWithMaximumPinCode.getId());
            System.out.println("name-"+collegeWithMaximumPinCode.getName());
            System.out.println("contactNo-"+collegeWithMaximumPinCode.getContactNo());
            System.out.println("address-"+collegeWithMaximumPinCode.getAddress());
            System.out.println("pincode-"+collegeWithMaximumPinCode.getPinCode());
        }
        else{
            System.out.println("No college found with mentioned attribute");
        }

        College collegeByAddress=searchCollegeByAddress(colleges,address);
        if(collegeByAddress!=null){
            System.out.println("id-"+collegeByAddress.getId());
            System.out.println("name-"+collegeByAddress.getName());
            System.out.println("contactNo-"+collegeByAddress.getContactNo());
            System.out.println("address-"+collegeByAddress.getAddress());
            System.out.println("pincode-"+collegeByAddress.getPinCode());
        }
        else{
            System.out.println("No college found with mentioned attribute");
        }

    }
    public static College findCollegeWithMaximumPincode(College[] colleges){
        College highestPinCode=null;
        int MaxPinCode=Integer.MIN_VALUE;
        for(College cl: colleges){
            if(cl.getPinCode()>MaxPinCode){
                MaxPinCode=cl.getPinCode();
                highestPinCode=cl;
            }
        }
        return highestPinCode;
    }
    public static College searchCollegeByAddress(College[] colleges, String address){
        for(College cl: colleges){
            if(cl.getAddress().equalsIgnoreCase(address)){
                return cl;
            }
        }
        return null;
    }

}

class College{
    private int id;
    private String name;
    private int contactNo;
    private String address;
    private int pinCode;

    public College(int id, String name, int contactNo, String address, int pinCode) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
        this.pinCode = pinCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}