package one.digitalinnovation.com.cloneTradeMap.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@JsonInclude(Include.NON_NULL)

public class AcaoFavoritaDTO {

    @NotBlank
    private String loginUsuario;
    @NotBlank
    private String codigo;


}
