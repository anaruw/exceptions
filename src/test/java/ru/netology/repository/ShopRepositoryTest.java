package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.exceptions.AlreadyExistsException;
import ru.netology.exceptions.NotFoundException;

public class ShopRepositoryTest {

    int id = 1;
    Product item = new Product(id, "сыр", 1);

    @Test
    public void addNewProductTest() {

        ShopRepository repo = new ShopRepository();

        repo.add(item);

        Product[] expected = {item};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addProductAlreadyExistsTest() {

        ShopRepository repo = new ShopRepository();

        repo.add(item);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {

            repo.add(item);
        });
    }

    @Test
    public void removeProductTest() {

        ShopRepository repo = new ShopRepository();

        repo.add(item);
        repo.removeById(id);

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeProductNotFoundTest() {

        ShopRepository repo = new ShopRepository();

        Assertions.assertThrows(NotFoundException.class, () -> {

            repo.removeById(id);
        });
    }
}