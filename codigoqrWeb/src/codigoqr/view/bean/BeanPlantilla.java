package codigoqr.view.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import codigoqr.model.manager.ManagerQR;

@SessionScoped
@ManagedBean
public class BeanPlantilla {
	@EJB
	ManagerQR managerQR;
}
