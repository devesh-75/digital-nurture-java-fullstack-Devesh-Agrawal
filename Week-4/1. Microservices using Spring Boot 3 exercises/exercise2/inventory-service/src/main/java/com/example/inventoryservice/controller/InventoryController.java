package com.example.inventoryservice.controller;

import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping
    public Inventory saveInventory(@RequestBody Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Inventory> getInventoryByProductId(@PathVariable Long productId) {
        return inventoryRepository.findByProductId(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/product/{productId}")
    public ResponseEntity<Inventory> updateStock(@PathVariable Long productId, @RequestParam Integer quantity) {
        return inventoryRepository.findByProductId(productId)
                .map(inv -> {
                    inv.setQuantity(quantity);
                    return ResponseEntity.ok(inventoryRepository.save(inv));
                })
                .orElseGet(() -> {
                    Inventory inv = new Inventory(null, productId, quantity);
                    return ResponseEntity.ok(inventoryRepository.save(inv));
                });
    }
}
