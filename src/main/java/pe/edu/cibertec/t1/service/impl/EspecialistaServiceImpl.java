package pe.edu.cibertec.t1.service.impl;

import pe.edu.cibertec.t1.entity.Especialista;
import pe.edu.cibertec.t1.service.EspecialistaService;
import pe.edu.cibertec.t1.dao.EspecialistaDAO;
import pe.edu.cibertec.t1.dao.impl.EspecialistaDAOImpl;

public class EspecialistaServiceImpl extends GenericServiceImpl<Especialista, Integer> implements EspecialistaService{

	private EspecialistaDAO especialistaDAO;

	public EspecialistaServiceImpl() {
		super(new EspecialistaDAOImpl());
		this.especialistaDAO = (EspecialistaDAO) super.dao;
	}
} 
 