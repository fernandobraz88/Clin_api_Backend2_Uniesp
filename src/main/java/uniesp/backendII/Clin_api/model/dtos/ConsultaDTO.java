package uniesp.backendII.Clin_api.model.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaDTO {
    private String nomeMedico;
    private String crmMedico;
    private String especialidadeMedico;
    private String nomePaciente;
    private String cpfPaciente;
    private String telefonePaciente;
    private LocalDateTime dataHoraConsulta;
}
