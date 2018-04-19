package codigoqr.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbloperador database table.
 * 
 */
@Entity
@NamedQuery(name="Tbloperador.findAll", query="SELECT t FROM Tbloperador t")
public class Tbloperador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLOPERADOR_IDOPERADOR_GENERATOR", sequenceName="TBLOPERADOR_ID_OPERADOR_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLOPERADOR_IDOPERADOR_GENERATOR")
	@Column(name="id_operador")
	private Integer idOperador;

	private Boolean confirmado;

	//bi-directional many-to-one association to Tblevento
	@ManyToOne
	@JoinColumn(name="id_evnt")
	private Tblevento tblevento;

	//bi-directional many-to-one association to Tblusuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Tblusuario tblusuario;

	public Tbloperador() {
	}

	public Integer getIdOperador() {
		return this.idOperador;
	}

	public void setIdOperador(Integer idOperador) {
		this.idOperador = idOperador;
	}

	public Boolean getConfirmado() {
		return this.confirmado;
	}

	public void setConfirmado(Boolean confirmado) {
		this.confirmado = confirmado;
	}

	public Tblevento getTblevento() {
		return this.tblevento;
	}

	public void setTblevento(Tblevento tblevento) {
		this.tblevento = tblevento;
	}

	public Tblusuario getTblusuario() {
		return this.tblusuario;
	}

	public void setTblusuario(Tblusuario tblusuario) {
		this.tblusuario = tblusuario;
	}

}