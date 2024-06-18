import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class LivrariaView extends JFrame {
    private LivrariaController controller;

    public LivrariaView() {
        setTitle("Livraria Simples");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        controller = new LivrariaController();

        try {
            List<Livro> livros = controller.listarLivros();
            JList<Livro> livroJList = new JList<>(livros.toArray(new Livro[0]));
            add(new JScrollPane(livroJList), BorderLayout.CENTER);

            List<Cliente> clientes = controller.listarClientes();
            JList<Cliente> clienteJList = new JList<>(clientes.toArray(new Cliente[0]));
            add(new JScrollPane(clienteJList), BorderLayout.EAST);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LivrariaView view = new LivrariaView();
            view.setVisible(true);
        });
    }
}
