package pl.mkcode.aop.aspects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.mkcode.aop.model.Animal;
import pl.mkcode.aop.services.ZookeeperService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class FeedingAspectTest {

    @Autowired
    private ZookeeperService zookeeperService;

    @Test
    void givenLoggingAspect_whenCallLoggableAnnotatedMethod_thenMethodIsLogged() {
        zookeeperService.feed(new Animal());
    }

}