package codigoqr.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblinstitucion database table.
 * 
 */
@Entity
@NamedQuery(name="Tblinstitucion.findAll", query="SELECT t FROM Tblinstitucion t")
public class Tblinstitucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLINSTITUCION_IDINSTITUCION_GENERATOR", sequenceName="TBLINSTITUCION_ID_INSTITUCION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLINSTITUCION_IDINSTITUCION_GENERATOR")
	@Column(name="id_institucion")
	private Integer idInstitucion;

	@Column(name="nombre_institucion")
	private String nombreInstitucion;

	//bi-directional many-to-one association to Tblasistente
	@OneToMany(mappedBy="tblinstitucion")
	private List<Tblasistente> tblasistentes;

	public Tblinstitucion() {
	}

	public Integer getIdInstitucion() {
		return this.idInstitucion;
	}

	public void setIdInstitucion(Integer idInstitucion) {
		this.idInstitucion = idInstitucion;
	}

	public String getNombreInstitucion() {
		return this.nombreInstitucion;
	}

	public void setNombreInstitucion(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
	}

	public List<Tblasistente> getTblasistentes() {
		return this.tblasistentes;
	}

	public void setTblasistentes(List<Tblasistente> tblasistentes) {
		this.tblasistentes = tblasistentes;
	}

	public Tblasistente addTblasistente(Tblasistente tblasistente) {
		getTblasistentes().add(tblasistente);
		tblasistente.setTblinstitucion(this);

		return tblasistente;
	}

	public Tblasistente removeTblasistente(Tblasistente tblasistente) {
		getTblasistentes().remove(tblasistente);
		tblasistente.setTblinstitucion(null);

		return tblasistente;
	}

}