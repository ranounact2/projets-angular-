package .products.config;

import com.rania.products.model.Product;
import com.rania.products.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** Remplit la base H2 au démarrage avec trois produits (comme dans la vidéo). */
@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        productRepository.save(new Product("computer", 1300, 5, true));
        productRepository.save(new Product("printer", 450, 12, false));
        productRepository.save(new Product("smartphone", 850, 8, true));
    }
}
