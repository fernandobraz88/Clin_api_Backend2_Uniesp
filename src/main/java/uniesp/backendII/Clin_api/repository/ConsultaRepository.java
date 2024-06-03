package uniesp.backendII.Clin_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uniesp.backendII.Clin_api.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
}
