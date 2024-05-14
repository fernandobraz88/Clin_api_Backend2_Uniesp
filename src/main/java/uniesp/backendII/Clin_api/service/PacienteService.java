package uniesp.backendII.Clin_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniesp.backendII.Clin_api.model.Medico;
import uniesp.backendII.Clin_api.model.Paciente;
import uniesp.backendII.Clin_api.repository.PacienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;

    public Paciente create (Paciente paciente){
        return repository.save(paciente);
    }

    public List<Paciente> findAll(){
        return repository.findAll();
    }

    public Optional<Paciente> findById(Long id){
        return repository.findById(id);
    }

    public Optional<Paciente> findByCpf(String cpf){
        return repository.findByCpf(cpf);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
