package one.digitalinnovation.com.cloneTradeMap.service.impl;

import lombok.SneakyThrows;
import one.digitalinnovation.com.cloneTradeMap.conversor.AcaoFavoritaConversor;
import one.digitalinnovation.com.cloneTradeMap.exception.NegocioException;
import one.digitalinnovation.com.cloneTradeMap.modelo.AcaoFavorita;
import one.digitalinnovation.com.cloneTradeMap.modelo.Usuario;
import one.digitalinnovation.com.cloneTradeMap.repository.AcaoFavoritaRepository;
import one.digitalinnovation.com.cloneTradeMap.resource.AcaoFavoritaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcaoFavoritaService implements IAcaoFavoritaService {

    @Autowired
    private AcaoFavoritaRepository acaoFavoritaRepository;

    @Autowired
    private AcaoFavoritaConversor acaoFavoritaConversor;

    @Override
    public AcaoFavorita salvar(AcaoFavorita acaoFavorita) {
        return acaoFavoritaRepository.save(acaoFavorita);
    }

    @Override
    public List<AcaoFavorita> listar(Usuario usuario) {
        List<AcaoFavorita> acoes = new ArrayList<>();

        if (usuario != null) {
            acoes = acaoFavoritaRepository.findByUsuario(usuario);
        }

        return acoes;
    }

    @Override
    public List<AcaoFavorita> listarSemDuplicidade() {
        return acaoFavoritaRepository.findAll().stream().distinct().collect(Collectors.toList());
    }

    @Override
    public AcaoFavoritaDTO salvar(AcaoFavoritaDTO acaoFavoritaDTO) {
        AcaoFavorita acaoFavorita = acaoFavoritaConversor.converterDtoParaEntidade(acaoFavoritaDTO);
        validar(acaoFavorita);
        AcaoFavorita acaoSalva = acaoFavoritaRepository.save(acaoFavorita);
        return acaoFavoritaConversor.converterEntidadeParaDto(acaoSalva);
    }


    private void validar(AcaoFavorita acaoFavorita)  {
        AcaoFavorita acao = consultar(acaoFavorita);

        if (acao != null) {
            throw new NegocioException("A ação já está cadastrada para este usuário");
        }

    }

    private AcaoFavorita consultar(AcaoFavorita acaoFavorita) {
        return acaoFavoritaRepository.findByCodigoAndUsuario(acaoFavorita.getCodigo(), acaoFavorita.getUsuario());
    }

}
