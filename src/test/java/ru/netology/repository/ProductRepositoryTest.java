package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    public void shouldRemoveByIdExistingElement() {
        ProductRepository repository = new ProductRepository();

        Product baskervilles = new Book(145, "The Hound of the Baskervilles", 1500, "Arthur Conan Doyle");
        Product fang = new Book(287, "White Fang", 2800, "Jack London");
        Product redmi = new Smartphone(395, "Redmi 9C NFC", 10000, "Xiaomi");
        repository.save(baskervilles);
        repository.save(fang);
        repository.save(redmi);


        repository.removeById(287);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{baskervilles, redmi};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNonExistingElement() {
        ProductRepository repository = new ProductRepository();

        Product baskervilles = new Book(145, "The Hound of the Baskervilles", 1500, "Arthur Conan Doyle");
        Product fang = new Book(287, "White Fang", 2800, "Jack London");
        Product redmi = new Smartphone(395, "Redmi 9C NFC", 10000, "Xiaomi");
        repository.save(baskervilles);
        repository.save(fang);
        repository.save(redmi);


        assertThrows(NotFoundException.class, () -> {
            repository.removeById(111);
        });
    }
}