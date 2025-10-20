package com.TheCoderKushagra.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category_attributes")
public class CategoryAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attributeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String attributeName;
    private String dataType;   // varchar, int, decimal, boolean
    private Boolean isRequired;

    @Column(columnDefinition = "JSON")
    private String validationRules;
}
