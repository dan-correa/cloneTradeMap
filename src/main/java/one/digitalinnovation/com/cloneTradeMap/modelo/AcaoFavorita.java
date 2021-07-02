package one.digitalinnovation.com.cloneTradeMap.modelo;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, exclude={"usuario"})
@Entity
@Table(name = "ACOES_FAVORITAS")
public class AcaoFavorita extends EntidadeBase {

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "AF_USUARIO_ID", nullable = false)
	private Usuario usuario;

	@Column(name = "AF_CODIGO", nullable = false)
	private String codigo;

}
