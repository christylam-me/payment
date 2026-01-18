package me.cc.product;

import static org.assertj.core.api.Assertions.assertThat;

import me.cc.payment.product.Product;
import me.cc.payment.product.ProductController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Stream;

public class ProductControllerTest {
    ProductController controller = new ProductController();

    @Test
    public void testGetProductsSuccess() {
        var actual = controller.getProducts();
        var expected = List.of(
                new Product(1, "Apple", 2),
                new Product(2, "Mango", 3),
                new Product(3, "Watermelon", 18)
        );

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("getIdAndExpectation")
    public void testGetProductByIdSuccess(int id, Product expected) {
        var actual = controller.getProductById(id);

        assertThat(actual).isEqualTo(ResponseEntity.ok(expected));
    }

    private static Stream<Arguments> getIdAndExpectation() {
        return Stream.of(Arguments.of(
            1, new Product(1, "Apple", 2),
            2, new Product(2, "Mango", 3),
            3, new Product(3, "Watermelon", 18)
        ));
    }

    @Test
    public void testGetProductByUnknownIdNotFound() {
        var actual = controller.getProductById(123);

        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
