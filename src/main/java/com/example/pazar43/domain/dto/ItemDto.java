package com.example.pazar43.domain.dto;

import com.example.pazar43.domain.Category;
import com.example.pazar43.domain.Image;
import lombok.Data;

import java.util.Set;

@Data
public class ItemDto {
    private String name;
    private Set<Image> images;
    private Set<Category> categories;
}
