package apap.tugasakhir.sikoperasi.service;

import java.util.Map;

import apap.tugasakhir.sikoperasi.rest.ResponseDetail;
import reactor.core.publisher.Mono;

public interface UserRestService {
	public Mono<ResponseDetail> getEmployee(String id);
	public Mono<ResponseDetail> getTeacher(String id);
}
