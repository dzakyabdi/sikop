package apap.tugasakhir.sikoperasi.service;

import java.util.Map;

public interface UserRestService {
	public Map<String, String> getEmployee(Long id);
	public Map<String, String> getTeacher(Long id);
}
