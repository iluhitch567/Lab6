package com.myname.projectname.controller;

import com.myname.projectname.model.Drink;
import com.myname.projectname.service.DrinkService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping
    public List<Drink> getAllDrinks() {
        return drinkService.getAllDrinks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Drink createDrink(@RequestBody Drink drink) {
        return drinkService.saveDrink(drink);
    }

    @PutMapping("/{id}/price")
    public Drink updateDrinkPrice(@PathVariable Long id, @RequestParam double price) {
        return drinkService.updateDrinkPrice(id, price);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDrink(@PathVariable Long id) {
        drinkService.deleteDrink(id);
    }
}