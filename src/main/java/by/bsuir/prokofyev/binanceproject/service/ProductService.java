package by.bsuir.prokofyev.binanceproject.service;

import by.bsuir.prokofyev.binanceproject.dto.ProductDTO;
import by.bsuir.prokofyev.binanceproject.entity.Product;
import by.bsuir.prokofyev.binanceproject.repository.ProductRepository;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product create(ProductDTO dto) {
        return productRepository.save(Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .build());
    }

    public List<Product> readAll() {
        return productRepository.findAll();
    }

    public Product update(Product product) {
        return  productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
