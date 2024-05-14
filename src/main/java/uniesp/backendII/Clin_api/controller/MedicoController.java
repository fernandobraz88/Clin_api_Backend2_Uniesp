package uniesp.backendII.Clin_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniesp.backendII.Clin_api.model.Medico;
import uniesp.backendII.Clin_api.service.MedicoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    MedicoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Medico> create(@RequestBody Medico medico){

        Medico medicoCreated = service.create(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoCreated);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Medico> findAll() {
        return service.findAll();
    }

    @GetMapping("/id={id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Medico> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("crm={crm}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Medico> findByCrm(@PathVariable String crm){
        return service.findByCrm(crm);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
