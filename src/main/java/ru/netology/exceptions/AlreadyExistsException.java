package ru.netology.exceptions;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(int id) {
        super("В репозитории уже существует элемент с таким id " + id);
    }
}