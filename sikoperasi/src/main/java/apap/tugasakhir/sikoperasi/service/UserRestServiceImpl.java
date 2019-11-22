package apap.tugasakhir.sikoperasi.service;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import apap.tugasakhir.sikoperasi.rest.ResponseDetail;
import apap.tugasakhir.sikoperasi.rest.Setting;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class UserRestServiceImpl implements UserRestService{
	private final WebClient webClient;
	
	public UserRestServiceImpl(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl(Setting.sivitasUrl).build();
	}	
	
	@Override
	public Mono<ResponseDetail> getEmployee(String id){
		return this.webClient.get().uri("/employees/" + id).retrieve().bodyToMono(ResponseDetail.class);
	}
	
	@Override
	public Mono<ResponseDetail> getTeacher(String id){
		return this.webClient.get().uri("/teachers/" + id).retrieve().bodyToMono(ResponseDetail.class);
	}
}
