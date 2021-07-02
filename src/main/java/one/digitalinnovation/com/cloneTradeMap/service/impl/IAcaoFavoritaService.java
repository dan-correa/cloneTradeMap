package one.digitalinnovation.com.cloneTradeMap.service.impl;

import one.digitalinnovation.com.cloneTradeMap.modelo.AcaoFavorita;
import one.digitalinnovation.com.cloneTradeMap.modelo.Usuario;
import one.digitalinnovation.com.cloneTradeMap.resource.AcaoFavoritaDTO;

import java.util.List;

public interface IAcaoFavoritaService {

    AcaoFavorita salvar(AcaoFavorita acaoFavorita);

    AcaoFavoritaDTO salvar(AcaoFavoritaDTO acaoFavoritaDTO);

    List<AcaoFavorita> listar(Usuario usuario);

    List<AcaoFavorita> listarSemDuplicidade();
}