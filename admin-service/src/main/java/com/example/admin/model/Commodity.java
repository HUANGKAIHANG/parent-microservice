package com.example.admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Commodity {

    private Long id;

    private String name;

    private String author;

    private BigDecimal price;

    private Category category;

    private String imagePath;

    private String publisher;

    private String ISBN;

    private Language language;

    private int visible;
}
