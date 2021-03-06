package com.rubaanxd.conexionFTPconThreads;

import com.rubaanxd.conexionFTP.SFTPConnector;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.IOException;
import java.util.Observable;

/**
 * SFTP Bajar Archivo
 * Clase para Bajar Archivos por SFTP
 * <p>
 * Esta Clase baja un Archivo por SFTP llamado "temp.pdf"
 * para poder ocuparla es necesario una conexion SFTP la cual la implementas
 * con la siguiente clase {@link com.rubaanxd.conexionFTP.SFTPConnector}.
 * <p>
 * La Implementacion de esta clase se hace en metodo {@code run()} solo tienes
 * que cambiar los parametros para conectarse a su servidor ya que los parametros
 * que tienes son de prueba local.
 * 
 * @author RubaanxD
 * @version 1.0
 * @since 2019
 */
public class SFTPBajarArchivo extends Observable implements Runnable {

    private Session session;
    private String path;
    private boolean flag;
    private String dir = System.getProperty("java.io.tmpdir")+"temp.pdf";

    public SFTPBajarArchivo(String path) {
        this.path = path;
    }

    public boolean isFlag() {
        return flag;
    }

    /**
     * Funcion que Permite descargar un archivo
     *
     * @param src es el path del archivo a descargar
     * @throws JSchException Excepcion lanzada por algun error en la ecucion del
     * comando sftp.
     * @throws SftpException Error al utilizar comando SFTP.
     * @throws IllegalAccessException Excepcion lanzada cuando no hay conexion
     * establecida.
     * @throws IOException Excepcion al leer el texto arrojado luego de la
     * ejecucion del comando SFTP.
     */
    public final void getFile(String src) throws JSchException, SftpException, IllegalAccessException, IOException {
        if (this.session != null && this.session.isConnected()) {
            ChannelSftp channelSftp = (ChannelSftp) this.session.openChannel("sftp");
            channelSftp.connect();
            channelSftp.get(src, dir);
            System.out.println("Archivo descargado Correctamente");
            //return is;
        } else {
            throw new IllegalAccessException("No Existe sesion SFTP iniciada");
        }
    }

    @Override
    public void run() {
        this.flag = true;
        while (flag) {
            try {
                System.out.println("conectando.....");
                SFTPConnector connector = new SFTPConnector("archivo", "soportemx", "192.168.40.15");
                this.session = connector.connect();
                System.out.println("Conectado");
                getFile(path);
                connector.disconnect();
                //Las siguientes 3 lineas son para abrir el archivo pdf
                ProcessBuilder pb = new ProcessBuilder();
                pb.command("cmd.exe", "/c", dir);
                pb.start();
                this.flag = false;
            } catch (JSchException | SftpException | IllegalAccessException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
        this.setChanged();
        this.notifyObservers(flag);
        this.clearChanged();
        System.out.println("Proceso Terminado");
    }

}
