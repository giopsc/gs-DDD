package br.com.fiap.seriesapi.service;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.seriesapi.data.ResponsavelDao;
import br.com.fiap.seriesapi.model.Responsavel;

public class ResponsavelService {
	
	ResponsavelDao dao = new ResponsavelDao();

	public List<Responsavel> findAll(){
		try {
			return dao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Responsavel findById(Long id){
		try {
			return dao.findById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(Long id){
		try {
			dao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean create(Responsavel responsavel) {
		if (!validar(responsavel)) return false;
		
		dao.create(responsavel);
		return true;
	}

	private boolean validar(Responsavel responsavel) {
		if (responsavel.nome().isEmpty()) return false;
//		if (responsavel.cpf() != ) return false;
//		if (.sinopse().length() < 10) return false;
//		if (!serie.poster().startsWith("http")) return false;
		
		return true;
	}

	public boolean update(Responsavel serie) {
		if (!validar(serie)) return false;
		try {
			dao.update(serie);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
		
	}
	
	
	
	
	
	
	
	
	
	

}
