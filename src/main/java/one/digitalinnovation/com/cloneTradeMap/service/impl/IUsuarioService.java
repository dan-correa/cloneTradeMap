package one.digitalinnovation.com.cloneTradeMap.service.impl;

import one.digitalinnovation.com.cloneTradeMap.dto.UsuarioDTO;
import one.digitalinnovation.com.cloneTradeMap.modelo.AcaoFavorita;
import one.digitalinnovation.com.cloneTradeMap.modelo.Usuario;
import one.digitalinnovation.com.cloneTradeMap.resource.AcaoFavoritaDTO;

import java.util.List;

public interface IUsuarioService {

    UsuarioDTO consultar(String login);

    Usuario consultarEntidade(String login);
}
