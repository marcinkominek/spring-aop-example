package pl.mkcode.aop.model;

import java.util.logging.Logger;

public class Zookeeper {

    private static Logger logger = Logger.getLogger(Zookeeper.class.getName());

    public void feed(Animal animal) {
        logger.info("feeding animal");
    }

    public void receivePayment() {
        logger.info("payment received");
    }
}
