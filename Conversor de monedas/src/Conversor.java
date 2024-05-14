import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    private static final String API_KEY = "ed35545b4b5a5798114aa4fc";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public double convertir(String desde, String para, double monto) {
        String direccion = BASE_URL + API_KEY + "/pair/" + desde + "/" + para + "/" + monto;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String respuesta = response.body();
            String searchStr = ",\"conversion_result\":";
            int startIndex = respuesta.indexOf(searchStr);
            if (startIndex != -1) {
                String resultadoFinal = respuesta.substring(startIndex + searchStr.length());
                resultadoFinal = resultadoFinal.substring(0, resultadoFinal.length() - 1);
                return Double.parseDouble(resultadoFinal);
            } else {
                System.out.println("No se encontró el resultado de la conversión en la respuesta.");
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Hubo un problema: " + e.getMessage());
            return 0;
        }
    }
}
