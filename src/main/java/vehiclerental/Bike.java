package vehiclerental;

import java.time.LocalTime;

public class Bike implements Rentable {

    private String bikeId;
    private LocalTime rentingTime;
    private final static int RENTING_PRICE = 15;

    public Bike(String bikeId) {
        this.bikeId = bikeId;
    }

    public String getBikeId() {
        return bikeId;
    }

    @Override
    public LocalTime getRentingTime() {
        return rentingTime;
    }


    @Override
    public int calculateSumPrice(long minutes) {
        return (int)(RENTING_PRICE * minutes);
    }

    @Override
    public void rent(LocalTime time) {
        rentingTime = time;
    }

    @Override
    public void closeRent() {
        rentingTime=null;
    }

    @Override
    public int compareTo(Rentable o) {
        return rentingTime.compareTo(o.getRentingTime());
    }
}
