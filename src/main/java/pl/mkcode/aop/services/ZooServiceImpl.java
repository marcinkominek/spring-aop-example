package pl.mkcode.aop.services;

import org.springframework.stereotype.Component;
import pl.mkcode.aop.annotations.Logged;
import pl.mkcode.aop.model.Animal;
import pl.mkcode.aop.model.Zookeeper;

@Component
public class ZooServiceImpl implements ZooService {

    private Zookeeper zookeeper = new Zookeeper();

    @Override
    @Logged
    public void feed(Animal animal) {
        zookeeper.feed(animal);
    }

    @Override
    public void payEmployees() {
        zookeeper.receivePayment();
    }
}
