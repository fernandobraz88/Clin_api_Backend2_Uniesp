package uniesp.backendII.Clin_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniesp.backendII.Clin_api.model.Paciente;
import uniesp.backendII.Clin_api.service.PacienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Paciente> create(@RequestBody Paciente paciente) {

        Paciente pacienteCreated = service.create(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteCreated);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Paciente> findAll() {
        return service.findAll();
    }

    @GetMapping("/id={id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Paciente> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/cpf={cpf}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Paciente> findByCpf(@PathVariable String cpf) {
        return service.findByCpf(cpf);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}