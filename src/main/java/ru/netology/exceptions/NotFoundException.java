package ru.netology.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Элемента с таким id(" + id + ") не найдено");
    }
}