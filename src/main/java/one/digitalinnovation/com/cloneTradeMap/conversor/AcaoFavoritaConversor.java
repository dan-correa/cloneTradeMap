package one.digitalinnovation.com.cloneTradeMap.conversor;

import one.digitalinnovation.com.cloneTradeMap.modelo.AcaoFavorita;
import one.digitalinnovation.com.cloneTradeMap.resource.AcaoFavoritaDTO;
import one.digitalinnovation.com.cloneTradeMap.service.impl.IUsuarioService;
import one.digitalinnovation.com.cloneTradeMap.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class AcaoFavoritaConversor extends ConversorBase<AcaoFavorita, AcaoFavoritaDTO> {

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public AcaoFavoritaDTO converterEntidadeParaDto( AcaoFavorita entidade){
        return AcaoFavoritaDTO.builder().codigo(entidade.getCodigo()).build();

    }

    @Override
    public AcaoFavorita converterDtoParaEntidade(AcaoFavoritaDTO dto){
        return AcaoFavorita
                .builder()
                .codigo(dto.getCodigo())
                .usuario(usuarioService.consultarEntidade(dto.getLoginUsuario()))
                .build();
    }


}
