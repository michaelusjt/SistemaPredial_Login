package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UsuarioLogin;
import service.UsuarioLoginService;

public class FazerLogin implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("username");
		String senha = request.getParameter("password");

		UsuarioLogin usuarioLogin = new UsuarioLogin();
		usuarioLogin.setUsername(nome);
		usuarioLogin.setPassword(senha);
		UsuarioLoginService service = new UsuarioLoginService();
		
		if(service.validar(usuarioLogin)){
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuarioLogin);
			System.out.println("Logou "+usuarioLogin);
		} else {
			System.out.println("NÃ£o Logou "+usuarioLogin);
			throw new ServletException("Usuário/Senha inválidos");
		}
		response.sendRedirect("index.jsp");
	}

}
