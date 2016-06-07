
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nuria
 */
class AccesoBD {

    /**
     * @param bd Esta variable definira cual es el nombre de nuestra base de
     * datos
     * @param url Está variable definira cual es la URL en la que se encuentra
     * nuestra bd
     * @param user Está variable definira cual es el usuario para acceder a la
     * BD
     * @param pass Está variable definira cual es el usuario
     * @param link Es de tipo Connection y sera el parametro mediante el cual se
     * definira la conexión con la BD
     */
    public String db = null;
    public String url = null;
    public String user = null;
    public String pass = null;
    Connection link = null;

    /**
     * Este metodo establece la conexión con la BD
     *
     * @return link
     */
    public Connection conectar() {

        try {
            link = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return link;
    }
   /**
    * Metodo para añadir un nuevo registro en la tabla de la base de datos
    * @param tabla nombre de la tabla en la que queremos insertar el registro
    * @param columnas nombre de las columnas que tiene la tabla
    * @param datos son los datos que queremos añadir en las columnas de nuestra tabla
    */
    
    public void Añadir(String tabla, String columnas, String datos) {

       
        try {
            PreparedStatement stmt = link.prepareStatement("INSERT INTO "+tabla+" ("+columnas+") VALUES("+datos+")");
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

}
