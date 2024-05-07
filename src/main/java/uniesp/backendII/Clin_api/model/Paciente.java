package uniesp.backendII.Clin_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paciente {

    @Id
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
}
