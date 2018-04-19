package codigoqr.view.bean.servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codigoqr.model.manager.ManagerQR;
import codigoqr.view.bean.util.JSFUtil;

@ManagedBean
@SessionScoped
/**
 * Servlet implementation class ServletQR
 */
@WebServlet("/ServletQR")
public class ServletQR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletQR() {
        super();
        // TODO Auto-generated constructor stub
    }
    @EJB
    ManagerQR managaerqr;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String token = request.getParameter("token");
		String idTipoasistente=request.getParameter("tipasis");
		String cedulaAsistente= request.getParameter("ced"); 
		String nombreAsistente= request.getParameter("nomb");		
		String apellidoAsistente= request.getParameter("apell");
		String celularAsistente= request.getParameter("cel");
		String correoAsistente= request.getParameter("correo");
		String idHorario=request.getParameter("idevento");

		System.out.println("correcto");
		if (JSFUtil.isNull(cedulaAsistente) || JSFUtil.isNull(token))
			return;
		try {
			managaerqr.asistenciaQR(cedulaAsistente, nombreAsistente, apellidoAsistente, celularAsistente, correoAsistente, idHorario);
			response.setStatus(HttpServletResponse.SC_OK);
			OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());
			writer.write("Registrado " + cedulaAsistente);
			writer.flush();
			writer.close();
			System.out.println("Registrado: "+cedulaAsistente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
