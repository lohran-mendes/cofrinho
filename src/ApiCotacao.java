import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ApiCotacao {

    public double getCotacao(Principal.tipoMoedaEnum tipoMoeda) {
        double cotacaoDaMoedaBuscada = 0;
        String  moedaBuscada = switch (tipoMoeda) {
            case DOLAR -> "USD";
            case EURO -> "EUR";
            default -> "";
        };
        try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://economia.awesomeapi.com.br/json/last/" + moedaBuscada))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, RetornoApi>>() {}.getType();
            Map<String, RetornoApi> retorno = gson.fromJson(json, type);

            if (!retorno.isEmpty()) {
                RetornoApi moeda = retorno.values().iterator().next();
                return cotacaoDaMoedaBuscada = moeda.bid;
            } else {
                System.out.println("Erro: Nenhuma cotação encontrada.");
            }


    } catch (Exception e) {
        System.out.println(e);
    }
        return cotacaoDaMoedaBuscada;
    }
}
