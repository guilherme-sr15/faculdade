
import org.apache.commons.dbcp.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Guilherme de Souza Rodrigues
 */

public class ConexaoBD {
    public static final String USER = "gsr";
    public static final String PASS = "gsr";
    public static final String DRIVER = "oracle.jdbc.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static ConexaoBD instance;

    private BasicDataSource dataSource; //referência para o pool de conexões
    
    private ConexaoBD() {
        dataSource = new BasicDataSource();
        dataSource.setUsername(USER);
        dataSource.setPassword(PASS);
        dataSource.setUrl(URL);
        dataSource.setDriverClassName(DRIVER);
        //dataSource.setInitialSize(10); //define nro inicial de connexões
        //dataSource.setMaxActive(10); //nro máx de conexões em paralelo
        //dataSource.setMaxIdle(10); //nro máx de conexões ociosas
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    
    public static ConexaoBD getInstance(){
        if (instance == null){
            return instance = new ConexaoBD();
        }
        return instance;
    }
}