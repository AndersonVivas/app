package codigoqr.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tblparametrosevnt database table.
 * 
 */
@Entity
@NamedQuery(name="Tblparametrosevnt.findAll", query="SELECT t FROM Tblparametrosevnt t")
public class Tblparametrosevnt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLPARAMETROSEVNT_IDPARAMETRO_GENERATOR", sequenceName="TBLPARAMETROSEVNT_ID_PARAMETRO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLPARAMETROSEVNT_IDPARAMETRO_GENERATOR")
	@Column(name="id_parametro")
	private Integer idParametro;

	@Column(name="costo_parametro")
	private BigDecimal costoParametro;

	@Column(name="descripcion_parametro")
	private String descripcionParametro;

	@Column(name="nombre_parametro")
	private String nombreParametro;

	//bi-directional many-to-one association to Tblusuario
	@OneToMany(mappedBy="tblparametrosevnt")
	private List<Tblusuario> tblusuarios;

	public Tblparametrosevnt() {
	}

	public Integer getIdParametro() {
		return this.idParametro;
	}

	public void setIdParametro(Integer idParametro) {
		this.idParametro = idParametro;
	}

	public BigDecimal getCostoParametro() {
		return this.costoParametro;
	}

	public void setCostoParametro(BigDecimal costoParametro) {
		this.costoParametro = costoParametro;
	}

	public String getDescripcionParametro() {
		return this.descripcionParametro;
	}

	public void setDescripcionParametro(String descripcionParametro) {
		this.descripcionParametro = descripcionParametro;
	}

	public String getNombreParametro() {
		return this.nombreParametro;
	}

	public void setNombreParametro(String nombreParametro) {
		this.nombreParametro = nombreParametro;
	}

	public List<Tblusuario> getTblusuarios() {
		return this.tblusuarios;
	}

	public void setTblusuarios(List<Tblusuario> tblusuarios) {
		this.tblusuarios = tblusuarios;
	}

	public Tblusuario addTblusuario(Tblusuario tblusuario) {
		getTblusuarios().add(tblusuario);
		tblusuario.setTblparametrosevnt(this);

		return tblusuario;
	}

	public Tblusuario removeTblusuario(Tblusuario tblusuario) {
		getTblusuarios().remove(tblusuario);
		tblusuario.setTblparametrosevnt(null);

		return tblusuario;
	}

}