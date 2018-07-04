package pl.mkcode.aop.services;

import pl.mkcode.aop.annotations.Logged;
import pl.mkcode.aop.model.Animal;

public interface ZooService {
    @Logged
    void feed(Animal animal);

    void payEmployees();
}
