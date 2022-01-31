package vehiclerental;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class RentService {

    private Set<User> users = new HashSet<>();
    private Set<Rentable> rentables = new HashSet<>();
    private Map<Rentable, User> actualRenting = new TreeMap<>();

    public void registerUser(User user) {
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())) {
                throw new UserNameIsAlreadyTakenException("Username is taken!");
            }
        }
        users.add(user);
    }

    public void rent(User user, Rentable rentable, LocalTime time) {
        Map<Rentable, User> userRenting = actualRenting.entrySet().stream()
                .filter(x -> x.getValue().getUserName().equals(user.getUserName()))
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

        for (Rentable r : userRenting.keySet()) {
            if (r.getRentingTime().equals(time)) {
                throw new IllegalStateException("Renting time is reserved!");
            }
        }
        if (user.getBalance() < rentable.calculateSumPrice(3 * 60)) {
            throw new IllegalStateException("Renting time is reserved!");
        }
        rentable.rent(time);
        actualRenting.put(rentable, user);
    }

    public Map<Rentable, User> getActualRenting() {
        return actualRenting;
    }

    public void addRentable(Rentable rentable) {
        rentables.add(rentable);
    }

    public Set<User> getUsers() {
        return users;
    }

    public Set<Rentable> getRentables() {
        return rentables;
    }

    public void closeRent(Rentable rentable, int minutes) {
        Map<Rentable, User> userRenting = actualRenting.entrySet().stream()
                .filter(x -> x.getKey().equals(rentable))
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

     //   Rentable rentable= actualRenting.entrySet()
     //   rentable.minusBalance(minutes);
    }

}


