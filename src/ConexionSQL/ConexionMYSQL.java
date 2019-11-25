package ConexionSQL;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben Angeles
 */
public class ConexionMYSQL {

    /**
     * Constructores
     */
    
    /**
     * Constructor Vacio
     */
    public ConexionMYSQL() {
    }
    /**
     * Constructor donde se le pasan todos los Valores de una Vez
     * @param ip Es la IP del Servidor aen el cual esta alojado nuestra DB
     * @param db Es el nombre de nuestra DB 
     * @param user Es el UserName con el cual ingresaremos
     * @param pass Es la Contraseña con la cual ingresaremos
     */
    public ConexionMYSQL(String ip,String db, String user, String pass) {
        this.ip = ip;
        this.db = db;
        this.user = user;
        this.pass = pass;
    }
    
    /**
     * Metodos
     */
    
    /**
     * Metodo para Conectarse a la DB.
     * Es necesario haber llenado todos los Fields u Ocupado el Constructor 
     * Completo.
     * @return  Devuelve Objeto Connection con el cual podremos ejecutar los Querys 
     *          posteriormente.
     */
    public Connection connect(){
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
       }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null,"Error en la Conexión");
       }
       return link;
    }
    /**
     * Metodo para ejecutar Consultas a la DB
     * @param Query Es un String con el Query de consulta
     * @return Devuelve el valor de la consulta almacenado en un RS
     * @throws SQLException  Error en la Sintaxis del Query
     */
    public ResultSet consulta(String Query) throws SQLException{
        Statement s = link.createStatement();
        ResultSet rs = s.executeQuery(Query);
        return rs;
    }
    /**
     * Metodo para ejecutar el INSERT, UPDATE, DELETE o MERGE a la DB
     * @param Query Es un String con el Query de consulta
     * @throws SQLException Error en la Sintaxis del Query
     */
    public void executeQuery (String Query) throws SQLException{
        System.out.println("Preparando el Query");
        Statement s = link.createStatement();
        s.executeUpdate(Query);
        System.out.println("Query ejecutado con Exito");
    }
    /**
     * Metodo para Deconectarse de la DB
     * @throws SQLException Devuelve este error en caso de no haber conexion 
     *                      previamente establecida
     */    
    public void disconnect() throws SQLException{
        link.close();
    }
    
    
    /**
    * Setters & Getters
    */

    /**
     * @return El Nombre de la Base de Datos
     */
    public String getDb() {
        return db;
    }

    /**
     * @param db El Nombre de la Base de Datos a ingresar
     */
    public void setDb(String db) {
        this.db = db;
    }

    /**
     * @return Devuelve la URl completa
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url es la IP del Servidor
     * La estructura seria la siguiente:
     * jdbc:mysql://+ip+/+DBName
     */
    public void setUrl(String url) {
        this.url = this.url+"/"+url+this.db;
    }

    /**
     * @return Devuelve el Usuario
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user El Nombre de Usuario a Ingresar
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return Devuelve la Contraseña
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass La Contraseña a Ingresar
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    /**
     * Declaracion de Variables
     */
    private String db;
    private String ip;
    private String url = "jdbc:mysql://"+ip+"/"+db;
    private String user;
    private String pass;
    private Connection link = null;
}