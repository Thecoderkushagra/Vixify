package com.TheCoderKushagra.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category_attributes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String attributeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String attributeName;
    private String dataType;   // varchar, int, decimal, boolean
    private Boolean isRequired;

    @Column(columnDefinition = "JSON")
    private String validationRules;
}
