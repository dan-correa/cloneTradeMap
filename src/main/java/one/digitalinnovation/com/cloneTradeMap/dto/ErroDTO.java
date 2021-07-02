package one.digitalinnovation.com.cloneTradeMap.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ErroDTO {


    private String campo;
    private String mensagem;
}
