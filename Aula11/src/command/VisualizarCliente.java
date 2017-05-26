package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Empresa;
import service.EmpresaService;

public class VisualizarCliente implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pcnpj = request.getParameter("cnpj");                  
    	String prazaoSocial = request.getParameter("razaoSocial");
    	String pconjunto = request.getParameter("conjunto");
    	String phorarioDeFuncionamento = request.getParameter("horarioDeFuncionamento");
    	String ptemperaturaDoArCondicionado = request.getParameter("temperaturaDoArCondicionado");
    	String phorarioDoArCondicionado = request.getParameter("horarioDoArCondicionado");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Empresa empresa = new Empresa();
		empresa.setId(id);
		empresa.setCnpj(pcnpj);
		empresa.setRazaoSocial(prazaoSocial);
		empresa.setConjunto(pconjunto);
		empresa.setHorarioDeFuncionamento(phorarioDeFuncionamento);
		empresa.setTemperaturaDoArCondicionado(ptemperaturaDoArCondicionado);
		empresa.setHorarioDoArCondicionado(phorarioDoArCondicionado);
		
		EmpresaService es = new EmpresaService();
		
		RequestDispatcher view = null;

		empresa = es.carregar(empresa.getId());
		request.setAttribute("empresa", empresa);
		view = request.getRequestDispatcher("VisualizarEmpresa.jsp");

		view.forward(request, response);

	}

}
