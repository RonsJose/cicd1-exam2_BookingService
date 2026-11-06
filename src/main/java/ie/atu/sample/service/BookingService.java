package ie.atu.sample.service;

import ie.atu.sample.model.Booking;
import ie.atu.sample.model.Request;
import ie.atu.sample.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAll(){
       return bookingRepository.findAll();
    }

    public Booking create(Request booking){

        Booking bookingEntity = new Booking();
        bookingEntity.setName(booking.name());
        bookingEntity.setRoomID(booking.roomID());
        bookingEntity.setCount(booking.count());
        bookingEntity.setStatus(booking.status());
        return  bookingRepository.save(bookingEntity);
    }
}
