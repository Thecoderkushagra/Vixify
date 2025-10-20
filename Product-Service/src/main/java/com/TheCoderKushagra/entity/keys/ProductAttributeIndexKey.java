package com.TheCoderKushagra.entity.keys;

import java.io.Serializable;
import java.util.Objects;

public class ProductAttributeIndexKey implements Serializable {
    private Long product;
    private String attributeName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductAttributeIndexKey that)) return false;
        return Objects.equals(product, that.product) &&
                Objects.equals(attributeName, that.attributeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, attributeName);
    }
}
