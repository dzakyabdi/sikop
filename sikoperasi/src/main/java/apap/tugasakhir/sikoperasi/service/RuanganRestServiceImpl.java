package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.rest.PeminjamanDetail;
import apap.tugasakhir.sikoperasi.rest.Setting;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.Map;

@Service
@Transactional
public class RuanganRestServiceImpl implements RuanganRestService {
    private  final WebClient webClient;

    public RuanganRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.ruanganUrl).build();
    }

    @Override
    public PeminjamanDetail postPeminjamanRuang(Map requestBody) {
        System.out.println(requestBody);
        JSONObject jsonObject = new JSONObject(requestBody);
        String jsonReqBody = jsonObject.toString();
        System.out.println(jsonReqBody);

        return this.webClient.post()
                .uri("/ruang/peminjaman")
                .syncBody(jsonReqBody)
                .retrieve()
                .bodyToMono(PeminjamanDetail.class).block();
    }
}
