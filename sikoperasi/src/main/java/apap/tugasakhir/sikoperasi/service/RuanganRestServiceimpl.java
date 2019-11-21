package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.rest.Setting;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.Map;

@Service
@Transactional
public class RuanganRestServiceimpl implements RuanganRestService {
    private  final WebClient webClient;

    public RestoranRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.ruanganUrl).build();
    }

    @Override
    public String postPeminjamanRuang(Map requestBody) {
        System.out.println(requestBody);
        JSONObject jsonObject = new JSONObject(requestBody);
        String jsonReqBody = jsonObject.toString();
        System.out.println(jsonReqBody);

        return this.webClient.post()
                .uri()
    }
}
