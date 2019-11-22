package apap.tugasakhir.sikoperasi.rest;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDetail {
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("result")
	private UserDetail result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserDetail getResult() {
		return result;
	}

	public void setResult(UserDetail result) {
		this.result = result;
	}
	
}
