import java.io.*;
import java.sql.*;

public class Principal{

    public static void main(String[] args) throws Exception{
        InputStreamReader ins = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader in = new BufferedReader(ins);
        String entrada;
        
        String url = "jdbc:postgresql://localhost:5432/banco";
        String username = "felipe";
		String password = "senha";
        Connection conexao = DriverManager.getConnection(url, username, password);

        Statement st = conexao.createStatement();
        String sql;

        sql = "DELETE FROM pets WHERE 1 = 1;";
        st.executeUpdate(sql);

        sql = "INSERT INTO pets (id, nome, nomedono, idade) VALUES "+
        "(1, 'toto', 'joao', 5),(2, 'tiu', 'pedro', 2),(3, 'tobi', 'carlos', 3);";
        st.executeUpdate(sql);

        sql = "SELECT * FROM pets;";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
            System.out.println("nome: " + rs.getString("nome"));
        System.out.println("---");

        sql = "UPDATE pets SET nome = 'toby' WHERE id = 3;";
        st.executeUpdate(sql);

        sql = "SELECT * FROM pets;";
        rs = st.executeQuery(sql);
        while(rs.next())
            System.out.println("nome: " + rs.getString("nome"));
        System.out.println("---");

        sql = "DELETE FROM pets WHERE id = 2;";
        st.executeUpdate(sql);

        st.close();
    }

}

