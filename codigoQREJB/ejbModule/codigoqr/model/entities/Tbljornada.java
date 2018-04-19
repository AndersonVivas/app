package codigoqr.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbljornadas database table.
 * 
 */
@Entity
@Table(name="tbljornadas")
@NamedQuery(name="Tbljornada.findAll", query="SELECT t FROM Tbljornada t")
public class Tbljornada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_jornada")
	private Integer idJornada;

	@Column(name="descripcion_jornada")
	private String descripcionJornada;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_jornada")
	private Date fechaJornada;

	@Column(name="lugar_jornada")
	private String lugarJornada;

	//bi-directional many-to-one association to Tblhorario
	@OneToMany(mappedBy="tbljornada", cascade=CascadeType.ALL)
	private List<Tblhorario> tblhorarios;

	//bi-directional many-to-one association to Tblevento
	@ManyToOne
	@JoinColumn(name="id_evnt")
	private Tblevento tblevento;

	public Tbljornada() {
	}

	public Integer getIdJornada() {
		return this.idJornada;
	}

	public void setIdJornada(Integer idJornada) {
		this.idJornada = idJornada;
	}

	public String getDescripcionJornada() {
		return this.descripcionJornada;
	}

	public void setDescripcionJornada(String descripcionJornada) {
		this.descripcionJornada = descripcionJornada;
	}

	public Date getFechaJornada() {
		return this.fechaJornada;
	}

	public void setFechaJornada(Date fechaJornada) {
		this.fechaJornada = fechaJornada;
	}

	public String getLugarJornada() {
		return this.lugarJornada;
	}

	public void setLugarJornada(String lugarJornada) {
		this.lugarJornada = lugarJornada;
	}

	public List<Tblhorario> getTblhorarios() {
		return this.tblhorarios;
	}

	public void setTblhorarios(List<Tblhorario> tblhorarios) {
		this.tblhorarios = tblhorarios;
	}

	public Tblhorario addTblhorario(Tblhorario tblhorario) {
		getTblhorarios().add(tblhorario);
		tblhorario.setTbljornada(this);

		return tblhorario;
	}

	public Tblhorario removeTblhorario(Tblhorario tblhorario) {
		getTblhorarios().remove(tblhorario);
		tblhorario.setTbljornada(null);

		return tblhorario;
	}

	public Tblevento getTblevento() {
		return this.tblevento;
	}

	public void setTblevento(Tblevento tblevento) {
		this.tblevento = tblevento;
	}

}