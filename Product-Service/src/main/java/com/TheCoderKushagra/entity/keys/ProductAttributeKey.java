package com.TheCoderKushagra.entity.keys;

import java.io.Serializable;
import java.util.Objects;

public class ProductAttributeKey implements Serializable {
    private Long product;
    private Long attribute;

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductAttributeKey that)) return false;
        return Objects.equals(product, that.product) &&
                Objects.equals(attribute, that.attribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, attribute);
    }
}
