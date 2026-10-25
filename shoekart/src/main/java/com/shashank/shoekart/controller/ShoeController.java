package com.shashank.shoekart.controller;

import com.shashank.shoekart.model.Shoe;
import com.shashank.shoekart.repository.ShoeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoes")
public class ShoeController {

    private final ShoeRepository shoeRepository;

    public ShoeController(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    // CREATE
    @PostMapping
    public String addShoe(@RequestBody Shoe shoe) {
        int rows = shoeRepository.save(shoe);
        return rows > 0 ? "Shoe added successfully!" : "Failed to add shoe.";
    }

    // READ - all
    @GetMapping
    public List<Shoe> getAllShoes() {
        return shoeRepository.findAll();
    }

    // READ - by ID
    @GetMapping("/{id}")
    public Shoe getShoeById(@PathVariable int id) {
        return shoeRepository.findById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateShoe(@PathVariable int id, @RequestBody Shoe shoe) {
        shoe.setId(id);
        int rows = shoeRepository.update(shoe);
        return rows > 0 ? "Shoe updated successfully!" : "Failed to update shoe.";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteShoe(@PathVariable int id) {
        int rows = shoeRepository.deleteById(id);
        return rows > 0 ? "Shoe deleted successfully!" : "Failed to delete shoe.";
    }
}
