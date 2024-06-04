package uniesp.backendII.Clin_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniesp.backendII.Clin_api.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
}
