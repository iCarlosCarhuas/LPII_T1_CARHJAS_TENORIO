package pe.edu.cibertec.t1.service.impl;

import pe.edu.cibertec.t1.entity.Certificacion;
import pe.edu.cibertec.t1.service.CertificacionService;
import pe.edu.cibertec.t1.dao.CertificacionDAO;
import pe.edu.cibertec.t1.dao.impl.CertificacionDAOImpl;

public class CertificacionServiceImpl extends GenericServiceImpl<Certificacion, Integer> implements CertificacionService{

	private CertificacionDAO certificacionDAO;

	public CertificacionServiceImpl() {
		super(new CertificacionDAOImpl());
		this.certificacionDAO = (CertificacionDAO) super.dao;
	}
} 
 