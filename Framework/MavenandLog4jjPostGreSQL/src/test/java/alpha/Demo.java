package alpha;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {

private  static Logger logger = LogManager.getLogger(Demo.class.getName());

    public static void main(String[] args) {

        logger.debug("I've clicked on the button");
        logger.info("button is displayed");
        logger.error("button is not displayed");
        logger.fatal("button is misssing");

    }
}
