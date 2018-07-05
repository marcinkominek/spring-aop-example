package pl.mkcode.aop.aspects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.mkcode.aop.model.Animal;
import pl.mkcode.aop.nontestable.CaptureSystemOutput;
import pl.mkcode.aop.services.ZooService;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.stringContainsInOrder;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@CaptureSystemOutput
class LogExecutionTimeAspectTest {

    @Autowired
    private ZooService zooService;

    @Test
    void testMethodNotLogged(CaptureSystemOutput.OutputCapture outputCapture) {
        zooService.payEmployees();

        outputCapture.expect(containsString("payment received"));
        outputCapture.expect(not(containsString("before Logged")));
        outputCapture.expect(not(containsString("after Logged")));
    }

    @Test
    void testBeforeAndAfterAnnotations(CaptureSystemOutput.OutputCapture outputCapture) {
        zooService.feed(new Animal());

        outputCapture.expect(stringContainsInOrder(asList("before Logged", "feeding", "after Logged")));
    }

    @Test
    void testBeforeAndAfterAnnotations(CaptureSystemOutput.OutputCapture outputCapture) {
        zooService.feed(new Animal());

        outputCapture.expect(stringContainsInOrder(asList("before Logged", "feeding", "after Logged")));
    }
}