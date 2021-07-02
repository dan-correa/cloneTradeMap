package one.digitalinnovation.com.cloneTradeMap.repository;

import one.digitalinnovation.com.cloneTradeMap.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);
}
