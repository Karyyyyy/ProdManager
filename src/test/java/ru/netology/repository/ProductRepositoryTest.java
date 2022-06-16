package ru.netology.repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Books;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
    Product books1 = new Books(123, "Ребекка", 500, "Дафна Дюморье");
    Product books2 = new Books(456, "Конек-Горбунок", 400, "Пётр Ершов");
    Product books3 = new Books(789, "Медвежонок Паддингтон", 600, "Майкл Бонд");
    Product smartphone1 = new Smartphone(111, "iPhone 13", 130_000, "Apple");
    Product smartphone2 = new Smartphone(999, "Samsung S20FE", 50_000, "Samsung");
    Product smartphone3 = new Smartphone(191, "Nokia", 1000, "Nokia");

    @Test
    public void removeById() {
        ProductRepository repository = new ProductRepository();
        repository.save(books1);
        repository.save(books2);
        repository.save(books3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);

        repository.removeById(111);
        repository.findAll();

        Product[] actual = repository.findAll();
        Product[] expected = {books1, books2, books3, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }
}

