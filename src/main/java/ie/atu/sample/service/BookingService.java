package ie.atu.sample.service;

import ie.atu.sample.dto.Responses;
import ie.atu.sample.client.BookingClient;
import ie.atu.sample.dto.Room;
import ie.atu.sample.model.Booking;
import ie.atu.sample.dto.Request;
import ie.atu.sample.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingClient bookingClient;

    public BookingService(BookingRepository bookingRepository, BookingClient bookingClient) {
        this.bookingRepository = bookingRepository;
        this.bookingClient = bookingClient;
    }

    public List<Booking> getAll(){
       return bookingRepository.findAll();
    }

    public Booking create(Request request){

        Room room = bookingClient.getRoom(request.roomID());
        if (request.count()> room.getCapacity())
        {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Room Capacity Exceeded");
        }

        Booking bookingEntity = new Booking();
        bookingEntity.setName(request.name());
        bookingEntity.setRoomID(request.roomID());
        bookingEntity.setCount(request.count());

        return  bookingRepository.save(bookingEntity);
    }

    public Responses getById(Long id){
        Booking booking  = bookingRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Incorrect booking id"));
        Responses response = new Responses();
        response.setId(booking.getId());
        response.setName(booking.getName());
        response.setRoomID(booking.getRoomID());
        response.setCount(booking.getCount());
        response.setStatus(booking.isStatus());
        return response;
    }
}
