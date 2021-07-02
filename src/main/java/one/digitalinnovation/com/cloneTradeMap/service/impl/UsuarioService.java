package one.digitalinnovation.com.cloneTradeMap.service.impl;

import one.digitalinnovation.com.cloneTradeMap.conversor.UsuarioConversor;
import one.digitalinnovation.com.cloneTradeMap.dto.UsuarioDTO;
import one.digitalinnovation.com.cloneTradeMap.modelo.AcaoFavorita;
import one.digitalinnovation.com.cloneTradeMap.modelo.Usuario;
import one.digitalinnovation.com.cloneTradeMap.repository.AcaoFavoritaRepository;
import one.digitalinnovation.com.cloneTradeMap.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.digitalinnovation.com.cloneTradeMap.service.impl.IAcaoFavoritaService;
import one.digitalinnovation.com.cloneTradeMap.service.impl.IUsuarioService;


import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private IAcaoFavoritaService acaoFavoritaService;

    @Autowired
    private UsuarioConversor usuarioConversor;

    @Override
    public UsuarioDTO consultar(String login) {
        Usuario usuario = consultarEntidade(login);
        if (usuario != null) {
            List<AcaoFavorita> acoes = acaoFavoritaService.listar(usuario);
            return usuarioConversor.converterEntidadeParaDto(usuario, acoes);
        }

        return null;
    }

    @Override
    public Usuario consultarEntidade(String login) {
        return usuarioRepository.findByLogin(login);
    }

}
