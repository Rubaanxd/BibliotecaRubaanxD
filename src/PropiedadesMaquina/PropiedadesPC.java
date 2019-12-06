package PropiedadesMaquina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Clase Para Obtener propiedades del sistema
 *
 * @author Ruben Angeles
 */
public class PropiedadesPC {

    /**
     * Saca el Directorio temporal en %APPDATA%
     *
     * @return Directorio temporal en Windows
     */
    public static String getDirectorioTemporal() {
        return System.getProperty("java.io.tmpdir");
    }

    /**
     * Metodo para Obtener el nombre de la maquina
     *
     * @return Nombre de la Maquina
     */
    public static String getNombreMaquina() {
        String nombre = null;
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            nombre = localhost.getHostName();
        } catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
        }
        return nombre;
    }

    /**
     * Metodo para Obtener la IPv4 de la Maquina
     *
     * @return IP
     */
    public static String getIPv4() {
        String ip = null;
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            ip = localhost.getHostAddress();
        } catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
        }
        return ip;
    }

    /**
     * Metodo par Obtener la Direccion MAC de la maquina
     *
     * @return MAC
     */
    public static String getMAC() {
        NetworkInterface network = null;
        InetAddress localhost;
        byte[] mac = null;
        String dirFisica = null;
        try {
            localhost = InetAddress.getLocalHost();
            network = NetworkInterface.getByInetAddress(localhost);
            mac = network.getHardwareAddress();
        } catch (SocketException | UnknownHostException ex) {
            System.out.println(ex.getMessage());
        }
        for (int i = 0; i < mac.length; i++) {
            if (dirFisica == null) {
                dirFisica = (String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            } else {
                dirFisica += (String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
        }
        return dirFisica;
    }

    /**
     * Metodo para Obtener el Sistema Operativo de la Maquina
     *
     * @return Sistema Operativo
     */
    public static String getOS() {
        return System.getProperty("os.name");
    }

    /**
     * Metodo para Obtener el Nombre de Usuario en turno de la Maquina
     *
     * @return Nombre de usuario
     */
    public static String getUser() {
        return System.getProperty("user.name");
    }

    /**
     * Metodo para Obtener el Separador del Sistema
     *
     * @return Separador / o \
     */
    public static String getSeparador() {
        return System.getProperty("file.separator");
    }
    
    /**
    * Metodo para Obtener el Numero de serie de la maquina 
    * @return SerialNumber-"Numero de Serie"
    */
    public static String getSerialNumber() {
        String data = "";
        String[][] commands = new String[][]{{"CMD", "/C", "wmic bios get serialnumber"}};
        try {
            for (int i = 0; i < commands.length; i++) {
                String[] com = commands[i];
                Process process = Runtime.getRuntime().exec(com);
                //Closing output stream of the process
                process.getOutputStream().close();

                //Reading sucessful output of the command
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String s;
                while ((s = reader.readLine()) != null) {
                    data += s;
                }
                //data = reader.lines().collect(Collectors.joining());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        // Print Data
        return data.trim().replaceAll(" +", "-");
    }
    
    /**
     * Metodo para Obtener el Procesador que tiene la maquina
     * @return Name-"Procesador"
     */
    public static String getProcesador(){
        String data = "";
        String[][] commands = new String[][]{{"CMD", "/C", "wmic cpu get Name"}};
        try {
            for (int i = 0; i < commands.length; i++) {
                String[] com = commands[i];
                Process process = Runtime.getRuntime().exec(com);
                //Closing output stream of the process
                process.getOutputStream().close();

                //Reading sucessful output of the command
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String s;
                while ((s = reader.readLine()) != null) {
                    data += s;
                }
                //data = reader.lines().collect(Collectors.joining());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        // Print Data
        return data.trim().replaceAll(" +", "-");
    }
    
    /**
     * Metodo para Obtener los Discos Duros modelo y tamaño
     * @return Model="MODELO"Size="TAMAÑO EN BYTES"
     */
    public static String getDiscosDuros(){
        String data = "";
        String[][] commands = new String[][]{{"CMD", "/C", "wmic diskdrive get model,size /format:LIST"}};
        try {
            for (int i = 0; i < commands.length; i++) {
                String[] com = commands[i];
                Process process = Runtime.getRuntime().exec(com);
                //Closing output stream of the process
                process.getOutputStream().close();

                //Reading sucessful output of the command
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String s;
                while ((s = reader.readLine()) != null) {
                    data += s;
                }
                //data = reader.lines().collect(Collectors.joining());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        // Print Data
        return data.trim().replaceAll(" +", "-");
    }
}
