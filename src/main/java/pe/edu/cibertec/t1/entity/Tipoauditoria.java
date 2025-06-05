package pe.edu.cibertec.t1.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.List;

/**
 * The persistent class for the tb_tipoauditoria database table.
 * 
 */
@Data
@Entity
@Table(name="tb_tipoauditoria")
@NamedQuery(name="Tipoauditoria.findAll", query="SELECT t FROM Tipoauditoria t")
public class Tipoauditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_tipoAuditoria;

	private String desc_tipoAuditoria;

	//bi-directional many-to-one association to Certificacion
	@OneToMany(mappedBy="tbTipoauditoria")
	private List<Certificacion> tbCertificacions;

	public Tipoauditoria() {
	}


	public Certificacion addTbCertificacion(Certificacion tbCertificacion) {
		getTbCertificacions().add(tbCertificacion);
		tbCertificacion.setTbTipoauditoria(this);

		return tbCertificacion;
	}

	public Certificacion removeTbCertificacion(Certificacion tbCertificacion) {
		getTbCertificacions().remove(tbCertificacion);
		tbCertificacion.setTbTipoauditoria(null);

		return tbCertificacion;
	}

}