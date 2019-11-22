package apap.tugasakhir.sikoperasi.service;

import java.util.Map;

import apap.tugasakhir.sikoperasi.rest.ResponseDetail;
import reactor.core.publisher.Mono;

public interface UserRestService {
//	public Map<String, String> getEmployee(String id);
//	public Map<String, String> getTeacher(String id);
	public Mono<ResponseDetail> getEmployee(String id);
	public Mono<ResponseDetail> getTeacher(String id);
}
