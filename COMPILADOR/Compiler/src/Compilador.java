
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author ANGEL BARON GARCIA
 */
public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd, asig_prod, v_n_prod, s_prod, s_s_prod, f_prod, c_prod,impo,ll_f,f_v,f_r,f_1_0,f_2,f_m;
    private ArrayList<String> com;
    private HashMap<String, String> identificadores, identificadores2, valores;
    private HashMap<String,ArrayList> datos_locales,para;
    private HashMap<String,HashMap>nom_f;
    private boolean codeHasBeenCompiled = false;

    /**
     * Creates new form Compilador
     */
    public Compilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "Compiler";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".go");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        asig_prod = new ArrayList<>();
        v_n_prod = new ArrayList<>();
        s_prod = new ArrayList<>();
        s_s_prod = new ArrayList<>();
        f_prod = new ArrayList<>();
        c_prod = new ArrayList<>();
        identificadores = new HashMap<>();
        identificadores2 = new HashMap<>();
        valores = new HashMap<>();
        com = new ArrayList<>();
        impo= new ArrayList<>();
        ll_f= new ArrayList<>();
        f_v=new ArrayList<>();
        f_r=new ArrayList<>();
        f_1_0 = new ArrayList<>();
        f_2 = new ArrayList<>();
        datos_locales = new HashMap<>();
        para = new HashMap<>();
        f_m = new ArrayList<>();
        
        Functions.setAutocompleterJTextComponent(new String[]{}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        buttonsFilePanel = new javax.swing.JPanel();
        btnAbrir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        btnCompilar = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarC.setText("Guardar como");
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsFilePanelLayout = new javax.swing.GroupLayout(buttonsFilePanel);
        buttonsFilePanel.setLayout(buttonsFilePanelLayout);
        buttonsFilePanelLayout.setHorizontalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonsFilePanelLayout.setVerticalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnGuardarC))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jtpCode);

        btnCompilar.setText("Compilar");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCompilar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEjecutar)
                .addContainerGap())
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompilar)
                    .addComponent(btnEjecutar))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setBackground(new java.awt.Color(255, 255, 255));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTokens);

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rootPanelLayout.createSequentialGroup()
                        .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        getContentPane().add(rootPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
                System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                System.out.println(blocksOfCode);

            }
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis_V_N();
        semanticAnalysis_I_V();
        semanticAnalysis_S_S();
        semanticAnalysis_S();
        semanticAnalysis_V_A();
        semanticAnalysis_for();
        semanticAnalysis_com();
        semanticAnalysis_fun_v();
        semanticAnalysis_fun_ll_0();
        semanticAnalysis_ll_f();
        printConsole();
        //System.out.println(jtpCode.getText());
       // sacar_codigo(jtpCode.getText());
        
        //crearPDF();

        codeHasBeenCompiled = true;
    }

    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    private void syntacticAnalysis() {
        Grammar gramatica = new Grammar(tokens, errors);
        /*Eliminacion de errores*/
        gramatica.delete(new String[]{"ERROR", "ERROR 1", "ERROR 2"}, 1);
        /*Agrupacion de VALORES */
        gramatica.group("IMPORTACIONES", "(STRING) (STRING)+",impo);

        gramatica.group("SUMA_ID", "((IDENTIFICADOR|Numero_entero|Numero_Flotante) OP_ARI (IDENTIFICADOR|Numero_entero|Numero_Flotante))(OP_ARI (IDENTIFICADOR|Numero_entero|Numero_Flotante))+", s_prod);
        gramatica.group("SUMA_S", "((IDENTIFICADOR|Numero_entero|Numero_Flotante) OP_ARI (IDENTIFICADOR|Numero_entero|Numero_Flotante))", s_s_prod);
        gramatica.group("VALOR", "(Numero_entero|Numero_Flotante|STRING|SUMA_S|SUMA_ID)", true);
        /*Declaracion de variables*/

        gramatica.group("VARIABLE_N_I", "(TIPO_V|TIPO_C) IDENTIFICADOR TIPO_DATO (P_C)?", true, v_n_prod);

        gramatica.group("VARIABLE_I", "VARIABLE_N_I Asignacion (VALOR|IDENTIFICADOR) (P_C)?", true, identProd);
        gramatica.group("VARIABLE_I", "VARIABLE_N_I VALOR", true, 
               2, "ERROR SINTACTICO {}: FALTA EL \"=\" EN LA LINEA [#,%]");
        gramatica.group("VARIABLE_I", "VARIABLE_N_I Asignacion ", true, 
                2, "ERROR SINTACTICO {}: Falta el valor a asignar en la linea [#,%]");
        gramatica.finalLineColumn();
        /*Asigancion de variables*/
        gramatica.group("ASIGNAR", "IDENTIFICADOR Asignacion (VALOR)", asig_prod);

        gramatica.initialLineColumn();
        /*Eliminación de tipos de dato y operadores de asginaciones*/

 /*Agrupacion de identificadores y definicion de parametros*/
        gramatica.group("IDEN", "IDENTIFICADOR", true);
        gramatica.group("RET", "RETORNO (VALOR|IDEN) (P_C)?");

        gramatica.group("COMPARAR", "(VALOR|IDEN) (COMPARACION_IGUAL_A|NO_IGUAL_A|MENOR_QUE|MENOR_O_IGUAL_QUE|MAYOR_QUE|MAYOR_O_IGUAL_QUE) (VALOR|IDEN)", c_prod);
        // gramatica.group("PARAMETROS", "(VALOR|COMPARAR|IDEN) (COMA (VALOR|COMPARAR|IDEN))+");
        gramatica.group("EST_FOR", "FOR IDEN Asignacion_corta (VALOR|IDEN) P_C COMPARAR P_C IDEN OP_ARI OP_ARI", f_prod);
        /*Agrupacion de FUNCIONES*/
        gramatica.group("PAR_FUNC", "(IDEN TIPO_DATO)(COMA IDEN TIPO_DATO)+");
        gramatica.group("FUNCION_M", "FUNC MAIN Parentesis_izq Parentesis_der", true,f_m);
        gramatica.group("FUNCION_S_C", "FUNC IDEN Parentesis_izq (PAR_FUNC|(IDEN TIPO_DATO))? Parentesis_der TIPO_DATO", true);
        gramatica.group("FUNCION_S_V", "FUNC IDEN Parentesis_izq (PAR_FUNC|(IDEN TIPO_DATO))? Parentesis_der", true,f_v);
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("PAR_FUN", "IDEN Parentesis_izq (VALOR| COMPARAR |PARAMETROS|IDEN)? Parentesis_der",f_1_0);
            gramatica.group("PARAMETROS", "(VALOR|COMPARAR|IDEN|PAR_FUN) (COMA (VALOR|COMPARAR|IDEN|PAR_FUN))+");
            gramatica.group("FUNCION", "IDEN Parentesis_izq (VALOR| COMPARAR |PARAMETROS|IDEN|PAR_FUN)? Parentesis_der (P_C)?",f_2);
        });

        gramatica.finalLineColumn();

        gramatica.initialLineColumn();
        /*EXPRESIONES LOGICAS*/

        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("EXP_LOGICA", "(FUNCION| COMPARAR | EXP_LOGICA)(OP_LOGICO (FUNCION | EXP_LOGICA | COMPARAR))+");
            gramatica.group("EXP_LOGICA", "Parentesis_izq (EXP_LOGICA|FUNCION|COMPARAR) Parentesis_der");
            gramatica.group("EXP_LOGICA", "(EXP_LOGICA|COMPARAR) (P_C)?");
        });

        /*Eliminacion de operadores logicos*/
        gramatica.delete("OP_LOGICO", 10, "ERROR SINTACTICO {}: El operador lógico no esta contenido en una expresion [#,%]");

        /*Agrupacion de expresiones logicas como valor y parametros*/
        gramatica.group("VALOR", "EXP_LOGICA");
        gramatica.group("ASIGNAR", "IDEN Asignacion (VALOR|FUNCION|PAR_FUNC|PAR_FUN|IDEN)", asig_prod);
        gramatica.group("PARAMETROS", "VALOR (COMA VALOR)+");

        /*Agrupacion de estructuras de control*/
        gramatica.group("EST_CONTROL", "WHILE|PALABRA_IF");

        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL Parentesis_izq Parentesis_der");
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL (VALOR | PARAMETROS | FUNCION|PAR_FUN)");
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL Parentesis_izq (VALOR | PARAMETROS| FUNCION|PAR_FUN) Parentesis_der");
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL Parentesis_izq (VALOR | PARAMETROS|FUNCION|PAR_FUN)", 11, "ERROR SINTACTICO {}: Falta cerrar parentesis en la linea [#,%]");
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL (VALOR | PARAMETROS|FUNCION|PAR_FUN) Parentesis_der", 11, "ERROR SINTACTICO {}: Falta abrir parentesis en la linea [#,%]");
        /*Eliminacion de estrucutras de control incompletas*/
        gramatica.delete("EST_CONTROL", 11, "ERROR SINTACTICO {}: la estructura de control no esta declarada correctamente [#,%]");

        //Sentencias 
        gramatica.group("LLAMADA_OBJ", "IDEN PUNTO FUNCION (P_C)?",ll_f);
        gramatica.group("SENTENCIAS", "(VALOR| FUNCION | ASIGNAR| VARIABLE_I|VARIABLE_N_I|LLAMADA_OBJ|PAR_FUN)+ (P_C)?");
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("CICLO_FOR_COMP", "EST_FOR Llave_izq (SENTENCIAS)? Llave_der (P_C)?", true);
            gramatica.group("EST_CONTROL_COMP_LASLC", "EST_CONTROL_COMP Llave_izq (SENTENCIAS)? Llave_der (P_C)?", true);
            gramatica.group("SENTENCIAS", "(SENTENCIAS|EST_CONTROL_COMP_LASLC|CICLO_FOR_COMP)+ (P_C)?");
        });
        // ESTRUCUTRAS DE FUINCION INCOMPLETAS
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.initialLineColumn();
            gramatica.group("EST_CONTROL_COMP_LASLC", "EST_CONTROL_COMP (SENTENCIAS)? Llave_der", true,
                    15, "ERROR SINTACTICO {}: FALTA LA LLAVE QUE ABRE EN "
                            + "LA ESTRUCTURA DE CONTROL [#,%]");
            gramatica.group("CICLO_FOR_COMP", "EST_FOR (SENTENCIAS)? Llave_der", true, 15, "ERROR SINTACTICO {}: FALTA LA LLAVE QUE ABRE EN LA ESTRUCTURA DE CICLO [#,%]");
            gramatica.finalLineColumn();
            gramatica.group("EST_CONTROL_COMP_LASLC", "EST_CONTROL_COMP Llave_izq (SENTENCIAS)", true, 15, "ERROR SINTACTICO {}: FALTA LA LLAVE QUE CIERRA EN LA ESTRUCTURA DE CONTROL [#,%]");
            gramatica.group("CICLO_FOR_COMP", "EST_FOR Llave_izq (SENTENCIAS)?", true, 15, "ERROR SINTACTICO {}: FALTA LA LLAVE QUE CIERRA EN LA ESTRUCTURA DE CICLO [#,%]");
            gramatica.group("SENTENCIAS", "(SENTENCIAS|EST_CONTROL_COMP_LASLC|CICLO_FOR_COMP) (P_C)?");

        });

        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("FUNCION_S_S", "FUNCION_S_C Llave_izq (SENTENCIAS)? RET Llave_der (P_C)?", true,f_r);
        });
        gramatica.group("FUNCION_S_EP", "FUNCION_S_V Llave_izq (SENTENCIAS)? Llave_der (P_C)?", true);

        gramatica.group("FUNCION_S_M", "FUNCION_M Llave_izq (SENTENCIAS)? Llave_der (P_C)?", true);

