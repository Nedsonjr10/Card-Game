import java.util.ArrayList;

public class SistemaDeUsuarios {
    private ArrayList<Usuario> listaDeUsuarios;

    public SistemaDeUsuarios() {
        this.listaDeUsuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        listaDeUsuarios.add(usuario);
    }

    public Usuario buscarUsuarioPorCpf(int cpf) {
        for (Usuario usuario : listaDeUsuarios) {
            if (usuario.getCpf() == cpf) {
                return usuario;
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }

}
