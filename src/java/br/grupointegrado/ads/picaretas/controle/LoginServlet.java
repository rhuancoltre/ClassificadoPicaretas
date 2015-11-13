package br.grupointegrado.ads.picaretas.controle;

import br.grupointegrado.ads.picaretas.modelo.Usuario;
import br.grupointegrado.ads.picaretas.modelo.UsuarioDao;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        //Verificando se o usuario enviou atraves do formulario Login ou Cadastro
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
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //Passando apelido e senha como uma String.
            String apelido = req.getParameter("apelido");
            String senha = req.getParameter("senha");
            //Fazendo uma Conexao
            Connection conexao = (Connection) req.getAttribute("conexao"); 
            UsuarioDao dao = new UsuarioDao(conexao);   // Pegando do Banco o Usuario

            Usuario usuario = dao.consultaEmailSenha(apelido, senha);
            if (usuario != null) {
                //logado
                HttpSession sessao = req.getSession();
                sessao.setAttribute("usuario_logado", usuario);
                resp.sendRedirect("Consulta");
            } else {
                //Usuario ou senha incorreto
                req.setAttribute("mensagem_erro", "Apelido/E-mail ou senha incorretos");
                doGet(req, resp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            req.setAttribute("mensagem_erro", "Ocorreu um erro inesperado.");
            doGet(req, resp);
        }
    }

    /**
     * Realiza o cadastro do novo usuário no banco de dados
     *
     * @param req
     * @param resp
     */
    private void cadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            UsuarioDao dao = new UsuarioDao(conexao);
            dao.inserir(usuario);

        } catch (Exception ex) {
            ex.printStackTrace();
            req.setAttribute("mensagem_erro", "Ocorreu um erro inesperado.");
            doGet(req, resp);
        }
    }

}
