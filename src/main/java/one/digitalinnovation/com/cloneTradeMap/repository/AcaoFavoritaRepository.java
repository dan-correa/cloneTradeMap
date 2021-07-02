package one.digitalinnovation.com.cloneTradeMap.repository;

import one.digitalinnovation.com.cloneTradeMap.modelo.AcaoFavorita;
import one.digitalinnovation.com.cloneTradeMap.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcaoFavoritaRepository extends JpaRepository<AcaoFavorita, Long > {


    AcaoFavorita findByCodigoAndUsuario(String codigo, Usuario usuario);

    List <AcaoFavorita>findByUsuario(Usuario usuario);
}
