package com.example.pazar43.service;

import com.example.pazar43.domain.Category;
import com.example.pazar43.domain.Item;
import com.example.pazar43.domain.dto.ItemDto;
import com.example.pazar43.repository.CategoryRepository;
import com.example.pazar43.repository.ImageRepository;
import com.example.pazar43.repository.ItemRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ImageRepository imageRepository;
    private final CategoryRepository categoryRepository;


    public ItemService(ItemRepository itemRepository, ImageRepository imageRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.imageRepository = imageRepository;
        this.categoryRepository = categoryRepository;
    }

    public void createNewItem(ItemDto item){
        Item item1 = new Item();

        item1.setName(item.getName());

        Item save = itemRepository.save(item1);
        item.getImages().forEach(x->{
            x.setItem(save);
            imageRepository.save(x);
        });
        item.getCategories().forEach(x->{
            x.setItem(save);
            categoryRepository.save(x);
        });
    }

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }
    public Optional<Item> findOne(Long id){
        return itemRepository.findById(id);
    }
    public List<Item> findByExample(Item item,Category category){

        Example<Item> example = Example.of(item);
        List<Item> all = itemRepository.findAll(example);
        List<Item> collect = all.stream().filter(x -> {
            if(x.getCategories().stream().filter(c->c.getCategory().equals(category.getCategory())).collect(Collectors.toList()).isEmpty()){
                return false;
            }return true;

        }).collect(Collectors.toList());

        return  collect;
    }
}
