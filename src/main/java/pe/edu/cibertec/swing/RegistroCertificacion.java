package pe.edu.cibertec.swing;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pe.edu.cibertec.t1.entity.Certificacion;
import pe.edu.cibertec.t1.entity.Cliente;
import pe.edu.cibertec.t1.entity.Especialista;
import pe.edu.cibertec.t1.entity.Tipoauditoria;


import pe.edu.cibertec.t1.service.ClienteService;
import pe.edu.cibertec.t1.service.impl.ClienteServiceImpl;
import pe.edu.cibertec.t1.service.TipoauditoriaService;
import pe.edu.cibertec.t1.service.impl.TipoauditoriaServiceImpl;
import pe.edu.cibertec.t1.service.EspecialistaService;
import pe.edu.cibertec.t1.service.impl.EspecialistaServiceImpl;
import pe.edu.cibertec.t1.service.CertificacionService;
import pe.edu.cibertec.t1.service.impl.CertificacionServiceImpl;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class RegistroCertificacion extends JFrame {
//services
	ClienteService clienteService = new ClienteServiceImpl();
	TipoauditoriaService tipoAuditoriaService = new TipoauditoriaServiceImpl();
	EspecialistaService especialistaService = new EspecialistaServiceImpl();
	CertificacionService certificacionService = new CertificacionServiceImpl();
	
//Public GUI
	JComboBox comboBoxCli;
	JComboBox comboBoxAud;
	JComboBox comboBoxEsp;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JTextField txtFechaEmision;
	private JTextField txtFechaVencimiento;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroCertificacion frame = new RegistroCertificacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroCertificacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxCli = new JComboBox();
		comboBoxCli.setBounds(35, 30, 161, 22);
		contentPane.add(comboBoxCli);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo De Auditoria");
		lblNewLabel_1.setBounds(10, 63, 103, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Especialista");
		lblNewLabel_1_1.setBounds(10, 121, 103, 14);
		contentPane.add(lblNewLabel_1_1);
		
		comboBoxAud = new JComboBox();
		comboBoxAud.setBounds(35, 88, 161, 22);
		contentPane.add(comboBoxAud);
		
		comboBoxEsp = new JComboBox();
		comboBoxEsp.setBounds(35, 146, 161, 22);
		contentPane.add(comboBoxEsp);
		
		lblNewLabel_2 = new JLabel("Fecha Emision");
		lblNewLabel_2.setBounds(10, 179, 91, 14);
		contentPane.add(lblNewLabel_2);
		
		txtFechaEmision = new JTextField();
		txtFechaEmision.setBounds(35, 204, 161, 20);
		contentPane.add(txtFechaEmision);
		txtFechaEmision.setColumns(10);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grabar();
			}
		});
		btnGrabar.setBounds(35, 323, 89, 23);
		contentPane.add(btnGrabar);
		
		txtFechaVencimiento = new JTextField();
		txtFechaVencimiento.setColumns(10);
		txtFechaVencimiento.setBounds(35, 271, 161, 20);
		contentPane.add(txtFechaVencimiento);
		
		lblNewLabel_3 = new JLabel("Fecha Vencimiento");
		lblNewLabel_3.setBounds(10, 246, 91, 14);
		contentPane.add(lblNewLabel_3);
		
		llenarCombos();
		
	}
	void llenarCombos() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = clienteService.conseguirTodo();
		DefaultComboBoxModel<Cliente> modelCli = new DefaultComboBoxModel<Cliente>(clientes.toArray(new Cliente[0]));
		comboBoxCli.setModel(modelCli);
		
		List<Tipoauditoria> tipoAuditorias = new ArrayList<Tipoauditoria>();
		tipoAuditorias = tipoAuditoriaService.conseguirTodo();
		DefaultComboBoxModel<Tipoauditoria> modelAud = new DefaultComboBoxModel<Tipoauditoria>(tipoAuditorias.toArray(new Tipoauditoria[0]));
		comboBoxAud.setModel(modelAud);
		
		List<Especialista> especialistas = new ArrayList<Especialista>();
		especialistas = especialistaService.conseguirTodo();
		DefaultComboBoxModel<Especialista> modelEsp = new DefaultComboBoxModel<Especialista>(especialistas.toArray(new Especialista[0]));
		comboBoxEsp.setModel(modelEsp);
	} 
	
	void grabar() {
		try {
			String fechaTexto = txtFechaEmision.getText(); 
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			Date fechaEmision = sdf.parse(fechaTexto);

			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fechaEmision);
			calendar.add(Calendar.YEAR, 1);
			Date fechaVencimiento = calendar.getTime();

			
			txtFechaVencimiento.setText(sdf.format(fechaVencimiento));

			
			// Obtener objetos seleccionados
			
			
			Certificacion cert = new Certificacion();
			cert.setIdCertificacion(0);
			cert.setTbCliente((Cliente) comboBoxCli.getSelectedItem());
			cert.setTbTipoauditoria((Tipoauditoria) comboBoxAud.getSelectedItem());
			cert.setTbEspecialista((Especialista) comboBoxEsp.getSelectedItem());

			cert.setFecEmision(fechaEmision);
			cert.setFecVencimiento(fechaVencimiento);
			cert.setEstado("vigente");
			// Registramos
			certificacionService.create(cert);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en la fecha. Usa formato dd-MM-yyyy");

			e.printStackTrace();
		}
	}
}
