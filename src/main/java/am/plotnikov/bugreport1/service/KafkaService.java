package am.plotnikov.bugreport1.service;

import am.plotnikov.bugreport1.client.GoogleClient;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class KafkaService {

    private static final Logger log = LoggerFactory.getLogger(KafkaService.class);

    private final GoogleClient client;
    private final Emitter<String> stringEmitter;

    public KafkaService(
            @RestClient GoogleClient client,
            @Channel("in-memory-google")
            Emitter<String> stringEmitter
    ) {
        this.client = client;
        this.stringEmitter = stringEmitter;
    }

    public void runAction(String text) {
        stringEmitter.send(text);
    }

    @Incoming("in-memory-google")
    @RunOnVirtualThread
    public void processMessage(String text) {
        try {
            log.info("HTTP Client Request started");
//            clientMap.get("GOOGLE").search(text);
            client.search(text);
            log.info("HTTP Client Request finished");
        } catch (Exception e) {
            log.error("Error", e);
        }
    }

}
