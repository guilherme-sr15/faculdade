
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @author Guilherme de Souza Rodrigues
 */

public class EmpregadoBD {
    
    public void salvar(Empregado emp)  throws SQLException {
        ConexaoBD conexao = ConexaoBD.getInstance();
        Connection con = null;
        PreparedStatement pStat = null;
        String sql = "insert into empregado (nome, cpf) values (?,?)";
        
        try {
            con = conexao.getConnection();
            pStat = con.prepareStatement(sql);
            pStat.setString(1, emp.getNome());
            pStat.setString(2, emp.getCpf());
            int exec = pStat.executeUpdate();
        }finally {
            try{
                fecharRecursos(con, pStat);   
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
     public void remover(Empregado emp)  throws SQLException {
        ConexaoBD conexao = ConexaoBD.getInstance();
        Connection con = null;
        PreparedStatement pStat = null;
        String sql = "delete from empregado where cpf = ?";        
        try {
            con = conexao.getConnection();
            pStat = con.prepareStatement(sql);
            pStat.setString(1, emp.getCpf());
            int exec = pStat.executeUpdate();
        }finally {
             try{
                fecharRecursos(con, pStat);   
            } catch (Exception e){
                e.printStackTrace();
            } 
        }
    }
     
    public void alterar(String nome,Empregado emp)  throws SQLException {
        ConexaoBD conexao = ConexaoBD.getInstance();
        Connection con = null;
        PreparedStatement pStat = null;
        String sql = "update empregado set nome = ? where cpf = ?";
        
        try {
            con = conexao.getConnection();
            pStat = con.prepareStatement(sql);
            pStat.setString(1, nome);
            pStat.setString(2, emp.getCpf());
            int exec = pStat.executeUpdate();
        }finally {
            try{
                fecharRecursos(con, pStat);   
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    private void fecharRecursos(AutoCloseable c1, AutoCloseable c2) throws Exception {
        if(c1 != null){
            c1.close();
            if(c2 != null)
                c2.close();
        }
    }
}
