package codigoqr.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbltpevento database table.
 * 
 */
@Entity
@NamedQuery(name="Tbltpevento.findAll", query="SELECT t FROM Tbltpevento t")
public class Tbltpevento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLTPEVENTO_IDTPACTIVIDAD_GENERATOR", sequenceName="TBLTPEVENTO_ID_TPACTIVIDAD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLTPEVENTO_IDTPACTIVIDAD_GENERATOR")
	@Column(name="id_tpactividad")
	private Integer idTpactividad;

	@Column(name="asignacion_tpact")
	private String asignacionTpact;

	//bi-directional many-to-one association to Tblevento
	@OneToMany(mappedBy="tbltpevento")
	private List<Tblevento> tbleventos;

	public Tbltpevento() {
	}

	public Integer getIdTpactividad() {
		return this.idTpactividad;
	}

	public void setIdTpactividad(Integer idTpactividad) {
		this.idTpactividad = idTpactividad;
	}

	public String getAsignacionTpact() {
		return this.asignacionTpact;
	}

	public void setAsignacionTpact(String asignacionTpact) {
		this.asignacionTpact = asignacionTpact;
	}

	public List<Tblevento> getTbleventos() {
		return this.tbleventos;
	}

	public void setTbleventos(List<Tblevento> tbleventos) {
		this.tbleventos = tbleventos;
	}

	public Tblevento addTblevento(Tblevento tblevento) {
		getTbleventos().add(tblevento);
		tblevento.setTbltpevento(this);

		return tblevento;
	}

	public Tblevento removeTblevento(Tblevento tblevento) {
		getTbleventos().remove(tblevento);
		tblevento.setTbltpevento(null);

		return tblevento;
	}

}