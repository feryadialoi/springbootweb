package dev.feryadi.springbootweb.restcontroller;

import dev.feryadi.springbootweb.model.Product;
import dev.feryadi.springbootweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 10/8/2021 9:04 PM
 */
@RestController(value = "apiProductController")
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

}
