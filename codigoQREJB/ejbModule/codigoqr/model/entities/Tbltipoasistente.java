package codigoqr.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbltipoasistente database table.
 * 
 */
@Entity
@NamedQuery(name="Tbltipoasistente.findAll", query="SELECT t FROM Tbltipoasistente t")
public class Tbltipoasistente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLTIPOASISTENTE_IDTIPOASISTENTE_GENERATOR", sequenceName="TBLTIPOASISTENTE_ID_TIPOASISTENTE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLTIPOASISTENTE_IDTIPOASISTENTE_GENERATOR")
	@Column(name="id_tipoasistente")
	private Integer idTipoasistente;

	@Column(name="asignacion_asistente")
	private String asignacionAsistente;

	//bi-directional many-to-one association to Tblasistente
	@OneToMany(mappedBy="tbltipoasistente")
	private List<Tblasistente> tblasistentes;

	public Tbltipoasistente() {
	}

	public Integer getIdTipoasistente() {
		return this.idTipoasistente;
	}

	public void setIdTipoasistente(Integer idTipoasistente) {
		this.idTipoasistente = idTipoasistente;
	}

	public String getAsignacionAsistente() {
		return this.asignacionAsistente;
	}

	public void setAsignacionAsistente(String asignacionAsistente) {
		this.asignacionAsistente = asignacionAsistente;
	}

	public List<Tblasistente> getTblasistentes() {
		return this.tblasistentes;
	}

	public void setTblasistentes(List<Tblasistente> tblasistentes) {
		this.tblasistentes = tblasistentes;
	}

	public Tblasistente addTblasistente(Tblasistente tblasistente) {
		getTblasistentes().add(tblasistente);
		tblasistente.setTbltipoasistente(this);

		return tblasistente;
	}

	public Tblasistente removeTblasistente(Tblasistente tblasistente) {
		getTblasistentes().remove(tblasistente);
		tblasistente.setTbltipoasistente(null);

		return tblasistente;
	}

}