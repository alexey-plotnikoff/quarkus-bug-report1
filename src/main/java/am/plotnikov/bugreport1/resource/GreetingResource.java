package am.plotnikov.bugreport1.resource;

import am.plotnikov.bugreport1.service.KafkaService;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
public class GreetingResource {

    private static final Logger log = LoggerFactory.getLogger(GreetingResource.class);

    private final KafkaService kafkaService;

    public GreetingResource(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RunOnVirtualThread
    public String hello() {
        log.info("HTTP started");
        kafkaService.runAction("hello");
        log.info("HTTP finished");
        return "success";
    }
}
