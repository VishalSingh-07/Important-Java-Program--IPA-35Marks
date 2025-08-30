import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Hotel [] hotels=new Hotel[4];
        for(int i=0;i<4;i++){
            int hotelId=scan.nextInt();
            scan.nextLine();
            String hotelName=scan.nextLine();
            String dateOfBooking=scan.nextLine();
            int noOfRoomsBooked=scan.nextInt();
            scan.nextLine();
            String wifiFacility=scan.nextLine();
            double totalBill=scan.nextDouble();

            hotels[i]=new Hotel(hotelId,hotelName,dateOfBooking,noOfRoomsBooked,wifiFacility,totalBill);
        }
        scan.nextLine();
        String givenMonth=scan.nextLine();
        String wifi=scan.nextLine();

        int totalRoomsBooked=noOfRoomsBookedInGivenMonth(hotels,givenMonth);
        if(totalRoomsBooked>0){
            System.out.println(totalRoomsBooked);
        }
        else{
           System.out.println("No rooms booked in the given month");
        }

        Hotel hotelByWifiOption=searchHotelByWifiOption(hotels,wifi);
        if(hotelByWifiOption!=null){
            System.out.println(hotelByWifiOption.getHotelId());
        }
        else{
           System.out.println("No such option available");
        }
    }
    public static int noOfRoomsBookedInGivenMonth(Hotel[] hotels, String givenMonth){
        int totalRooms=0;
        for(Hotel ht: hotels){

            if(ht.getDateOfBooking().contains(givenMonth)){
                totalRooms+=ht.getNoOfRoomsBooked();
            }
        }
        return totalRooms;
    }
    public static Hotel searchHotelByWifiOption(Hotel[] hotels, String wifi){
        ArrayList<Hotel> highestByWifiOption=new ArrayList<>();
        for(Hotel ht: hotels){
            if(ht.getWifiFacility().equalsIgnoreCase(wifi)){
                highestByWifiOption.add(ht);
            }
        }
        if(highestByWifiOption.isEmpty()){
            return null;
        }
        highestByWifiOption.sort(Comparator.comparing(Hotel :: getTotalBill).reversed());

        return highestByWifiOption.get(1);
    }
}


class Hotel{
    private int hotelId;
    private String hotelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String wifiFacility;
    private double totalBill;

    public Hotel(int hotelId, String hotelName, String dateOfBooking, int noOfRoomsBooked, String wifiFacility, double totalBill) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.wifiFacility = wifiFacility;
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

    public String getWifiFacility() {
        return wifiFacility;
    }

    public void setWifiFacility(String wifiFacility) {
        this.wifiFacility = wifiFacility;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }
}