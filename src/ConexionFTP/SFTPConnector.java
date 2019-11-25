package ConexionFTP;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.IOException;

public class SFTPConnector {

    /**
     * CONSTRUCTORES
     */
    
    /**
     * Constructor Vacio
     */
    public SFTPConnector(){
    }
    /**
     * Constuctor donde el puerto es Default (22) 
     * @param USERNAME  Nombre de Usuario FTP
     * @param PASSWORD  Password de usuario FTP
     * @param HOST      IP del Host donde esta nuestro servidor ftp
     */
    public SFTPConnector(String USERNAME, String PASSWORD, String HOST) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.HOST = HOST;
        this.PORT = 22;
    }
    /**
     * Constructor Completo
     * @param USERNAME  Nombre de Usuario FTP
     * @param PASSWORD  Password de usuario FTP
     * @param HOST      IP del Host donde esta nuestro servidor ftp
     * @param PORT      Puerto para acceder a nuestro host
     */
    public SFTPConnector(String USERNAME, String PASSWORD, String HOST, int PORT) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.HOST = HOST;
        this.PORT = PORT;
    }
    
    

    /**
     * Establece una  conexion a un servidor SFTP
     * @return Se devuelve la sesion abierta.
     * @throws JSchException Cualquier Error al establecer conexion SFTP
     * @throws IllegalAccessException Indcica que ya existe una conexion SFTP establecida
     */
    public Session connect() throws JSchException, IllegalAccessException {
        if (this.session == null || !this.session.isConnected()) {
            JSch jSch = new JSch();
            this.session = jSch.getSession(this.USERNAME, this.HOST, this.PORT);
            this.session.setPassword(this.PASSWORD);
            this.session.setConfig("StrictHostKeyChecking", "no");
            this.session.connect();
            return session;
        }else{
            throw new IllegalAccessException("Sesion SFTP ya iniciada");
        }
    }
    /**
     * Añade un archivo al directorio FTP usando SFTP.
     * @param ftpPath Path del directorio FTP o destino.
     * @param filePath Path original del Archivo a subir.
     * @param fileName Nombre que tendra el archivo en el destino.
     * @throws IllegalAccessException   Excepcion lanzada cuando no hay conexion establecida.
     * @throws JSchException            Excepcion lanzada por algun error en la ecucion del comando sftp.
     * @throws SftpException            Error al utilizar comando SFTP.
     * @throws IOException              Excepcion al leer el texto arrojado luego de la ejecucion del comando SFTP.
     */
    public final void addFile(String ftpPath,String filePath,String fileName) throws IllegalAccessException, JSchException, SftpException, IOException{
        if (this.session != null && this.session.isConnected()) {
            ChannelSftp channelSftp = (ChannelSftp) this.session.openChannel("sftp"); //Abre el canal SFTP
            //channelSftp.cd(ftpPath); //Cambiamos a la ubicacion de Destino
            channelSftp.connect();
            System.out.println(String.format("Creando archivo %s en el directorio %s", fileName,ftpPath));
            channelSftp.put(filePath, fileName); //Subimos el archivo con el path de destino y con el nombre
            System.out.println("Archivo subido Exitosamente");
            channelSftp.exit();
            channelSftp.disconnect();
        }else{
            throw new IllegalAccessException("No Existe sesion SFTP iniciada");
        }
    }
    /**
     * Funcion que Permite descargar un archivo 
     * @param src es el path del archivo a descargar
     * @throws JSchException            Excepcion lanzada por algun error en la ecucion del comando sftp.
     * @throws SftpException            Error al utilizar comando SFTP.
     * @throws IllegalAccessException   Excepcion lanzada cuando no hay conexion establecida. 
     * @throws IOException              Excepcion al leer el texto arrojado luego de la ejecucion del comando SFTP.
     */
    public final void getFile(String src) throws JSchException, SftpException, IllegalAccessException, IOException{
        if (this.session != null && this.session.isConnected()) {
            ChannelSftp channelSftp = (ChannelSftp)this.session.openChannel("sftp");
            channelSftp.connect();
            channelSftp.get(src, "C:\\Users\\Ruben Angeles\\Desktop\\Scan\\temp.pdf");
            System.out.println("Archivo descargado Correctamente");
            //return is;
        }else{
            throw new IllegalAccessException("No Existe sesion SFTP iniciada");
        }
    }
    /**
     * Cierra la sesion SFTP
     */
    public final void disconnect(){
        this.session.disconnect();
    }
    
    /**
     * Setters & Getters
     */
    
    /**
     * @return the USERNAME
     */
    public String getUSERNAME() {
        return USERNAME;
    }

    /**
     * @param USERNAME the USERNAME to set
     */
    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    /**
     * @return the PASSWORD
     */
    public String getPASSWORD() {
        return PASSWORD;
    }

    /**
     * @param PASSWORD the PASSWORD to set
     */
    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    /**
     * @return the HOST
     */
    public String getHOST() {
        return HOST;
    }

    /**
     * @param HOST the HOST to set
     */
    public void setHOST(String HOST) {
        this.HOST = HOST;
    }

    /**
     * @return the PORT
     */
    public int getPORT() {
        return PORT;
    }

    /**
     * @param PORT the PORT to set
     */
    public void setPORT(int PORT) {
        this.PORT = PORT;
    }
    
    /**
     * Declaracion de Variables
     */
    private Session session;
    private String USERNAME,PASSWORD,HOST;
    private int PORT;
}