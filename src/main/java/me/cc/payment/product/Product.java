package me.cc.payment.product;

import java.util.List;

public record Product(int id, String name, int price) {
    private static final List<Product> exampleList = List.of(
        new Product(1, "Apple", 2),
        new Product(2, "Mango", 3),
        new Product(3, "Watermelon", 18)
    );

    static List<Product> getExampleProducts() {
        return exampleList;
    }

    static Product getProductById(int id) {
        return exampleList.stream()
                .filter(product -> product.id == id)
                .findFirst()
                .orElse(null);
    }
}
