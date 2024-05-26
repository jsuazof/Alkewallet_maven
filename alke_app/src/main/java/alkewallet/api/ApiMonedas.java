package alkewallet.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import alkewallet.model.Moneda;
import alkewallet.model.MonedaDolar;
import alkewallet.model.MonedaEuro;

public class ApiMonedas {
    private HashMap<String, Moneda> monedas = new HashMap<>();

    public ApiMonedas() {}

    public ApiMonedas(HashMap<String, Moneda> monedas) {
        this.monedas = monedas;
    }

    public void GetIndicadores(){
        try {
            URI uri = new URI("https://mindicador.cl/api");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Ocurrió un error: " + response.statusCode());
            } else {
                String jsonString = response.body();

                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
                JsonObject dolar = jsonObject.getAsJsonObject("dolar");
                JsonObject euro = jsonObject.getAsJsonObject("euro");

                double valorDolar = dolar.get("valor").getAsDouble();
                double valorEuro = euro.get("valor").getAsDouble();

                // Redondear los valores a enteros
                double valorDolarRedondeado = (double) Math.round(valorDolar);
                double valorEuroRedondeado = (double) Math.round(valorEuro);

                monedas.put(dolar.get("codigo").getAsString(), 
                        new MonedaDolar(dolar.get("codigo").getAsString(), "$", "Dolares", 
                        valorDolarRedondeado));
                monedas.put(euro.get("codigo").getAsString(), 
                        new MonedaEuro(euro.get("codigo").getAsString(), "€", "Euros", 
                        valorEuroRedondeado));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Moneda> getMonedas() {
        return monedas;
    }
}
