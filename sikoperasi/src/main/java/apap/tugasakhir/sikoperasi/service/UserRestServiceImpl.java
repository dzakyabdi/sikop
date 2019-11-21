package apap.tugasakhir.sikoperasi.service;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import apap.tugasakhir.sikoperasi.rest.Setting;

@Service
@Transactional
public class UserRestServiceImpl implements UserRestService{
	private final WebClient webClient;
	
	public UserRestServiceImpl(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl(Setting.sivitasUrl).build();
	}	
	
	@Override
	public Map<String, String> getEmployee(Long id){
		return this.webClient.get().uri("employees/" + id)
				.retrieve().bodyToMono(Map.class).block();
	}
	
	@Override
	public Map<String, String> getTeacher(Long id){
		return this.webClient.get().uri("teachers/" + id)
				.retrieve().bodyToMono(Map.class).block();
	}
}
