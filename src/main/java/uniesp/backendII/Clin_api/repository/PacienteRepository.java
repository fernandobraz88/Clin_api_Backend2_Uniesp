package uniesp.backendII.Clin_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniesp.backendII.Clin_api.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
