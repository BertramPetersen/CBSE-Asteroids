package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.services.ICollideable;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Asteroid extends Entity implements ICollideable {
    private static final URI addScoreURL = URI.create("http://localhost:8080/score/increment");
    @Override
    public void onCollision() {
        try {
            URL url = addScoreURL.toURL();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url.toURI())
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Updated Score to: "+ response.body());
        } catch (Exception e) {
            System.out.println("Failed to update score");
        }
    }
}
