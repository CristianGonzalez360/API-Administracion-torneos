package com.practica.TablasDePosiciones.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practica.TablasDePosiciones.dao.CategoriaDao;
import com.practica.TablasDePosiciones.entity.Categoria;

@Service
public class ServiciosCategoriaImp implements ServiciosCategoria {

	@Autowired
	private CategoriaDao dao;
	
	@Override
	public List<Categoria>readAll() {
		List<Categoria> ret = new ArrayList<>();
		for(Categoria categoria : this.dao.findAll()) {
			ret.add(categoria);
		}
		return ret;
	}
	
	@Override
	public Categoria read(int id) {
		Optional<Categoria> categoria = this.dao.findById(id);
		return categoria.get();
	}
	
	@Override
	public Categoria create(Categoria categoria) {
		return this.dao.save(categoria);
	}
	
	@Override
	public Categoria update(Categoria categoria) {
		return this.dao.save(categoria);
	}
	
	@Override
	public void delete(int id) {
		this.dao.deleteById(id);
	}
}
