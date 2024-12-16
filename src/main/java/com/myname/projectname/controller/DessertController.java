package com.myname.projectname.controller;

import com.myname.projectname.model.Dessert;
import com.myname.projectname.service.DessertService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desserts")
public class DessertController {

    private final DessertService dessertService;

    public DessertController(DessertService dessertService) {
        this.dessertService = dessertService;
    }

    @GetMapping
    public List<Dessert> getAllDesserts() {
        return dessertService.getAllDesserts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dessert createDessert(@RequestBody Dessert dessert) {
        return dessertService.saveDessert(dessert);
    }

    @PutMapping("/{id}/price")
    public Dessert updateDessertPrice(@PathVariable Long id, @RequestParam double price) {
        return dessertService.updateDessertPrice(id, price);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDessert(@PathVariable Long id) {
        dessertService.deleteDessert(id);
    }
}