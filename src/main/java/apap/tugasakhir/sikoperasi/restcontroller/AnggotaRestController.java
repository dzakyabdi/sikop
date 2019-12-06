package apap.tugasakhir.sikoperasi.restcontroller;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.rest.AnggotaDetail;
import apap.tugasakhir.sikoperasi.service.AnggotaRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class AnggotaRestController {
    @Autowired
    private AnggotaRestService anggotaRestService;

    @GetMapping(value = "/anggotaKoperasi/{id}")
    private Map<String, Object> getAnggotaAPI(@PathVariable("id") String id){
        try{
            return anggotaRestService.getAnggotaByIdAPI(id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"ID Anggota "+String.valueOf(id)+" Not Found"
            );
        }
    }
}
