package br.grupointegrado.ads.picaretas.controle;

import br.grupointegrado.ads.picaretas.modelo.Usuario;
import br.grupointegrado.ads.picaretas.modelo.UsuarioDAO;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rhuan Coltre
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/paginas/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acaoParam = req.getParameter("acao");
        if ("login".equals(acaoParam)) {
            login(req, resp);
        } else if ("cadastro".equals(acaoParam)) {
            cadastro(req, resp);
        }

    }

    /**
     * Efetua o login com o usuário e senha informados
     *
     * @param req
     * @param resp
     */
    private void login(HttpServletRequest req, HttpServletResponse resp) {
        try {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Realiza o cadastro do novo usuário no banco de dados
     *
     * @param req
     * @param resp
     */
    private void cadastro(HttpServletRequest req, HttpServletResponse resp) {
        try {
            //Recupera os paramentos do formulario(.jsp)
            String apelido = req.getParameter("apelido");
            String email = req.getParameter("email");
            String senha = req.getParameter("senha");
            //Cria um novo objeto com os parametros vindo do formulário
            Usuario usuario = new Usuario();
            usuario.setApelido(apelido);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            //Recupero a conexão aberta pelo filtro
            Connection conexao = (Connection) req.getAttribute("conexao");
            // Cria uma Instancia do DAO
            UsuarioDAO dao = new UsuarioDAO(conexao);
            dao.inserir(usuario);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
