package codigoqr.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the tblbitacora database table.
 * 
 */
@Entity
@NamedQuery(name="Tblbitacora.findAll", query="SELECT t FROM Tblbitacora t")
public class Tblbitacora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLBITACORA_ID_GENERATOR", sequenceName="TBLBITACORA_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLBITACORA_ID_GENERATOR")
	private Integer id;

	private String accion;

	private String computadora;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time hora;

	@Column(name="id_usuario")
	private Integer idUsuario;

	private String ip;

	private String modulo;

	private String observacion;

	public Tblbitacora() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getComputadora() {
		return this.computadora;
	}

	public void setComputadora(String computadora) {
		this.computadora = computadora;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getModulo() {
		return this.modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}