package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.JenisSimpananModel;
import apap.tugasakhir.sikoperasi.repository.JenisSimpananDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JenisSimpananServiceImpl implements JenisSimpananService {

    @Autowired
    private JenisSimpananDB jenisSimpananDB;

    @Override
    public List<JenisSimpananModel> getAllJenisSimpanan() {
        return jenisSimpananDB.findAll();
    }
}
