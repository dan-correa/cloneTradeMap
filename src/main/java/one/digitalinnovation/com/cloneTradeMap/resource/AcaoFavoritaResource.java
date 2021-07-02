package one.digitalinnovation.com.cloneTradeMap.resource;

import one.digitalinnovation.com.cloneTradeMap.service.impl.AcaoFavoritaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/acoes")
public class AcaoFavoritaResource extends ResourceBase <AcaoFavoritaDTO>{

    @Autowired
    private AcaoFavoritaService acaoFavoritaService;

    @PostMapping("/favorita")

    public ResponseEntity<AcaoFavoritaDTO> salvar(@RequestBody @Valid AcaoFavoritaDTO acaoFavoritaDTO){
        AcaoFavoritaDTO acaoFavoritaRetorno = acaoFavoritaService.salvar(acaoFavoritaDTO);
        return responderSucessoComItem(acaoFavoritaRetorno);

    }
}
