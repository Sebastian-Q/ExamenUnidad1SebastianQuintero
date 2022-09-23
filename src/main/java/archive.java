
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class archive {
    static Connection con;
    static PreparedStatement pstm;
    static Statement st;
    static ResultSet rs;
    static String newRegistro = "INSERT INTO informacion(id, nombre, primerApellido, segundoApellido, curp, fechaNacimiento, rfc) VALUE (?,?,?,?,?,?,?)";

    public static DaoArchivo insertarPersona(int id, String nombre, String primerApellido, String segundoApellido, String curp, String fechaNacimiento, String rfc) {
        DaoArchivo archivo = new DaoArchivo();
        try {
            con  = ConnectionMySQL.getConnection();
            pstm = con.prepareStatement(newRegistro);
            pstm.setInt(1, id);
            pstm.setString(2, nombre);
            pstm.setString(3, primerApellido);
            pstm.setString(4, segundoApellido);
            pstm.setString(5, curp);
            pstm.setString(6, fechaNacimiento);
            pstm.setString(7, rfc);
            int resp = pstm.executeUpdate();
            if(resp == 1){
                archivo.setId(id);
                archivo.setNombre(nombre);
                archivo.setPrimerApellido(primerApellido);
                archivo.setSegudnoApellido(segundoApellido);
                archivo.setCurp(curp);
                archivo.setFecha(fechaNacimiento);
                archivo.setRfc(rfc);
                System.out.println("Se Ingreso");
            }else{
                archivo = null;
            }
        } catch (SQLException e) {
            System.out.println("Error en el metodo Insertar: " + e.getMessage());
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar las conexiones: " + e.getMessage());
            }
        }
        return archivo;
    }

    static String traer ="SELECT id, nombre, primerApellido, segundoApellido, curp, fechaNacimiento, rfc FROM informacion WHERE curp= ?;";
    public static DaoArchivo llamar1persona (String curp) {
        DaoArchivo archivo = new DaoArchivo();
        try {
            con = ConnectionMySQL.getConnection();
            pstm = con.prepareStatement(traer);
            pstm.setString(1, curp);
            rs = pstm.executeQuery();
            while (rs.next()){
                archivo.setId(rs.getInt("id"));
                archivo.setNombre(rs.getString("nombre"));
                archivo.setPrimerApellido(rs.getString("primerApellido"));
                archivo.setSegudnoApellido(rs.getString("segundoApellido"));
                archivo.setCurp(rs.getString("curp"));
                archivo.setFecha(rs.getString("fechaNacimiento"));
                archivo.setRfc(rs.getString("rfc"));


                System.out.println("ID: " + archivo.getId());
                System.out.println("Nombre: " + archivo.getNombre());
                System.out.println("1er Apellido: " + archivo.getSegudnoApellido());
                System.out.println("2do Apellido:" + archivo.getPrimerApellido());
                System.out.println("Curp: " + archivo.getCurp());
                System.out.println("Fecha Nacimiento:" + archivo.getFecha());
                System.out.println("RFC: " + archivo.getRfc());
                System.out.println("-------------------------------------");
            }
        }catch (SQLException e) {
            System.out.println("Error en el metodo Llamar 1 persona: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar las conexiones: " + e.getMessage());
            }
        }

        return archivo;
    }
    static String actualizar="UPDATE `informacion` set nombre=?, primerApellido=?, segundoApellido=?, curp=?, fechaNacimiento=?, rfc=? WHERE id=?";
    public static DaoArchivo update(int id, String nombre, String primerApellido, String segundoApellido, String curp, String fechaNacimiento, String rfc) {
        DaoArchivo archivo = new DaoArchivo();
        try {
            con = ConnectionMySQL.getConnection();
            pstm = con.prepareStatement(actualizar);
            pstm.setString(1, nombre);
            pstm.setString(2, primerApellido);
            pstm.setString(3, segundoApellido);
            pstm.setString(4, curp);
            pstm.setString(5, fechaNacimiento);
            pstm.setString(6, rfc);
            pstm.setInt(7, id);
            System.out.println("Se Actualizo");
            pstm.executeUpdate();
        }catch (SQLException e) {
            System.out.println("Error en el metodo Actualizar: " + e.getMessage());
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar las conexiones: " + e.getMessage());
            }
        }
        return archivo;
    }


    static String delete = "DELETE FROM `informacion` WHERE rfc = ?;";
    public static DaoArchivo delete(String rfc) {
        DaoArchivo archivo = new DaoArchivo();
        try {
            con = ConnectionMySQL.getConnection();
            pstm = con.prepareStatement(delete);
            pstm.setString(1, rfc);
            System.out.println("Se Elimino");
            pstm.executeUpdate();
        }catch (SQLException e) {
            System.out.println("Error en el metodo Eliminar: " + e.getMessage());
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar las conexiones: " + e.getMessage());
            }
        }
        return archivo;
    }

    public static DaoArchivo llamar () {
        DaoArchivo archivo = new DaoArchivo();
        try {
            con = ConnectionMySQL.getConnection();
            String query = "SELECT * FROM informacion;";
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()){
                archivo.setId(rs.getInt("id"));
                archivo.setNombre(rs.getString("nombre"));
                archivo.setPrimerApellido(rs.getString("primerApellido"));
                archivo.setSegudnoApellido(rs.getString("segundoApellido"));
                archivo.setCurp(rs.getString("curp"));
                archivo.setFecha(rs.getString("fechaNacimiento"));
                archivo.setRfc(rs.getString("rfc"));


                System.out.println("ID: " + archivo.getId());
                System.out.println("Nombre: " + archivo.getNombre());
                System.out.println("1er Apellido: " + archivo.getSegudnoApellido());
                System.out.println("2do Apellido:" + archivo.getPrimerApellido());
                System.out.println("Curp: " + archivo.getCurp());
                System.out.println("Fecha Nacimiento:" + archivo.getFecha());
                System.out.println("RFC: " + archivo.getRfc());
                System.out.println("-------------------------------------");
            }
        }catch (SQLException e) {
            System.out.println("Error en el metodo Llamar: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar las conexiones: " + e.getMessage());
            }
        }

        return archivo;
    }


    /*static  String llamarRegiste = "SELECT * FROM `informacion` WHERE curp;";
        public static DaoArchivo llamar (String curp){
            DaoArchivo regis = new DaoArchivo();
            try {
                con  = ConnectionMySQL.getConnection();
                pstm = con.prepareStatement(llamarRegiste);
                regis.getId();
                regis.getNombre();
                regis.getPrimerApellido();
                regis.getSegudnoApellido();
                regis.getCurp();
                regis.getFecha();
                regis.getRfc();
                System.out.println(regis.getNombre());
            } catch (SQLException e) {
                System.out.println("Error en el metodo Mostrar: " + e.getMessage());
            } finally {
                try {
                    pstm.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar las conexiones: " + e.getMessage());
                }
            }
            return regis;
        }*/



}
