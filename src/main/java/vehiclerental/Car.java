package vehiclerental;

import java.time.LocalTime;

public class Car implements Rentable {
    private String carId;
    private LocalTime rentingTime;
    private int rentingPrice;

    public Car(String carId, int rentingPrice) {
        this.carId = carId;
        this.rentingPrice = rentingPrice;
    }


    @Override
    public int calculateSumPrice(long minutes) {
        return (int)(rentingPrice * minutes);
    }

    @Override
    public LocalTime getRentingTime() {
        return rentingTime;
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
