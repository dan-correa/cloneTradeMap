package one.digitalinnovation.com.cloneTradeMap.resource;

import one.digitalinnovation.com.cloneTradeMap.dto.UsuarioDTO;
import one.digitalinnovation.com.cloneTradeMap.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource extends ResourceBase<UsuarioDTO> {

    @Autowired
    private UsuarioService usuarioService;

    public ResponseEntity<UsuarioDTO>consultar(@PathVariable String login){
        UsuarioDTO usuario = usuarioService.consultar(login);
        if (usuario == null) {
            return responderItemNaoEncontrado();
        }
        return responderSucessoComItem(usuario);
    }
}
