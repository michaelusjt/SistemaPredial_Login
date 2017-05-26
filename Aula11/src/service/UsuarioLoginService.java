package service;

import dao.UsuarioLoginDAO;
import model.Usuario;
import model.UsuarioLogin;

public class UsuarioLoginService {
	
	public boolean validar(UsuarioLogin usuarioLogin){
		UsuarioLoginDAO dao = new UsuarioLoginDAO();
		return dao.validar(usuarioLogin);
	}
}
