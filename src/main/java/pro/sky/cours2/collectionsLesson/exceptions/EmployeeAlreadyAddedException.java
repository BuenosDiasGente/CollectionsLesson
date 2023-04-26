package pro.sky.cours2.collectionsLesson.exceptions;

import pro.sky.cours2.collectionsLesson.Employee;

import java.util.List;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
