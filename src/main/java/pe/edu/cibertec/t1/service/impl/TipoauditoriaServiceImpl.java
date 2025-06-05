package pe.edu.cibertec.t1.service.impl;

import pe.edu.cibertec.t1.entity.Tipoauditoria;
import pe.edu.cibertec.t1.service.TipoauditoriaService;
import pe.edu.cibertec.t1.dao.TipoauditoriaDAO;
import pe.edu.cibertec.t1.dao.impl.TipoauditoriaDAOImpl;

public class TipoauditoriaServiceImpl extends GenericServiceImpl<Tipoauditoria, Integer> implements TipoauditoriaService{

	private TipoauditoriaDAO tipoauditoriaDAO;

	public TipoauditoriaServiceImpl() {
		super(new TipoauditoriaDAOImpl());
		this.tipoauditoriaDAO = (TipoauditoriaDAO) super.dao;
	}
} 
 