package am.plotnikov.bugreport1.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "google")
public interface GoogleClient {

    @GET
    @Path("/search")
    String search(@QueryParam("q") String text);

}
