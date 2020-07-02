package alexpetrut.overnightbooking;

import org.hibernate.dialect.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder (BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<HotelBooking> bookings = new ArrayList<>();

        bookings.add (new HotelBooking("Marriot", 200.50, 3));
        bookings.add (new HotelBooking("Ibis", 99.99, 5));
        bookings.add (new HotelBooking("Delta", 144, 2));

        bookingRepository.saveAll(bookings);
    }
}
