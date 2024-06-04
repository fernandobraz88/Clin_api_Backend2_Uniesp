package uniesp.backendII.Clin_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniesp.backendII.Clin_api.model.Consulta;
import uniesp.backendII.Clin_api.repository.ConsultaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    public Consulta create (Consulta consulta){
        return repository.save(consulta);
    }

    public List<Consulta> findAll(){
        return repository.findAll();
    }

    public Optional<Consulta> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
