package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.rest.AnggotaDetail;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface AnggotaRestService {
    Map<String, Object> getAnggotaByIdAPI(String id);
}
