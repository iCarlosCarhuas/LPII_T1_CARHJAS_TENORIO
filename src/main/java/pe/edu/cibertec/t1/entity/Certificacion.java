package pe.edu.cibertec.t1.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;


/**
 * The persistent class for the tb_certificacion database table.
 * 
 */
@Data
@Entity
@Table(name="tb_certificacion")
@NamedQuery(name="Certificacion.findAll", query="SELECT c FROM Certificacion c")
public class Certificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_certificacion")
	private int idCertificacion;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_emision")
	private Date fecEmision;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_vencimiento")
	private Date fecVencimiento;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente tbCliente;

	//bi-directional many-to-one association to Especialista
	@ManyToOne
	@JoinColumn(name="id_especialista")
	private Especialista tbEspecialista;

	//bi-directional many-to-one association to Tipoauditoria
	@ManyToOne
	@JoinColumn(name="id_tipoAuditoria")
	private Tipoauditoria tbTipoauditoria;

	public Certificacion() {
	}

	

}