package com.example.api_rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final Map<Integer, Item> items = new HashMap<>();

    @GetMapping("/")
    public List<Item> getAllItems() {
        return new ArrayList<>(items.values());
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Integer id) {
        return items.get(id);
    }

    @PostMapping("/")
    public Item addItem(@RequestBody Item item) {
        items.put(item.getId(), item);
        return item;
    }

    static class Item {
        private Integer id;
        private String name;

        // Construtores, getters e setters

        public Item() {}

        public Item(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}