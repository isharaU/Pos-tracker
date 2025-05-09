package lk.hsenid.pos.sales.tracker.service;

import lk.hsenid.pos.sales.tracker.entity.Product;
import lk.hsenid.pos.sales.tracker.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    public ProductServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(new Product(), new Product()));
        assertEquals(2, productService.getAllProducts().size());
    }

    @Test
    void testGetProductById() {
        Product product = new Product();
        product.setId(1L);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        assertTrue(productService.getProductById(1L).isPresent());
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();
        product.setName("Updated");
        productService.updateProduct(product);
        verify(productRepository, times(1)).save(product);
    }
}