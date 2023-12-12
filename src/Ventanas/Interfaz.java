package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import AnalizadorLex_Sem.LexSem;
import AnalizadorLex_Sem.Sintactico;

import java.awt.Toolkit;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Window.Type;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.TextArea;
import java.awt.Scrollbar;


public class Interfaz extends JFrame {

	private JPanel contentPane;
	private LexSem obl=new LexSem();
	private Sintactico obs=new Sintactico();
                  private Generador obg = new Generador();
	private String Ruta="";
	String nombre;
	boolean men,menin;
	TextArea textin;
    // int a ; a = 10 ;
	/**
	 * Launch the application.
	 */
        
        public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
                           public void run() {
                                    try {
                                             Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(SystemColor.controlText);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnSalir.setBounds(65, 580, 89, 27);
		contentPane.add(btnSalir);
		
		JButton btnArchG = new JButton("Guardar Archivo");		
		btnArchG.setForeground(Color.WHITE);
		btnArchG.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnArchG.setBackground(Color.BLACK);
		btnArchG.setBounds(35, 390, 146, 27);
		contentPane.add(btnArchG);
		
		JButton btnArch = new JButton("Cargar Archivo");		
		btnArch.setForeground(Color.WHITE);
		btnArch.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnArch.setBackground(Color.BLACK);
		btnArch.setBounds(35, 440, 146, 27);
		contentPane.add(btnArch);
		
		JButton btnVerErrores = new JButton("Ver Errores");
		btnVerErrores.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(obs!=null)
				{					
					Errores obe=new Errores(obl,obs); //recopilamos los errores
					obe.setVisible(true);
				}
				else
				{
					if(obl!=null)
					{		
						Errores obe=new Errores(obl,obs); //recopilamos los errores
						obe.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "Se nesesita analizar el codigo");
					}
				}	
					
			}
		});
		btnVerErrores.setForeground(Color.WHITE);
		btnVerErrores.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnVerErrores.setBackground(Color.BLACK);
		btnVerErrores.setBounds(35, 535, 146, 27);
		contentPane.add(btnVerErrores);
		
		TextArea textin = new TextArea();
		textin.setBounds(25, 10, 745, 270);
		contentPane.add(textin);
		
		JButton btnAnalizar = new JButton("Analizar");	
		btnAnalizar.setForeground(Color.WHITE);
		btnAnalizar.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnAnalizar.setBackground(Color.BLACK);
		btnAnalizar.setBounds(35, 490, 146, 27);
		contentPane.add(btnAnalizar);
		
		JLabel lblPilaSintactica = new JLabel("Pila Sintactica");
		lblPilaSintactica.setForeground(Color.WHITE);
		lblPilaSintactica.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblPilaSintactica.setBounds(545, 365, 153, 14);
		contentPane.add(lblPilaSintactica);
		
		TextArea textSin = new TextArea();
		textSin.setEditable(false);
		textSin.setBounds(420, 385, 350, 214);
		contentPane.add(textSin);
		
		JLabel lblNewLabel_1 = new JLabel("Componentes Lexicos");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 315, 150, 14);
		contentPane.add(lblNewLabel_1);
		
		TextArea textLex = new TextArea();
		textLex.setEditable(false);
		textLex.setBounds(160, 305, 610, 40);
		contentPane.add(textLex);
                
                                    JLabel lblGenerador = new JLabel("Código Intermedio");
		lblGenerador.setForeground(Color.WHITE);
		lblGenerador.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblGenerador.setBounds(240, 365, 153, 14);
		contentPane.add(lblGenerador);
		
		TextArea textGen = new TextArea();
		textGen.setEditable(false);
		textGen.setBounds(210, 385, 180, 214);
		contentPane.add(textGen);
                
                                    JLabel lblNewLabel = new JLabel("");		
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/dark1.jpg")));
		lblNewLabel.setBounds(0, 0, 800, 620);
		contentPane.add(lblNewLabel);
		setUndecorated(true);
                
	    this.setLocationRelativeTo(null);
	    
	    
	    
	    //Acciones de botones
	    
	    btnArch.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) {
				File obf = null;
				 JFileChooser chooser = new JFileChooser();
				    FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "TXT","txt");
				    chooser.setFileFilter(filter);
				    int returnVal = chooser.showOpenDialog(getParent());
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	textin.setText("");
				    	obf=chooser.getSelectedFile();
				    	Txt obx=new Txt(obf.getAbsolutePath());// abrimos el contenido del archivo
				    	//System.out.println(obf);
				    	Ruta=obf+"";
				    	String text=obx.getTexto(),text2="";
				    	for(int i=0;i<text.length();i++)
						{
							if(text.charAt(i)=='$')
							{
								text2+="\n";
							}
							else
							{
								text2+=text.charAt(i);
							}
						}
						textin.setText(text2);	// se lo asignamos al control
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(null, "No se cargo ningun archivo");
				    }
			   			
			}
		});
	    
	    btnArchG.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					if(Ruta.length()==0)
					{
						GuardarComo();
					}
					else
					{
						FileWriter f=new FileWriter(Ruta);
						String text=textin.getText(),text2="";
						for(int i=0;i<text.length();i++)
						{
							if(text.charAt(i)=='\n')
							{
								text2+="$";
							}
							else
							{
								text2+=text.charAt(i);
							}
						}
						f.write(text2);
						f.close();
					}
				}
				catch(IOException e1) 
				{
				}
			}
	    });
	    btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	    
	    btnAnalizar.addActionListener(new ActionListener() {// analizar
			public void actionPerformed(ActionEvent e) {
				
				obl=new LexSem();
				textLex.setText("");
				textSin.setText("");
                                                                        textGen.setText("");
				obl.Analizar(textin.getText());
				textLex.setText(obl.getCodigo());
				obs=new Sintactico();
				textSin.setText(obs.metodo(obl.getComponentesLexicos()));
				obl.tablaSem();
                                                                        obg = new Generador();
                                                                        obg.Analizar(textin.getText());
                                                                        textGen.setText(obg.getCodigo());
			}
		});
	}
        
	public void GuardarComo()
	{
		JFileChooser Carpeta = new JFileChooser();
		Carpeta.setCurrentDirectory(new File("."));
		Carpeta.setDialogTitle("Seleccione la carpeta para guardar el archivo");
		Carpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		Carpeta.setAcceptAllFileFilterUsed(false);

		if (Carpeta.showOpenDialog(getParent()) == JFileChooser.APPROVE_OPTION) {
			
			File carpetaSeleccionada = Carpeta.getSelectedFile();
			men=false;
			do
			{
				nombre=JOptionPane.showInputDialog("Nombre del archivo");
				try
				{
					if(nombre.length()==0)
					{
						JOptionPane.showMessageDialog(null,
								"Ingrese nombre del archivo");
					}
					else
					{
						men=true;
					}
				}
				catch (Exception m) 
				{
					JOptionPane.showMessageDialog(null, "se cancelo la creacion");
					menin=true;
				}
			}
			while(!men&&!menin);
			if(men)
			{
				Ruta=(carpetaSeleccionada.getAbsolutePath()+"\\"+nombre+".txt");
				System.out.println(Ruta);
				FileWriter f;
				try {
					f = new FileWriter(Ruta);
					String text=textin.getText(),text2="";
					for(int i=0;i<text.length();i++)
					{
						if(text.charAt(i)=='\n')
						{
							text2+="$";
						}
						else
						{
							text2+=text.charAt(i);
						}
					}
					f.write(text2);
					f.write(text);
					f.close();
				} catch (IOException e) 
				{
				}
			}
		}
	}
}