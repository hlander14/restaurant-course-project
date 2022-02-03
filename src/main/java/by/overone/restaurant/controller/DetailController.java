package by.overone.restaurant.controller;

import by.overone.restaurant.entity.Detail;
import by.overone.restaurant.exception_handling.NoSuchRestaurantException;
import by.overone.restaurant.service.impl.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DetailController {
    @Autowired
    private DetailService detailService;

    @GetMapping("/api/details")
    public List<Detail> findAll() {
        return detailService.findAll();
    }

    @GetMapping("/api/details/{id}")
    public Detail findById(@PathVariable("id") Long id) {
        return detailService.findById(id);
    }

    @PostMapping("/api/details")
    public Detail create(@RequestBody Detail detail) {
        detailService.create(detail);
        return detail;
    }

    @PutMapping("/api/details")
    public Detail update(@RequestBody Detail detail) {
        detailService.create(detail);
        return detail;
    }

    @DeleteMapping("/api/details/{id}")
    public String delete(@PathVariable Long id) {
        if (detailService.findById(id) == null) {
            throw new NoSuchRestaurantException("There is no employee with ID = " + id + " in database.");
        }
        detailService.delete(id);
        return "Employee with ID = " + id + " was deleted";
    }
}
