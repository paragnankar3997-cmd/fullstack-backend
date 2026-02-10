package com.example.demo.controller

import com.example.demo.model.Item
import com.example.demo.repository.ItemRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/items")
class ItemController(private val itemRepository: ItemRepository) {

    @GetMapping
    fun getAllItems(): List<Item> = itemRepository.findAll()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: Long): ResponseEntity<Item> {
        val item = itemRepository.findById(id)
        return if (item.isPresent) {
            ResponseEntity.ok(item.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createItem(@RequestBody item: Item): ResponseEntity<Item> {
        val savedItem = itemRepository.save(item)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: Long, @RequestBody itemDetails: Item): ResponseEntity<Item> {
        val item = itemRepository.findById(id)
        return if (item.isPresent) {
            val existingItem = item.get()
            existingItem.name = itemDetails.name
            existingItem.description = itemDetails.description
            val updatedItem = itemRepository.save(existingItem)
            ResponseEntity.ok(updatedItem)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: Long): ResponseEntity<Void> {
        return if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
