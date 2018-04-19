package codigoqr.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tbleventos database table.
 * 
 */
@Entity
@Table(name="tbleventos")
@NamedQuery(name="Tblevento.findAll", query="SELECT t FROM Tblevento t")
public class Tblevento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_evnt")
	private Integer idEvnt;

	@Column(name="descripcion_evnt")
	private String descripcionEvnt;

	@Column(name="direccion_evnt")
	private String direccionEvnt;

	@Column(name="fecha_fin_evnt")
	private Timestamp fechaFinEvnt;

	@Column(name="fecha_inicio_evnt")
	private Timestamp fechaInicioEvnt;

	@Column(name="nombre_evnt")
	private String nombreEvnt;

	private Boolean publicado;

	//bi-directional many-to-one association to Tbltpevento
	@ManyToOne
	@JoinColumn(name="id_tpactividad")
	private Tbltpevento tbltpevento;

	//bi-directional many-to-one association to Tblusuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Tblusuario tblusuario;

	//bi-directional many-to-one association to Tbljornada
	@OneToMany(mappedBy="tblevento", cascade=CascadeType.ALL)
	private List<Tbljornada> tbljornadas;

	//bi-directional many-to-one association to Tbloperador
	@OneToMany(mappedBy="tblevento", cascade=CascadeType.ALL)
	private List<Tbloperador> tbloperadors;

	public Tblevento() {
	}

	public Integer getIdEvnt() {
		return this.idEvnt;
	}

	public void setIdEvnt(Integer idEvnt) {
		this.idEvnt = idEvnt;
	}

	public String getDescripcionEvnt() {
		return this.descripcionEvnt;
	}

	public void setDescripcionEvnt(String descripcionEvnt) {
		this.descripcionEvnt = descripcionEvnt;
	}

	public String getDireccionEvnt() {
		return this.direccionEvnt;
	}

	public void setDireccionEvnt(String direccionEvnt) {
		this.direccionEvnt = direccionEvnt;
	}

	public Timestamp getFechaFinEvnt() {
		return this.fechaFinEvnt;
	}

	public void setFechaFinEvnt(Timestamp fechaFinEvnt) {
		this.fechaFinEvnt = fechaFinEvnt;
	}

	public Timestamp getFechaInicioEvnt() {
		return this.fechaInicioEvnt;
	}

	public void setFechaInicioEvnt(Timestamp fechaInicioEvnt) {
		this.fechaInicioEvnt = fechaInicioEvnt;
	}

	public String getNombreEvnt() {
		return this.nombreEvnt;
	}

	public void setNombreEvnt(String nombreEvnt) {
		this.nombreEvnt = nombreEvnt;
	}

	public Boolean getPublicado() {
		return this.publicado;
	}

	public void setPublicado(Boolean publicado) {
		this.publicado = publicado;
	}

	public Tbltpevento getTbltpevento() {
		return this.tbltpevento;
	}

	public void setTbltpevento(Tbltpevento tbltpevento) {
		this.tbltpevento = tbltpevento;
	}

	public Tblusuario getTblusuario() {
		return this.tblusuario;
	}

	public void setTblusuario(Tblusuario tblusuario) {
		this.tblusuario = tblusuario;
	}

	public List<Tbljornada> getTbljornadas() {
		return this.tbljornadas;
	}

	public void setTbljornadas(List<Tbljornada> tbljornadas) {
		this.tbljornadas = tbljornadas;
	}

	public Tbljornada addTbljornada(Tbljornada tbljornada) {
		getTbljornadas().add(tbljornada);
		tbljornada.setTblevento(this);

		return tbljornada;
	}

	public Tbljornada removeTbljornada(Tbljornada tbljornada) {
		getTbljornadas().remove(tbljornada);
		tbljornada.setTblevento(null);

		return tbljornada;
	}

	public List<Tbloperador> getTbloperadors() {
		return this.tbloperadors;
	}

	public void setTbloperadors(List<Tbloperador> tbloperadors) {
		this.tbloperadors = tbloperadors;
	}

	public Tbloperador addTbloperador(Tbloperador tbloperador) {
		getTbloperadors().add(tbloperador);
		tbloperador.setTblevento(this);

		return tbloperador;
	}

	public Tbloperador removeTbloperador(Tbloperador tbloperador) {
		getTbloperadors().remove(tbloperador);
		tbloperador.setTblevento(null);

		return tbloperador;
	}

}