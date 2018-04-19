package codigoqr.view.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class BeanBotones {
	boolean botonActualizarHorario;
	boolean botonAgregarHorario;
	boolean btnActualizarJornada;
	boolean btnAgregarJornada;

	@PostConstruct
	public void iniciar() {
		botonActualizarHorario = true;
		btnActualizarJornada=true;
		btnAgregarJornada=false;		
		botonAgregarHorario = false;
	}
	public boolean isBotonActualizarHorario() {
		return botonActualizarHorario;
	}
	public void setBotonActualizarHorario(boolean botonActualizarHorario) {
		this.botonActualizarHorario = botonActualizarHorario;
	}

	public boolean isBotonAgregarHorario() {
		return botonAgregarHorario;
	}

	public void setBotonAgregarHorario(boolean botonAgregarHorario) {
		this.botonAgregarHorario = botonAgregarHorario;
	}
	public boolean isBtnAgregarJornada() {
		return btnAgregarJornada;
	}
	public void setBtnAgregarJornada(boolean btnAgregarJornada) {
		this.btnAgregarJornada = btnAgregarJornada;
	}
	public boolean isBtnActualizarJornada() {
		return btnActualizarJornada;
	}
	public void setBtnActualizarJornada(boolean btnActualizarJornada) {
		this.btnActualizarJornada = btnActualizarJornada;
	}
	

}