//            gramatica.loopForFunExecUntilChangeNotDetected(()->{
//            gramatica.group("FUNCION_C", "FUNCION_S_C Llave_izq (SENTENCIAS)? Llave_der",true);
//            gramatica.group("SENTENCIAS", "(SENTENCIAS)+");
//            });
//            
//            gramatica.loopForFunExecUntilChangeNotDetected(()->{
//            gramatica.group("FUNCION_C", "FUNCION  (SENTENCIAS)? Llave_der",true,15,"ERROR SINTACTICO FALTA ABRIR LA LLAVE EN [#,%]");
//            gramatica.finalLineColumn();
//            gramatica.group("FUNCION_C", "FUNCION Llave_izq (SENTENCIAS)? ",true,15,"ERROR SINTACTICO {}: FALTA CERRAR LA LLAVE EN [#,%]");
//            gramatica.group("SENTENCIAS", "(SENTENCIAS|FUNCION_C");
//            });
        gramatica.group("VARIABLE_E", "(TIPO_V|TIPO_C) TIPO_DATO", true, 
                2, "ERROR SINTACTICO {}: "
                + "Falta nombre de identificador en la linea "
                + "[#,%]");
        gramatica.group("FUNCION_S_S", "FUNCION_S_C Llave_izq (SENTENCIAS)? Llave_der (P_C)?", 
                1, "ERROR SINTACTICO {}: Falta un retorno en la linea [#,%]");
        gramatica.group("VARIABLE_E", "(TIPO_V|TIPO_C) IDEN ", true, 
                2, "ERROR SINTACTICO {}: Falta tipo de valor en la linea [#,%]");
        gramatica.initialLineColumn();
        gramatica.group("VARIABLE_E", "IDEN TIPO_DATO", true, 
                2, "ERROR SINTACTICO {}: Falta tipo de valor en la linea [#,%]");
        gramatica.finalLineColumn();
        gramatica.group("VARIABLE_I", "VARIABLE_N_I VALOR", true, 
               2, "ERROR SINTACTICO {}: FALTA EL \"=\" EN LA LINEA [#,%]");
        //gramatica.group("ERR_PARFUN", "PAR_FUN", true, 29, "ERROR SINTACTICO {}: NO SE PUEDE LLAMAR A UNA FUNCION ESTANDO FUERA DEL CUERPO DE FUNCION");
        gramatica.group("VARIABLE_I", "VARIABLE_N_I Asignacion ", true, 
                2, "ERROR SINTACTICO {}: Falta el valor a asignar en la linea [#,%]");
        gramatica.group("PACK", "PACKAGE MAIN");

        gramatica.group("IMP", "IMPORTACION Parentesis_izq (VALOR|IMPORTACIONES|SENTENCIAS)? Parentesis_der");
        /*Eliminacion de parentesis*/
        gramatica.group("PACK", "PACKAGE ", 
                1, "ERROR SINTACTICO {}: FALTA EL IDEN MAIN [#,%]");
        gramatica.delete("Asignacion", 
                5, "Error sintáctico {}: El operador de asiganción no está en una declaración [#,%]");
        gramatica.delete(new String[]{"Parentesis_izq", "Parentesis_der"}, 
                12, "ERROR SINTACTICO {}: el parentesis [] no está contenido en una agrupación [#,%]");
        gramatica.delete(new String[]{"Llave_izq", "Llave_der"}, 
                16, "error sintactico {}: la llave [] no esta contenida en una agrupacion [#,%]");
        gramatica.delete("TIPO_DATO", 
                4, "Error sintáctico {}: El tipo de dato no esta en una declaracion [#,%]");
        gramatica.delete("IDEN", 
                8, "ERROR SINTACTICO {}: La funcion no esta declarada correctamente en la linea [#,%]");
        gramatica.delete("OP_ARI", 
                21, "ERROR SINTACTICO {}: El simbolo [] tiene que estar en una operacion [#,%]");
        gramatica.group("FUNCION", "IDEN Parentesis_izq (VALOR|PARAMETROS|IDEN)? ", 6, "ERROR SINTACTICO {}: Falta cerrar parentesis en la linea {#,%]");
        gramatica.group("FUNCION", "IDEN (VALOR|PARAMETROS|IDEN)? Parentesis_der", 6, "ERROR SINTACTICO {}: Falta abrir parentesis en la linea [#,%]");
        /* Mostrar gramáticas */
        gramatica.show();
    }
    
    private void semanticAnalysis_ll_f(){
        
        for (Production id : ll_f) {
            System.out.println(id.lexemeRank(0));
            if(id.lexemeRank(0).equals("fmt")){
                if(id.lexemeRank(2).equals("Println")){
                    
                }else if(id.lexemeRank(2).equals("Printf")){
                    
                }else if(id.lexemeRank(2).equals("Print")){
                    
                }else{
                    errors.add(new ErrorLSSL(10, "Error semántico {}: se esperaba un Println, Printf o print[#,%]", id, true));
                }
            }
        }
    }
    
    private void semanticAnalysis_fun_ll_0(){
        //System.out.println("HOLA LLAMADA FUNCION SIN P");
        for (Production id : f_1_0) {
            //System.out.println(id.lexemeRank(0));
            if(identificadores2.get(id.lexemeRank(0))==null){
                errors.add(new ErrorLSSL(10, "Error semántico {}: funcion no definida [#,%]", id, true));
            }else{
                System.out.println(identificadores2.get(id.lexemeRank(0)));
               if(identificadores2.get(id.lexemeRank(0)).equals("void")){
                   
               }else if(identificadores2.get(id.lexemeRank(0)).equals("funcion")){
                   
               }else{
                   errors.add(new ErrorLSSL(10, "Error semántico {}: funcion no definida o nombre de variable ya utilizada [#,%] " + identificadores2.get(id.lexemeRank(0)), id, true));
               }
                
            }
            
        }
        for (Production id : f_1_0) {
            System.out.println(id.lexemeRank(2));
            if(id.lexemeRank(2).equals(")")){
                
            }else{
                
            }
        }
    }
    
    private void semanticAnalysis_fun_v(){
        System.out.println("HOLA FUNCION VACIA");
        for (Production id : f_v) {
            //System.out.println(id.lexemeRank(1));
            if(identificadores2.get(id.lexemeRank(1))==null){
                //System.out.println("IF TRUE");
                //System.out.println(id.lexemeRank(1));
                identificadores2.put(id.lexemeRank(1), "void");
            }else{
                if(identificadores2.get(id.lexemeRank(1)).equals("void")){
                    //System.out.println("IF FLASE");
                    errors.add(new ErrorLSSL(10, "Error semántico {}: duplicacion de funcion vacia o nombre de funcion ya declarada[#,%]", id, true));
                }
                
            }
            
        }
        for (Production id : f_v) {
            
            String xd ="";
            for(int i =3; i<id.getSizeTokens();i++){
                
                
                if(!id.lexemeRank(i).equals(")")){
                    if(!id.lexemeRank(i).equals(",")){
                        
                        if(id.lexicalCompRank(i).equals("IDENTIFICADOR")){
                            System.out.println(id.lexicalCompRank(i));
                            xd=id.lexemeRank(i);
                        }else{
                            System.out.println(xd + id.lexemeRank(i));
                            
                        }
                        
                        
                    }
                    
                    
                }
            }
            
        }
    }

    private void semanticAnalysis_com() {
        for (Production id : c_prod) {
            if (id.lexicalCompRank(0).equals("IDENTIFICADOR")) {
                if (identificadores2.get(id.lexemeRank(0)) == null) {
                    errors.add(new ErrorLSSL(1, "Error semántico {}: valor no inicializado [#,%]", id, true));
                } else {
                    if (id.lexicalCompRank(2).equals("IDENTIFICADOR")) {
                        if (identificadores2.get(id.lexemeRank(2)) == null) {
                            errors.add(new ErrorLSSL(1, "Error semántico {}: valor no inicializado [#,%]", id, true));
                        } else {
                            if (identificadores2.get(id.lexemeRank(0)).equals(identificadores2.get(id.lexemeRank(2)))) {

                            } else {
                                errors.add(new ErrorLSSL(1, "Error semántico {}: valor en la comparacion no compatibles [#,%]", id, true));
                            }
                        }
                    } else {
                        if (identificadores2.get(id.lexemeRank(0)).equals(id.lexicalCompRank(2))) {

                        } else {
                            errors.add(new ErrorLSSL(1, "Error semántico {}: valor en la comparacion no compatibles [#,%]", id, true));
                        }
                    }
                }
            } else {
                if (id.lexicalCompRank(2).equals("IDENTIFICADOR")) {
                    if (identificadores2.get(id.lexemeRank(2)) == null) {
                        errors.add(new ErrorLSSL(1, "Error semántico {}: valor no inicializado [#,%]", id, true));
                    } else {
                        if (id.lexicalCompRank(2).equals(identificadores2.get(id.lexemeRank(2)))) {

                        } else {
                            errors.add(new ErrorLSSL(1, "Error semántico {}: valor en la comparacion no compatibles [#,%]", id, true));
                        }
                    }
                } else {
                    if (id.lexicalCompRank(0).equals(id.lexicalCompRank(2))) {

                    } else {
                        errors.add(new ErrorLSSL(1, "Error semántico {}: valor en la comparacion no compatibles [#,%]", id, true));
                    }
                }
            }
        }
    }

    private void semanticAnalysis_for() {
        for (Production id : f_prod) {
            if (id.lexicalCompRank(3).equals("IDENTIFICADOR")) {

                if (identificadores2.get(id.lexemeRank(3)) == null) {
                    errors.add(new ErrorLSSL(1, "Error semántico {}: valor no inicializado [#,%]", id, true));

                } else {
                    if (identificadores2.get(id.lexemeRank(3)).equals("Numero_entero")) {

                    } else {
                        errors.add(new ErrorLSSL(1, "Error semántico {}: valor no compatible [#,%]", id, true));
                    }
                }

            } else {
                if (id.lexicalCompRank(3).equals("Numero_entero")) {
                    identificadores2.put(id.lexemeRank(1), "Numero_entero");
                    identificadores.put(id.lexemeRank(1), id.lexemeRank(3));
                } else {
                    errors.add(new ErrorLSSL(1, "Error semántico {}: valor no compatible [#,%]", id, true));
                }
            }
        }
    }

    private void semanticAnalysis_S_S() {
        ArrayList<String> tipo = new ArrayList<>();
        String comp = "";
        HashMap<String, String> identDataType = new HashMap<>();
        identDataType.put("int", "Numero_entero");
        identDataType.put("string", "STRING");
        identDataType.put("bool", "COMPARACION");
        identDataType.put("float", "Numero_Flotante");
        for (Production id : s_s_prod) {
            System.out.println(id.getSizeTokens());
            tipo.clear();
            comp = "";
            for (int i = 0; i < id.getSizeTokens(); i++) {
                if (!id.lexicalCompRank(i).equals("OP_ARI")) {
                    if (i == 0) {
                        if (id.lexicalCompRank(i).equals("IDENTIFICADOR")) {
                            if (identificadores2.get(id.lexemeRank(i)) == null) {
                                errors.add(new ErrorLSSL(11, "Error semántico {}: valor no inicializado [#,%]", id, true));
                            } else {
                                comp = identificadores2.get(id.lexemeRank(i));
                            }

                        } else {
                            comp = id.lexicalCompRank(i);
                            System.out.println(comp);
                        }

                    } else {
                        if (id.lexicalCompRank(i).equals("IDENTIFICADOR")) {
                            if (identificadores2.get(id.lexemeRank(i)) == null) {
                                errors.add(new ErrorLSSL(11, "Error semántico {}: valor no inicializado [#,%]", id, true));
                            } else {
                                if (identificadores2.get(id.lexemeRank(i)).equals(comp)) {

                                } else {
                                    errors.add(new ErrorLSSL(5, "Error semántico {}: valor no compatible con la suma [#,%]", id, true));
                                }
                            }
                        } else {
                            if (id.lexicalCompRank(i).equals(comp)) {

                            } else {
                                errors.add(new ErrorLSSL(5, "Error semántico {}: valor no compatible con la suma [#,%]", id, true));
                            }
                        }
                    }
                    tipo.add(id.lexicalCompRank(i));
                }
            }
        }
    }

    private void semanticAnalysis_S() {
        ArrayList<String> tipo = new ArrayList<>();
        String comp = "";
        HashMap<String, String> identDataType = new HashMap<>();
        identDataType.put("int", "Numero_entero");
        identDataType.put("string", "STRING");
        identDataType.put("bool", "COMPARACION");
        identDataType.put("float", "Numero_Flotante");
        for (Production id : s_prod) {
            System.out.println(id.getSizeTokens());
            tipo.clear();
            comp = "";
            for (int i = 0; i < id.getSizeTokens(); i++) {
                if (!id.lexicalCompRank(i).equals("OP_ARI")) {
                    if (i == 0) {
                        if (id.lexicalCompRank(i).equals("IDENTIFICADOR")) {
                            if (identificadores2.get(id.lexemeRank(i)) == null) {
                                errors.add(new ErrorLSSL(1, "Error semántico {}: valor no inicializado [#,%]", id, true));
                            } else {
                                comp = identificadores2.get(id.lexemeRank(i));
                            }

                        } else {
                            comp = id.lexicalCompRank(i);
                            System.out.println(comp);
                        }

                    } else {
                        if (id.lexicalCompRank(i).equals("IDENTIFICADOR")) {
                            if (identificadores2.get(id.lexemeRank(i)) == null) {
                                errors.add(new ErrorLSSL(1, "Error semántico {}: valor no inicializado [#,%]", id, true));
                            } else {
                                if (identificadores2.get(id.lexemeRank(i)).equals(comp)) {

                                } else {
                                    errors.add(new ErrorLSSL(5, "Error semántico {}: valor no compatible con la suma [#,%]", id, true));
                                }
                            }
                        } else {
                            if (id.lexicalCompRank(i).equals(comp)) {

                            } else {
                                errors.add(new ErrorLSSL(5, "Error semántico {}: valor no compatible con la suma [#,%]", id, true));
                            }
                        }
                    }
                    tipo.add(id.lexicalCompRank(i));
                }
            }
        }
    }

    private void semanticAnalysis_V_N() {
        HashMap<String, String> identDataType = new HashMap<>();
        identDataType.put("int", "Numero_entero");
        identDataType.put("string", "STRING");
        identDataType.put("bool", "COMPARACION");
        identDataType.put("float", "Numero_Flotante");

        for (Production id : v_n_prod) {
            identificadores2.put(id.lexemeRank(1), identDataType.get(id.lexemeRank(2)));
            System.out.println(identificadores2.get(id.lexemeRank(1)));

        }
    }

    private void semanticAnalysis_I_V() {
        HashMap<String, String> identDataType = new HashMap<>();
        identDataType.put("int", "Numero_entero");
        identDataType.put("string", "STRING");
        identDataType.put("bool", "COMPARACION");
        identDataType.put("float", "Numero_Flotante");
        for (Production id : identProd) {
//            System.out.println(id.lexemeRank(2));
//            System.out.println(id.lexicalCompRank(-1));
//               System.out.println(id.lexicalCompRank(-1).equals(identDataType.get(id.lexemeRank(2))));
//               System.out.println(identDataType.get(id.lexemeRank(2)).equals(id.lexicalCompRank(-1)));
            if (identificadores.get(id.lexemeRank(-1)) == null && id.lexicalCompRank(-1).equals("IDENTIFICADOR")) {
                errors.add(new ErrorLSSL(1, "Error semántico {}: valor no inicializado [#,%]", id, true));
            } else {

                if (!identificadores2.get(id.lexemeRank(1)).equals(id.lexicalCompRank(-1))) {
                    System.out.println(identDataType.get(id.lexemeRank(2)) + "sas");
                    System.out.println(id.lexicalCompRank(-1) + "sas");
                    if (id.lexicalCompRank(-1).equals("IDENTIFICADOR")) {
                        if (!identificadores2.get(id.lexemeRank(1)).equals(identificadores2.get(id.lexemeRank(-1)))) {
                            System.out.println(identificadores2.get(id.lexemeRank(-1)) + "dsd");
                            System.out.println(identDataType.get(id.lexemeRank(2)) + "dsd");
                            errors.add(new ErrorLSSL(1, "Error semántico {}: valor no compatible con el tipo de dato [#,%]", id, true));
                        } else {
                            identificadores.put(id.lexemeRank(1), identificadores.get(id.lexemeRank(-1)));
                            identificadores2.put(id.lexemeRank(1), identificadores2.get(id.lexicalCompRank(-1)));
                            valores.put(id.lexemeRank(1), valores.get(id.lexemeRank(-1)));
                        }
                    } else {
                        System.out.println(!identDataType.get(id.lexemeRank(2)).equals(id.lexicalCompRank(-1)) + "sasa");
                        errors.add(new ErrorLSSL(1, "Error semántico {}: valor no compatible con el tipo de dato [#,%]", id, true));
                    }

                } else {
                    identificadores.put(id.lexemeRank(1), id.lexemeRank(-1));
                    identificadores2.put(id.lexemeRank(1), id.lexicalCompRank(-1));
                    valores.put(id.lexemeRank(1), id.lexemeRank(-1));
                    System.out.println(identificadores.get(id.lexemeRank(1)));
                    System.out.println(identificadores2.get(id.lexemeRank(1)));

                }
            }
        }
    }

    private void semanticAnalysis_V_A() {
        HashMap<String, String> identDataType = new HashMap<>();

        for (Production id : asig_prod) {
            if (identificadores2.get(id.lexemeRank(0)) == null) {
                errors.add(new ErrorLSSL(1, "Error semántico {}: variable no declarada", id, true));
            } else {
                if (!id.lexicalCompRank(-1).equals("IDENTIFICADOR")) {
                    if (identificadores2.get(id.lexemeRank(0)).equals(id.lexicalCompRank(-1))) {

                        identificadores.put(id.lexemeRank(0), id.lexicalCompRank(-1));

                    } else {
                        errors.add(new ErrorLSSL(13, "Error semántico {}: valor no compatible con el tipo de dato [#,%]", id, true));
                    }
                } else {
                    if (identificadores.get(id.lexemeRank(-1)) == null) {
                        errors.add(new ErrorLSSL(14, "Error semántico {}: valor no inicializado [#,%]", id, true));
                    } else {

                        if (identificadores2.get(id.lexemeRank(0)).equals(identificadores2.get(id.lexemeRank(-1)))) {
                            identificadores.put(id.lexemeRank(0), identificadores.get(id.lexemeRank(-1)));
                        } else {
                            errors.add(new ErrorLSSL(15, "Error semántico {}: valor no compatible con el tipo de dato [#,%]", id, true));
                        }
                    }
                }
            }
        }

    }

    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, jtpCode, new Color(40, 40, 40));
    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            jtaOutputConsole.setText("Compilación terminada...");
        }
        jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        v_n_prod.clear();
        asig_prod.clear();
        identificadores2.clear();
        s_prod.clear();
        s_s_prod.clear();
        valores.clear();
        f_prod.clear();
        c_prod.clear();
        f_v.clear();
        f_1_0.clear();
        ll_f.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    public void sacar_codigo(String cod) {
        com.clear();
        // Crea un patrón para los comentarios de una línea en Go (//)
        Pattern pattern = Pattern.compile("//.*");

        // Crea un objeto Matcher para encontrar los comentarios en el código
        Matcher matcher = pattern.matcher(cod);

        // Encuentra y imprime todos los comentarios
        while (matcher.find()) {
            // Imprime el comentario sin los caracteres //
            System.out.println(matcher.group().substring(2).trim());
            com.add(matcher.group().substring(2).trim());
        }
    }

    public void crearPDF() {
        String filename = "Comentarios.pdf";
        try {
            // Crea un nuevo documento
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24);
            Document document = new Document();

            // Crea un PdfWriter que escribe en un FileOutputStream
            PdfWriter.getInstance(document, new FileOutputStream(filename));

            // Abre el documento
            document.open();
            document.add(new Paragraph("DOCUMENTADOR DE " + getTitle(), font2));

            // Añade los primeros tres comentarios del ArrayList al documento
            for (int i = 0; i < 4; i++) {
                document.add(new Paragraph(com.get(i)));
            }

            // Añade el título "Explicación del código en lenguaje natural"
            // Añade el título "Explicación del código en lenguaje natural" en negrita
            document.add(new Paragraph("Explicación del código en lenguaje natural", font));

            // Crea una lista para los comentarios restantes
            List list = new List(List.UNORDERED);

            // Añade cada comentario restante del ArrayList a la lista
            for (int i = 4; i < com.size(); i++) {
                list.add(new ListItem(com.get(i)));
            }
            document.add(list);

            document.add(new Paragraph("LISTA DE VARIABLES:", font));
            List list2 = new List(List.UNORDERED);
            for (Production id : v_n_prod) {
                
                list2.add(new ListItem(id.lexemeRank(1)));
                System.out.println(id.lexemeRank(1));

            }
            
            // Añade la lista al documento
            
            document.add(list2);
            List list3 = new List(List.UNORDERED);
            document.add(new Paragraph("LISTA DE IMPORTACIONES:", font));
            for (Production id :impo) {
                
//                list2.add(new ListItem(id.lexemeRank(1)));
                System.out.println(id.getSizeTokens());
                for(int i=0;i<id.getSizeTokens();i++){
                    System.out.println(id.lexemeRank(i));
                    list3.add(new ListItem(id.lexemeRank(i)));
                }

            }
            document.add(list3);
            // Cierra el documento
            document.close();

            // Abre el archivo PDF automáticamente
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File(filename);
                    Desktop.getDesktop().open(myFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel buttonsFilePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
