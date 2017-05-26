package service;

import java.io.IOException;
import java.util.ArrayList;


import model.Empresa;
import dao.EmpresaDAO;

public class SindicoService {
	EmpresaDAO dao;
	
	public SindicoService(){
		dao = new EmpresaDAO();
	}
	public ArrayList<Empresa> listarEmpresas() throws IOException{
		return dao.listarEmpresas();
	}
	public ArrayList<Empresa> listarEmpresas(String chave) throws IOException{
		return dao.listarEmpresas(chave);
	}
	

}
