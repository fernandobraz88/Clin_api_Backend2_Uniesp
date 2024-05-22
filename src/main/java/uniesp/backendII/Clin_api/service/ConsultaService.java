package uniesp.backendII.Clin_api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniesp.backendII.Clin_api.model.Consulta;
import uniesp.backendII.Clin_api.model.Medico;
import uniesp.backendII.Clin_api.model.Paciente;
import uniesp.backendII.Clin_api.model.dtos.ConsultaDTO;
import uniesp.backendII.Clin_api.repository.ConsultaRepository;
import uniesp.backendII.Clin_api.repository.MedicoRepository;
import uniesp.backendII.Clin_api.repository.PacienteRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public ConsultaDTO create(Long medicoId, Long pacienteId, LocalDateTime dataHoraConsulta) {
        Optional<Medico> medicoOpt = medicoRepository.findById(medicoId);
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(pacienteId);

        if (medicoOpt.isPresent() && pacienteOpt.isPresent()) {
            Medico medico = medicoOpt.get();
            Paciente paciente = pacienteOpt.get();

            Consulta consulta = new Consulta();
            consulta.setMedico(medico);
            consulta.setPaciente(paciente);
            consulta.setDataHoraConsulta(dataHoraConsulta);

            consulta = consultaRepository.save(consulta);

            return convertToDTO(consulta);
        } else {
            throw new RuntimeException("Medico ou Paciente não encontrado");
        }
    }

    public List<ConsultaDTO> findAll() {
        List<Consulta> consultas = consultaRepository.findAll();
        return consultas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ConsultaDTO findById(Long id) {
        Optional<Consulta> consultaOpt = consultaRepository.findById(id);
        if (consultaOpt.isPresent()) {
            return convertToDTO(consultaOpt.get());
        } else {
            throw new RuntimeException("Consulta não encontrada");
        }
    }

    public List<ConsultaDTO> findByPacienteId(Long pacienteId) {
        List<Consulta> consultas = consultaRepository.findByPacienteId(pacienteId);
        return consultas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ConsultaDTO convertToDTO(Consulta consulta) {
        return new ConsultaDTO(
                consulta.getMedico().getNome(),
                consulta.getMedico().getCrm(),
                consulta.getMedico().getEspecialidade(),
                consulta.getPaciente().getNome(),
                consulta.getPaciente().getCpf(),
                consulta.getPaciente().getTelefone(),
                consulta.getDataHoraConsulta()
        );
    }
}