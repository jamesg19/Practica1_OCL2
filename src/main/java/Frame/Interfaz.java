/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Archivos.GuardarArchivoBinario;
import Archivos.LecturaArchivoBinario;
import Error.Exeption;
import Reproductor.Modificar;
import Reproductor.NotasLeidas;
import Reproductor.Pista;
import Reproductor.Play;
import analizadores.Lexico;
import arbol.Arbol;
import arbol.Asignacion;
import arbol.Continue;
import arbol.Declaracion;
import arbol.Funcion;
import arbol.Instruccion;
import arbol.Principal;
import arbol.Retorna;
import arbol.Salir;
import arbol.TablaDeSimbolos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import javax.swing.TimerQueue;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author James Gramajo
 */
public class Interfaz extends javax.swing.JFrame {

    Pista pista;
    NumeroLinea numeroLinea;
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    String fichero = null;
    analizadores.parser pars;
    private LinkedList<NotasLeidas> SONIDO = new LinkedList<NotasLeidas>();
    private LinkedList<Exeption> ERRLexico = new LinkedList<Exeption>();
    private LinkedList<Exeption> ERRSintactico = new LinkedList<Exeption>();
    private LinkedList<Exeption> ERRSemantico = new LinkedList<Exeption>();
    
    public XYSeriesCollection oDataset = new XYSeriesCollection();
    public JFreeChart oChart = ChartFactory.createXYLineChart("", "Seg", "Hz", oDataset, PlotOrientation.VERTICAL, true, false, false);
    public ChartPanel oPanel = new ChartPanel(oChart);
    DefaultTableModel modelo;

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        mostrar();
        limpiar_grafica();
        cargarTabla();
        numeroLinea = new NumeroLinea(AreaEditor);
        ScrollEditor.setRowHeaderView(numeroLinea);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        ModificarButton = new javax.swing.JButton();
        CrearButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaReproduccion = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Canciones = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListaCanciones = new javax.swing.JList<>();
        PanelGrafico = new javax.swing.JPanel();
        Grafico = new javax.swing.JButton();
        PanelEditorCodigo = new javax.swing.JPanel();
        ScrollEditor = new javax.swing.JScrollPane();
        AreaEditor = new javax.swing.JTextArea();
        Compilar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableError = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Consola = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        AbrirBtn = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(153, 204, 255));

        jPanel2.setForeground(new java.awt.Color(102, 102, 102));

        ModificarButton.setText("Modificar");
        ModificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarButtonActionPerformed(evt);
            }
        });

        CrearButton.setText("Crear");

        jButton1.setText("Play");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ListaReproduccion.setForeground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(ListaReproduccion);

        jLabel1.setText("Lista de reproduccion");

        jButton3.setText("Modificar");

        jButton4.setText("Eliminar");

        jScrollPane2.setViewportView(jList1);

        jLabel2.setText("Pistas");

        Canciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Duracion"
            }
        ));
        Canciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(Canciones);

        ListaCanciones.setForeground(new java.awt.Color(102, 102, 102));
        ListaCanciones.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                ListaCancionesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane4.setViewportView(ListaCanciones);

        javax.swing.GroupLayout PanelGraficoLayout = new javax.swing.GroupLayout(PanelGrafico);
        PanelGrafico.setLayout(PanelGraficoLayout);
        PanelGraficoLayout.setHorizontalGroup(
            PanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );
        PanelGraficoLayout.setVerticalGroup(
            PanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
        );

        Grafico.setText("Grafico");
        Grafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraficoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(CrearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ModificarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 635, Short.MAX_VALUE)
                .addComponent(Grafico, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(PanelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CrearButton)
                    .addComponent(ModificarButton)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(Grafico))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Biblioteca", jPanel2);

        PanelEditorCodigo.setForeground(new java.awt.Color(153, 204, 255));

        AreaEditor.setColumns(20);
        AreaEditor.setForeground(new java.awt.Color(102, 102, 102));
        AreaEditor.setRows(5);
        AreaEditor.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                AreaEditorCaretUpdate(evt);
            }
        });
        AreaEditor.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                AreaEditorAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        AreaEditor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                AreaEditorMouseMoved(evt);
            }
        });
        AreaEditor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AreaEditorMouseEntered(evt);
            }
        });
        AreaEditor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AreaEditorKeyTyped(evt);
            }
        });
        ScrollEditor.setViewportView(AreaEditor);

        Compilar.setText("Compilar");
        Compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompilarActionPerformed(evt);
            }
        });

        TableError.setBackground(new java.awt.Color(153, 204, 255));
        TableError.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo Error", "Descripcion", "Linea", "Columna"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(TableError);

        jScrollPane5.setViewportView(jScrollPane6);

        Consola.setColumns(20);
        Consola.setRows(5);
        jScrollPane7.setViewportView(Consola);

        jLabel4.setText("Reporte Errores");

        jLabel5.setText("Consola");

        javax.swing.GroupLayout PanelEditorCodigoLayout = new javax.swing.GroupLayout(PanelEditorCodigo);
        PanelEditorCodigo.setLayout(PanelEditorCodigoLayout);
        PanelEditorCodigoLayout.setHorizontalGroup(
            PanelEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEditorCodigoLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(PanelEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelEditorCodigoLayout.createSequentialGroup()
                        .addGroup(PanelEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5)
                            .addGroup(PanelEditorCodigoLayout.createSequentialGroup()
                                .addComponent(Compilar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(179, 179, 179)))
                        .addGroup(PanelEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelEditorCodigoLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane7))
                            .addGroup(PanelEditorCodigoLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(ScrollEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 1152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        PanelEditorCodigoLayout.setVerticalGroup(
            PanelEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEditorCodigoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addGroup(PanelEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEditorCodigoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(PanelEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Compilar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PanelEditorCodigoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(PanelEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(PanelEditorCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
        );

        jTabbedPane1.addTab("Editor de Codigo", PanelEditorCodigo);
        jTabbedPane1.addTab("", jTabbedPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivos");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        AbrirBtn.setText("Abrir");
        AbrirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirBtnActionPerformed(evt);
            }
        });
        jMenu1.add(AbrirBtn);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reportes");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void AbrirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirBtnActionPerformed

        // TODO add your handling code here:
        if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.canRead()) {
                String documento;
                fichero = seleccionar.getSelectedFile() + "";
                Path path = Paths.get(fichero);
                try {
                    documento = Files.readString(path, StandardCharsets.UTF_8);
                    AreaEditor.setText("");
                    AreaEditor.setText(documento);                    
                } catch (IOException ex) {
                    System.out.println("ERROR AL ABRIR EL DOCUMENTO :(");
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }//GEN-LAST:event_AbrirBtnActionPerformed

    private void CompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompilarActionPerformed
        // TODO add your handling code here:
        limpiar_tabla_consola();
        byte[] bytes = AreaEditor.getText().getBytes(StandardCharsets.UTF_8);
        String codigo_codificado = new String(bytes, StandardCharsets.UTF_8);
        interpretar(codigo_codificado);
    }//GEN-LAST:event_CompilarActionPerformed

    private void AreaEditorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AreaEditorKeyTyped
        // TODO add your handling code here:
        ScrollEditor.setRowHeaderView(numeroLinea);
    }//GEN-LAST:event_AreaEditorKeyTyped

    private void AreaEditorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AreaEditorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_AreaEditorMouseEntered

    private void AreaEditorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AreaEditorMouseMoved
        // TODO add your handling code here:
        ScrollEditor.setRowHeaderView(numeroLinea);
    }//GEN-LAST:event_AreaEditorMouseMoved

    private void AreaEditorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_AreaEditorAncestorAdded
        // TODO add your handling code here:
        //ScrollEditor.setRowHeaderView(numeroLinea);
    }//GEN-LAST:event_AreaEditorAncestorAdded

    private void AreaEditorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_AreaEditorCaretUpdate
        // TODO add your handling code here:
        ScrollEditor.setRowHeaderView(numeroLinea);
    }//GEN-LAST:event_AreaEditorCaretUpdate

    private void GraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraficoActionPerformed
        //        // TODO add your handling code here:
        //
        //        //nombre de la linea
        //        XYSeries oSeries = new XYSeries("a");
        //
        //        //valores de los puntos en HZ
        //        int year1 = Integer.parseInt("2000");
        //        int year2 = Integer.parseInt("3000");
        //        int year3 = Integer.parseInt("2500");
        //        int year4 = Integer.parseInt("4000");
        //
        //        oSeries.add(0,0);
        //        oSeries.add(1, year1);
        //        oSeries.add(2, year2);
        //        oSeries.add(3, year3);
        //        oSeries.add(4, year4);
        //
        //        XYSeries oSeries2 = new XYSeries("b");
        //        oSeries2.add(1,600);
        //        oSeries2.add(2,700);
        //        oSeries2.add(3,500);
        //        oSeries2.add(4,1000);
        //
        //
        //
        //        //XYSeriesCollection oDataset = new XYSeriesCollection();
        //        oDataset.addSeries(oSeries);
        //        oDataset.addSeries(oSeries2);
        //        //(x,y)
        //        //eje X, eje Y , colecion datos,parametros son de visualizacion
        //        JFreeChart oChart = ChartFactory.createXYLineChart("", "Seg", "Hz", oDataset, PlotOrientation.VERTICAL, true, false, false);
        //        ChartPanel oPanel = new ChartPanel(oChart);
        //
        //
        //
    }//GEN-LAST:event_GraficoActionPerformed

    private void ListaCancionesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ListaCancionesAncestorAdded
        // TODO add your handling code here:
        mostrar();
    }//GEN-LAST:event_ListaCancionesAncestorAdded

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        eliminar();
        mostrar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        play();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ModificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarButtonActionPerformed
        // TODO add your handling code here:
        if (!ListaCanciones.isSelectionEmpty()) {
            LecturaArchivoBinario gr = new LecturaArchivoBinario();
            
            Pista pistaModif=gr.LeerArchivo(ListaCanciones.getSelectedValue());
            AreaEditor.setText("");
            AreaEditor.setText(pistaModif.getCODIGO());
            JOptionPane.showMessageDialog(null, "El codigo de la pista a editar ya esta disponible en el editor de codigo");
            
        } else {
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna pista para editar");
        }
        
    }//GEN-LAST:event_ModificarButtonActionPerformed
    
    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("TIPO");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("LINEA");
        modelo.addColumn("COLUMNA");
        this.TableError.setModel(modelo);
    }

    
    public void mostrar() {
        
        LecturaArchivoBinario ver_pistas = new LecturaArchivoBinario();
        
        LinkedList<String> pistas = new LinkedList();
        
        ver_pistas.ver_pistas();
        
        pistas = ver_pistas.getPistas();
        
        DefaultListModel modelo = new DefaultListModel();
        
        for (int i = 0; i < pistas.size(); i++) {
            //System.out.println(pistas.get(i));
            modelo.addElement(pistas.get(i));
        }
        
        ListaCanciones.setModel(modelo);
    }
    
    private void interpretar(String codigo_codificado) {
        
        LinkedList<Instruccion> AST_arbolSintaxisAbstracta = null;
        try {

            //obtiene el codigo en el area de texto
            codigo_codificado += "\n ";
            System.out.println(codigo_codificado);
            StringReader strs = new StringReader(codigo_codificado);
            //analiza el codigo ingresado
            Lexico lex=new Lexico(strs);
            pars = new analizadores.parser(new analizadores.Lexico(strs));
            pars.parse();
            AST_arbolSintaxisAbstracta = pars.getAST();
            pista = pars.getPista();
            pista.setListaInstrucciones(AST_arbolSintaxisAbstracta);
            pista.setCODIGO(codigo_codificado);
            ejecutarAST(pista);
            ERRSintactico = pars.getSintacticos();
            ERRLexico=lex.getLexicos();
            
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada.");
        }
        
    }
    
    private void ejecutarAST(Pista p) {
        
        LinkedList<Instruccion> ast = p.getListaInstrucciones();
        //Se crea una tabla de símbolos global para ejecutar las instrucciones.
        TablaDeSimbolos TSGlobal = new TablaDeSimbolos();
        Arbol ASTarbol = new Arbol();
        LinkedList<Instruccion> ASTGlobal = new LinkedList<Instruccion>();
        
        if (ast == null) {
            System.out.println("No es posible ejecutar las instrucciones porque\r\n"
                    + "el árbol no fue cargado de forma adecuada por la existencia\r\n"
                    + "de errores léxicos o sintácticos.");
            return;
        }

        //PRIMER RECORRIDO DEL CODIGO BUSCANDO (DECLARACION Y ASIGNACION)
        for (Instruccion ins : ast) {
            
            if (ins instanceof Funcion) {
                ASTGlobal.add(ins);
                ASTarbol.setFUNCIONES(ASTGlobal);
            }
            
            if (ins instanceof Declaracion || ins instanceof Asignacion) {
                
                ins.ejecutar(ASTarbol, TSGlobal);
                //AGREGAR SALIR, RETURN, CONTINUE, EXEPTION
                if (ins instanceof Continue) {
                    Continue con = (Continue) ins;
                    Exeption err = new Exeption("SEMANTICO", "Sentencia Continuar fuera del ciclo", con.getLinea(), con.getColumna());
                    System.out.println("ERROR SEMANTICO Sentencia Continuar fuera del ciclo " + con.getLinea() + " , " + con.getColumna());;
                    //agrega el error a la lista de errores semanticos
                    ASTarbol.getERROR().add(err);
  
                }
                if (ins instanceof Salir) {
                    Salir con = (Salir) ins;
                    Exeption err = new Exeption("SEMANTICO", "Sentencia Salir fuera del ciclo", con.getLinea(), con.getColumna());
                    System.out.println("ERROR SEMANTICO Salir Continuar fuera del ciclo " + con.getLinea() + " , " + con.getColumna());;
                    //agrega el error a la lista de errores semanticos
                    ASTarbol.getERROR().add(err);

                }
                if (ins instanceof Retorna) {
                    Retorna con = (Retorna) ins;
                    Exeption err = new Exeption("SEMANTICO", "Sentencia Retorna ", con.getLinea(), con.getColumna());
                    System.out.println("ERROR SEMANTICO Retorna Retorna " + con.getLinea() + " , " + con.getColumna());;
                    //agrega el error a la lista de errores semanticos
                    ASTarbol.getERROR().add(err);

                }
                if (ins instanceof Exeption) {
                    Exeption ext = (Exeption) ins;
                    System.out.println("ERROR SEMANTICO *&*&*&*&*&*&8/*/*/*/*/*/*/*/*/*/*");;
                    System.out.println(ext.getDescripcion() + " linea" + ext.getLinea() + " columna " + ext.getColumna());
                    ASTarbol.getERROR().add(ext);

                }
            }
            
        }
        //SEGUNDA PASADA
        //SEGUNDO RECORRIDO DEL CODIGO BUSCANDO (EL METODO PRINCIPAL)
        for (Instruccion ins : ast) {
            //Si existe un error léxico o sintáctico en cierta instrucción esta
            //será inválida y se cargará como null, por lo tanto no deberá ejecutarse
            //es por esto que se hace esta validación.
            if (ins instanceof Principal) {
                
                ins.ejecutar(ASTarbol, TSGlobal);
                //AGREGAR SALIR, RETURN, CONTINUE, EXEPTION
                if (ins instanceof Continue) {
                    Continue con = (Continue) ins;
                    Exeption err = new Exeption("SEMANTICO", "Sentencia Continuar fuera del ciclo", con.getLinea(), con.getColumna());
                    System.out.println("ERROR SEMANTICO Sentencia Continuar fuera del ciclo " + con.getLinea() + " , " + con.getColumna());;
                    //agrega el error a la lista de errores semanticos
                    ASTarbol.getERROR().add(err);

                }
                if (ins instanceof Salir) {
                    Salir con = (Salir) ins;
                    Exeption err = new Exeption("SEMANTICO", "Sentencia Salir fuera del ciclo", con.getLinea(), con.getColumna());
                    System.out.println("ERROR SEMANTICO Salir Continuar fuera del ciclo " + con.getLinea() + " , " + con.getColumna());;
                    //agrega el error a la lista de errores semanticos
                    ASTarbol.getERROR().add(err);

                }
                if (ins instanceof Retorna) {
                    Retorna con = (Retorna) ins;
                    Exeption err = new Exeption("SEMANTICO", "Sentencia Retorna ", con.getLinea(), con.getColumna());
                    System.out.println("ERROR SEMANTICO Retorna Retorna " + con.getLinea() + " , " + con.getColumna());;
                    //agrega el error a la lista de errores semanticos
                    ASTarbol.getERROR().add(err);

                }
                if (ins instanceof Exeption) {
                    Exeption ext = (Exeption) ins;
                    System.out.println("ERROR SEMANTICO ");;
                    System.out.println(ext.getDescripcion() + " linea" + ext.getLinea() + " columna " + ext.getColumna());
                    ASTarbol.getERROR().add(ext);

                }
            }
            
        }
        ERRSemantico=ASTarbol.getERROR();
        
        
        for(int i=0;i<ASTarbol.getMensaje().size();i++){
            Consola.append(ASTarbol.getMensaje().get(i)+"\n");
        }
        
        if(ERRSemantico.isEmpty() && ERRSintactico.isEmpty() && ERRLexico.isEmpty()){
            guardarPista(ASTarbol, p);
        }else{
            //agregar errores a la tabla
            agregarErrores();
            JOptionPane.showMessageDialog(null, "El codigo ingresado contiene errores");
        }
        
        
    }
    public void limpiar_tabla_consola(){
        Consola.setText("");
        modelo.setRowCount(0);
        
    }
        public void agregarErrores(){
            for (int i = 0; i < ERRLexico.size(); i++) {
                
                String[] infoo = new String[4];
                infoo[0] = ERRLexico.get(i).getTipo();
                infoo[1] = ERRLexico.get(i).getDescripcion();
                infoo[2] = ERRLexico.get(i).getLinea();
                infoo[3] = ERRLexico.get(i).getColumna();
                AddDataTableError(infoo);
            }
            for (int i = 0; i < ERRSintactico.size(); i++) {
                
                String[] infoo = new String[4];
                infoo[0] = ERRSintactico.get(i).getTipo();
                infoo[1] = ERRSintactico.get(i).getDescripcion();
                infoo[2] = ERRSintactico.get(i).getLinea();
                infoo[3] = ERRSintactico.get(i).getColumna();
                AddDataTableError(infoo);
            }
            for (int i = 0; i < ERRSemantico.size(); i++) {
                System.out.println( "Type: "+ERRSemantico.get(i).getTipo());
                System.out.println( "Type: "+ERRSemantico.get(i).getDescripcion());
                String[] infoo = new String[4];
                infoo[0] = ERRSemantico.get(i).getTipo();
                infoo[1] = ERRSemantico.get(i).getDescripcion();
                infoo[2] = ERRSemantico.get(i).getLinea();
                infoo[3] = ERRSemantico.get(i).getColumna();
                AddDataTableError(infoo);
            }


        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AbrirBtn;
    private javax.swing.JTextArea AreaEditor;
    private javax.swing.JTable Canciones;
    private javax.swing.JButton Compilar;
    private javax.swing.JTextArea Consola;
    private javax.swing.JButton CrearButton;
    private javax.swing.JButton Grafico;
    private javax.swing.JList<String> ListaCanciones;
    private javax.swing.JList<String> ListaReproduccion;
    private javax.swing.JButton ModificarButton;
    private javax.swing.JPanel PanelEditorCodigo;
    private javax.swing.JPanel PanelGrafico;
    private javax.swing.JScrollPane ScrollEditor;
    private javax.swing.JTable TableError;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
public void guardarPista(Arbol ASTarbol, Pista p) {
        //obtenemos las notas en reproducir y de espera
        SONIDO = ASTarbol.getSONIDO();
        //le asginamos las notas al objeto pista
        p.setSONIDO(SONIDO);
        //le asignamos las notas de sonido al objeto pista
        GuardarArchivoBinario gr = new GuardarArchivoBinario(p);
        String basePath = new File("").getAbsolutePath();
        basePath += "\\src\\main\\java\\ArchivoPista\\";
        
        
        if(gr.verificar_existencia_archivo(basePath+p.getNombre()+".dat")){
            int resp = JOptionPane.showConfirmDialog(null, "Ya hay una pista con el mismo nombre\n"+"¿Desea editarla con el codigo actual?",//<- EL MENSAJE
            "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(resp==0){
                gr.EliminarArchivoEditar(p.getNombre());
                gr.guardarObjeto();
                
            }else{
                JOptionPane.showMessageDialog(null, "LA PISTA NO SE HA GUARDADO, CAMBIA EL NOMBRE DE TU PISTA");
                
            }
        
        }else{
            gr.guardarObjeto();
            JOptionPane.showMessageDialog(null, "La pista se ha guardado correctamente");
        }
        
    }
    
    public void play() {
        try {
            if (!ListaCanciones.isSelectionEmpty()) {
                
                if (!ListaCanciones.getSelectedValue().isEmpty()) {
                    
                    limpiar_grafica();
                    Play play = new Play(PanelGrafico, ListaCanciones.getSelectedValue(), oDataset, oChart, oPanel);
                    play.reproducirPistaSeleccionada();
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "No has seleccionado ninguna pista");
            }
        } catch (Exception e) {
            System.out.println("________ERROR EN METODO PLAY" + e);
        }
    }

    public void modificar() {
        try {
            if (!ListaCanciones.isSelectionEmpty()) {
                
                if (!ListaCanciones.getSelectedValue().isEmpty()) {
                    
                    Modificar modif = new Modificar(ListaCanciones.getSelectedValue());
                    String codigo = modif.modificar();
                    AreaEditor.setText("");
                    AreaEditor.setText(codigo);
                    
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "No has seleccionado ninguna pista para modificar");
            }
        } catch (Exception e) {
            System.out.println("________ERROR EN METODO MODIFICAR" + e);
        }
    }
    
    public void eliminar() {
        if (!ListaCanciones.isSelectionEmpty()) {
            GuardarArchivoBinario gr = new GuardarArchivoBinario();
            gr.EliminarArchivo(ListaCanciones.getSelectedValue());
        } else {
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna pista");
        }
    }
    
    public void limpiar_grafica() {
        try {
            oDataset.removeAllSeries();
            oChart = ChartFactory.createXYLineChart("", "Seg", "Hz", oDataset, PlotOrientation.VERTICAL, true, false, false);

            //ChartPanel oPanel = new ChartPanel(oChart);
            oPanel.setChart(oChart);

            //agregar la grafica en el JPanel PanelGrafico(nombre del panel en JFrame
            PanelGrafico.setLayout(new java.awt.BorderLayout());
            PanelGrafico.add(oPanel);
            PanelGrafico.validate();
        } catch (Exception e) {
            System.out.println("____________ERROR AL LIMPIAR LA GRAFICA" + e);
        }
    }
    
    public void AddDataTableError(String[] data) {
        
        modelo.addRow(data);
    }
    
}
