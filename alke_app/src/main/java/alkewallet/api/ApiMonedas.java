package alkewallet.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import alkewallet.model.Moneda;
import alkewallet.model.MonedaDolar;
import alkewallet.model.MonedaEuro;

public class ApiMonedas {
    private HashMap<String, Moneda> monedas=new HashMap<>();

    public ApiMonedas() {}

    public ApiMonedas(HashMap<String, Moneda> monedas) {
        this.monedas = monedas;
    }

    public void GetIndicadores(){
        try{
            @SuppressWarnings("deprecation")
            URL url = new URL("https://mindicador.cl/api");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            int codRespuesta = connection.getResponseCode();

            if(codRespuesta != 200){
                throw new RuntimeException("ocurrio un error" + codRespuesta);
            }else{
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while((inputLine = in.readLine()) != null){
                    response.append(inputLine);
                }
                in.close();

                String jsonString = response.toString();

                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
                JsonObject dolar = jsonObject.getAsJsonObject("dolar");
                JsonObject euro = jsonObject.getAsJsonObject("euro");
                monedas.put(dolar.get("codigo").getAsString(), 
                new MonedaDolar(dolar.get("codigo").getAsString(),"$", "Dolares",
                dolar.get("valor").getAsDouble()));
                monedas.put(euro.get("codigo").getAsString(), 
                new MonedaEuro(euro.get("codigo").getAsString(),"€", "Euros",
                euro.get("valor").getAsDouble()));
                

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public HashMap<String, Moneda> getMonedas() {
        return monedas;
    }
    
}
