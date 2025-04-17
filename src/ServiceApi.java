import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServiceApi {

    public Moneda conversorBuscar(double valor, String monedaInicial,String monedaFinal) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/25549a61f9e7f9e26645a772/pair/"+monedaInicial+"/"+monedaFinal+"/"+valor);


        HttpClient client = HttpClient.newHttpClient();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .GET()
                .build();

        try {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);



        } catch (Exception e) {
            // Manejo de errores con mensaje descriptivo
            throw new RuntimeException("Error al consultar el API de conversión de divisas", e);
        }
    }
}
