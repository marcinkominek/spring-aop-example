package pl.mkcode.aop.services;

import org.springframework.stereotype.Service;
import pl.mkcode.aop.annotations.Logged;
import pl.mkcode.aop.model.Animal;

@Service
public class ZookeeperService {

    @Logged
    public void feed(Animal animal) {
    }
}
