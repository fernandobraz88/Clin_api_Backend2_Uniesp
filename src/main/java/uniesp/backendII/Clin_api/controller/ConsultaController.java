package uniesp.backendII.Clin_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniesp.backendII.Clin_api.model.dtos.ConsultaDTO;
import uniesp.backendII.Clin_api.service.ConsultaService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ConsultaDTO> create(@RequestParam Long medicoId,
                                              @RequestParam Long pacienteId,
                                              @RequestParam String dataHoraConsulta){
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraConsulta);
        ConsultaDTO consultaDTO = consultaService.create(medicoId, pacienteId, dataHora);
        return ResponseEntity.ok(consultaDTO);
    }
    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> findAll() {
        List<ConsultaDTO> consultas = consultaService.findAll();
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> findById(@PathVariable Long id) {
        ConsultaDTO consultaDTO = consultaService.findById(id);
        return ResponseEntity.ok(consultaDTO);
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<ConsultaDTO>> findByPacienteId(@PathVariable Long pacienteId) {
        List<ConsultaDTO> consultas = consultaService.findByPacienteId(pacienteId);
        return ResponseEntity.ok(consultas);
    }

}


