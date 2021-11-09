package ru.manuvika.dto;

import lombok.ToString;
import lombok.With;

@With
@ToString
public class Product {
    Integer id;
    String title;
    Integer price;
    String categoryTitle;
}
