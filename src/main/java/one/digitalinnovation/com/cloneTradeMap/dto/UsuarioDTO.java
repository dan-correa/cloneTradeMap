package one.digitalinnovation.com.cloneTradeMap.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import one.digitalinnovation.com.cloneTradeMap.resource.AcaoFavoritaDTO;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {

    private String login;
    private String senha;
    private String email;
    private String nome;
    private List<AcaoFavoritaDTO> acoesFavoritas;
    private Boolean ativo;

}
