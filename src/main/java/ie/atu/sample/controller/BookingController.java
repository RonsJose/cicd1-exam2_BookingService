package ie.atu.sample.controller;

import ie.atu.sample.dto.Responses;
import ie.atu.sample.model.Booking;
import ie.atu.sample.dto.Request;
import ie.atu.sample.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Booking")
public class BookingController {

    private final BookingService service;
    public BookingController(BookingService service) {
        this.service = service;
    }

    @GetMapping
    public List<Booking> getAll () {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Booking create(@RequestBody Request booking) {
        return  service.create(booking);
    }

    @GetMapping("/{id}")
    public Responses getById(@PathVariable Long id){
        return service.getById(id);
    }
}
