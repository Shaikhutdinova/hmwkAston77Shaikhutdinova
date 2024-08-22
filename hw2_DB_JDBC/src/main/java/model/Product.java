package model;

import lombok.Data;

import java.text.DecimalFormat;

@Data
public class Product {
    private final int id;
    private String name;
    private String description;
    private int price;
    private String category;
}
