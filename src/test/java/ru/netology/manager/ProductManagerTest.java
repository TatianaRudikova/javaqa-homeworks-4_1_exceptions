package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Watch;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    @Test
    public void shouldSearchByNameBook() {
        ProductManager manager = new ProductManager(new ProductRepository());
        Product baskervilles = new Book(1, "The Hound of the Baskervilles", 1500, "Arthur Conan Doyle");
        Product fang = new Book(2, "White Fang", 2800, "Jack London");
        Product redmi = new Smartphone(3, "Redmi 9C NFC", 10000, "Xiaomi");
        manager.add(baskervilles);
        manager.add(fang);
        manager.add(redmi);

        Product[] actual = manager.searchBy("White");
        Product[] expected = new Product[]{fang};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        ProductManager manager = new ProductManager(new ProductRepository());
        Product baskervilles = new Book(1, "The Hound of the Baskervilles", 1500, "Arthur Conan Doyle");
        Product fang = new Book(2, "White Fang", 2800, "Jack London");
        Product redmi = new Smartphone(3, "Redmi 9C NFC", 10000, "Xiaomi");
        manager.add(baskervilles);
        manager.add(fang);
        manager.add(redmi);

        Product[] actual = manager.searchBy("Arthur");
        Product[] expected = new Product[]{baskervilles};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameSmartphone() {
        ProductManager manager = new ProductManager(new ProductRepository());
        Product baskervilles = new Book(1, "The Hound of the Baskervilles", 1500, "Arthur Conan Doyle");
        Product fang = new Book(2, "White Fang", 2800, "Jack London");
        Product redmi = new Smartphone(3, "Redmi 9C NFC", 10000, "Xiaomi");
        manager.add(baskervilles);
        manager.add(fang);
        manager.add(redmi);

        Product[] actual = manager.searchBy("Redmi");
        Product[] expected = new Product[]{redmi};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturerSmartphone() {
        ProductManager manager = new ProductManager(new ProductRepository());
        Product baskervilles = new Book(1, "The Hound of the Baskervilles", 1500, "Arthur Conan Doyle");
        Product fang = new Book(2, "White Fang", 2800, "Jack London");
        Product redmi = new Smartphone(3, "Redmi 9C NFC", 10000, "Xiaomi");
        manager.add(baskervilles);
        manager.add(fang);
        manager.add(redmi);

        Product[] actual = manager.searchBy("Xiaomi");
        Product[] expected = new Product[]{redmi};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneNonProduct() {
        ProductManager manager = new ProductManager(new ProductRepository());
        Product baskervilles = new Book(1, "The Hound of the Baskervilles", 1500, "Arthur Conan Doyle");
        Product fang = new Book(2, "White Fang", 2800, "Jack London");
        Product redmi = new Smartphone(3, "Redmi 9C NFC", 10000, "Xiaomi");
        Product watch = new Watch(4, "smart watch", 5000, "Smart Watch");
        manager.add(baskervilles);
        manager.add(fang);
        manager.add(redmi);
        manager.add(watch);

        Product[] actual = manager.searchBy("Galaxy");
        Product[] expected = new Product[0];

        assertArrayEquals(expected, actual);
    }
}