import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Hotel[] hotels=new Hotel[4];
        for(int i=0;i<4;i++){
            int hotelId=scan.nextInt();
            scan.nextLine();
            String hotelName=scan.nextLine();
            String dataOfBooking=scan.nextLine();
            int noOfRoomsBooked=scan.nextInt();
            scan.nextLine();
            String cabFacility=scan.nextLine();
            double totalBill=scan.nextInt();
            hotels[i]=new Hotel(hotelId,hotelName,dataOfBooking,noOfRoomsBooked,cabFacility,totalBill);
        }
        scan.nextLine();
        String givenCabFacility=scan.nextLine();
        int numberOfRoomsBooked=totalNoOfRoomsBooked(hotels,givenCabFacility);
        if(numberOfRoomsBooked>0){
            System.out.println(numberOfRoomsBooked);
        }
        else{
            System.out.println("No such rooms booked");
        }
    }
    public static int totalNoOfRoomsBooked(Hotel[] hotels, String givenCabFacility){
        int totalRoomBooked=0;
        for(Hotel ht: hotels){
            if(ht.getCabFacility().equalsIgnoreCase(givenCabFacility) && ht.getNoOfRoomsBooked()>5){
                totalRoomBooked+=ht.getNoOfRoomsBooked();
            }
        }
        return totalRoomBooked;
    }
}

class Hotel{
    private int hotelId;
    private String hotelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String cabFacility;
    private double totalBill;

    public Hotel(int hotelId, String hotelName, String dateOfBooking, int noOfRoomsBooked, String cabFacility, double totalBill) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.cabFacility = cabFacility;
        this.totalBill = totalBill;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(String dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public int getNoOfRoomsBooked() {
        return noOfRoomsBooked;
    }

    public void setNoOfRoomsBooked(int noOfRoomsBooked) {
        this.noOfRoomsBooked = noOfRoomsBooked;
    }

    public String getCabFacility() {
        return cabFacility;
    }

    public void setCabFacility(String cabFacility) {
        this.cabFacility = cabFacility;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }
}