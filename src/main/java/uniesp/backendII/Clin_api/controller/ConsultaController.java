package uniesp.backendII.Clin_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniesp.backendII.Clin_api.model.Consulta;
import uniesp.backendII.Clin_api.model.ConsultaDTO;
import uniesp.backendII.Clin_api.service.ConsultaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<ConsultaDTO> create(@RequestBody Consulta consulta) {
        Consulta novaConsulta = service.create(consulta);
        ConsultaDTO consultaDTO = ConsultaDTO.fromConsulta(novaConsulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaDTO);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ConsultaDTO>> findAll() {
        List<Consulta> consultas = service.findAll();
        List<ConsultaDTO> consultaDTOs = consultas.stream()
                .map(ConsultaDTO::fromConsulta)
                .collect(Collectors.toList());
        return ResponseEntity.ok(consultaDTOs);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
