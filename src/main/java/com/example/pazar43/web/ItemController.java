package com.example.pazar43.web;

import com.example.pazar43.domain.Category;
import com.example.pazar43.domain.Item;
import com.example.pazar43.domain.dto.ItemDto;
import com.example.pazar43.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(path = "/items")
    public ResponseEntity createNewItem(@RequestBody ItemDto item){
        itemService.createNewItem(item);
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }
//    @GetMapping(path = "/items")
//    public List<Item> getAllItems(){
//        return itemService.findAllItems();
//    }
    @GetMapping(path = "/items/{id}")
    public Optional<Item> getOne(@RequestParam Long id){
        return itemService.findOne(id);
    }

    @GetMapping(path = "/items")
    public List<Item> getItemsBy(@RequestParam String city , @RequestParam Category category){
        return itemService.findAllItems();
    }
}
