package com.rania.products.rest;

import com.rania.products.model.Product;
import com.rania.products.repository.ProductRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Contrôleur REST consommé par le frontend Angular.
 * @CrossOrigin règle le blocage CORS expliqué à la fin de la vidéo.
 */
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductRest {

    private final ProductRepository productRepository;

    // Injection de dépendances via le constructeur
    public ProductRest(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /** GET http://localhost:8083/products */
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /** GET http://localhost:8083/products/{id} */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    /** DELETE http://localhost:8083/products/{id} */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
