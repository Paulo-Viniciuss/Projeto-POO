import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivrariaController {
    public List<Livro> listarLivros() throws SQLException {
        List<Livro> livros = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String sql = "SELECT id_livro, nome, autor, valor FROM Livro";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id_livro");
            String nome = rs.getString("nome");
            String autor = rs.getString("autor");
            double valor = rs.getDouble("valor");

            Livro livro = new Livro(id, nome, autor, valor);
            livros.add(livro);
        }

        connection.close();
        return livros;
    }

    public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String sql = "SELECT ID_cliente, nome, email FROM Cliente";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("ID_cliente");
            String nome = rs.getString("nome");
            String email = rs.getString("email");

            Cliente cliente = new Cliente(id, nome, email);
            clientes.add(cliente);
        }

        connection.close();
        return clientes;
    }
}
