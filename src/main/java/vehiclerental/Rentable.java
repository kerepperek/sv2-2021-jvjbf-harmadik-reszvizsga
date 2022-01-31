package vehiclerental;

import java.time.LocalTime;

public interface Rentable extends Comparable<Rentable>{
    static LocalTime rentingTime = null;

    int calculateSumPrice(long minutes);

    LocalTime getRentingTime();

    void rent(LocalTime time);

    void closeRent();

    @Override
    default int compareTo(Rentable o) {
        return rentingTime.compareTo(o.getRentingTime());
    }
}
