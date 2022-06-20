package ru.netology.domain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    Product books1 = new Books(123, "Ребекка", 500, "Дафна Дюморье");
    Product books2 = new Books(456, "Конек-Горбунок", 400, "Пётр Ершов");
    Product books3 = new Books(789, "Медвежонок Паддингтон", 600, "Майкл Бонд");
    Product smartphone1 = new Smartphone(111, "iPhone 13", 130_000, "Apple");
    Product smartphone2 = new Smartphone(999, "Samsung S20FE", 50_000, "Samsung");
    Product smartphone3 = new Smartphone(191, "Nokia", 1000, "Nokia");


    @Test
    public void shouldSearchBy() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(books1);
        manager.add(books2);
        manager.add(books3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.findAll();


        Product[] actual = manager.searchBy("Гор");
        Product[] expected = {books2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy1() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(books1);
        manager.add(books2);
        manager.add(books3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);


        Product[] actual = manager.searchBy("13");
        Product[] expected = {smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchBy2() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(books1);
        manager.add(books2);
        manager.add(books3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.findAll();


        Product[] actual = manager.searchBy("ФФ");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(books1);
        manager.add(books2);
        manager.add(books3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.removeById(456);
        manager.findAll();

        Product[] actual = manager.findAll();
        Product[] expected = {books1, books3, smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy3() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.findAll();

        Product[] actual = manager.searchBy("а");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy4() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(books1);

        manager.findAll();

        Product[] actual = manager.searchBy("Ре");
        Product[] expected = {books1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy5() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(books1);
        manager.add(books2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        manager.findAll();

        Product[] actual = manager.searchBy("Ре");
        Product[] expected = {books1};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void SearchEmptyProducts() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.findAll();

        Product[] actual = manager.findAll();
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldOneProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(books1);

        manager.removeById(123);
        manager.findAll();

        Product[] actual = manager.findAll();
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldTwoProducts() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(books1);
        manager.add(books2);

        manager.removeById(456);
        manager.findAll();

        Product[] actual = manager.findAll();
        Product[] expected = {books1};
        Assertions.assertArrayEquals(expected, actual);
    }

}


