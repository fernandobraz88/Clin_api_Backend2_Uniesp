package uniesp.backendII.Clin_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniesp.backendII.Clin_api.model.Medico;
import uniesp.backendII.Clin_api.repository.MedicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository repository;

    public Medico create (Medico medico){
        return repository.save(medico);
    }

    public List<Medico> findAll(){
        return repository.findAll();
    }

    public Optional<Medico> findById(Long id){
        return repository.findById(id);
    }

    public Optional<Medico> findByCrm(String crm){
        return repository.findByCrm(crm);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
