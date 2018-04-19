package codigoqr.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tblasistencia database table.
 * 
 */
@Entity
@NamedQuery(name="Tblasistencia.findAll", query="SELECT t FROM Tblasistencia t")
public class Tblasistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLASISTENCIA_IDASISTENCIA_GENERATOR", sequenceName="TBLASISTENCIA_ID_ASISTENCIA_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLASISTENCIA_IDASISTENCIA_GENERATOR")
	@Column(name="id_asistencia")
	private Integer idAsistencia;

	@Column(name="fecha_registro")
	private Timestamp fechaRegistro;

	//bi-directional many-to-one association to Tblasistente
	@ManyToOne
	@JoinColumn(name="cedula_asistente")
	private Tblasistente tblasistente;

	//bi-directional many-to-one association to Tblhorario
	@ManyToOne
	@JoinColumn(name="id_horario")
	private Tblhorario tblhorario;

	public Tblasistencia() {
	}

	public Integer getIdAsistencia() {
		return this.idAsistencia;
	}

	public void setIdAsistencia(Integer idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Tblasistente getTblasistente() {
		return this.tblasistente;
	}

	public void setTblasistente(Tblasistente tblasistente) {
		this.tblasistente = tblasistente;
	}

	public Tblhorario getTblhorario() {
		return this.tblhorario;
	}

	public void setTblhorario(Tblhorario tblhorario) {
		this.tblhorario = tblhorario;
	}

}