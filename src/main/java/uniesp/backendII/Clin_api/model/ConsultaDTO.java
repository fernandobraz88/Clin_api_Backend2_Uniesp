package uniesp.backendII.Clin_api.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultaDTO {
    private Long id;
    private String nomePaciente;
    private String nomeMedico;
    private String especialidadeMedico;
    private LocalDateTime dataHora;
    private String telefonePaciente;
    private String procedimento;

    public static ConsultaDTO fromConsulta(Consulta consulta) {
        ConsultaDTO dto = new ConsultaDTO();
        dto.setProcedimento(consulta.getProcedimento());
        dto.setId(consulta.getID());
        dto.setNomePaciente(consulta.getPaciente().getNome());
        dto.setNomeMedico(consulta.getMedico().getNome());
        dto.setEspecialidadeMedico(consulta.getMedico().getEspecialidade());
        dto.setDataHora(consulta.getDataHora());
        dto.setTelefonePaciente(consulta.getPaciente().getTelefone());
        return dto;
    }
}
