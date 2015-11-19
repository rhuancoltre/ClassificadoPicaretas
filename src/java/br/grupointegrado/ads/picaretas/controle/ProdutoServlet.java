package br.grupointegrado.ads.picaretas.controle;

import br.grupointegrado.ads.picaretas.modelo.Categoria;
import br.grupointegrado.ads.picaretas.modelo.CategoriaDao;
import br.grupointegrado.ads.picaretas.modelo.Produto;
import br.grupointegrado.ads.picaretas.modelo.ProdutoDao;
import br.grupointegrado.ads.picaretas.modelo.Usuario;
import br.grupointegrado.ads.picaretas.util.Util;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rhuan Coltre
 */
public class ProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection conexao = (Connection) req.getAttribute("conexao");
            CategoriaDao categoriaDao = new CategoriaDao(conexao);

            List<Categoria> categorias = categoriaDao.consultaTodas();

            req.setAttribute("categorias", categorias);

        } catch (Exception ex) {
            ex.printStackTrace();
            req.setAttribute("mensagem_erro", "Could not load the page data(erro ao carregar dados)");
        }

        req.getRequestDispatcher("WEB-INF/paginas/produto.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String idParam = req.getParameter("id");
            int id = Util.stringParaInt(idParam);
            //Verifica se o ID foi informado para decidir entre cadastro e alteração
            if (id > 0) {
                //Alteração
                alteracao(req, resp, id);
            } else {
                //Cadastro
                cadastrar(req, resp);
            }
            resp.sendRedirect("Consulta");
        } catch (Exception ex) {
            ex.printStackTrace();
            req.setAttribute("mensagem_erro", "Não foi publicar o produto.");
            doGet(req, resp);
        }

    }

    private void alteracao(HttpServletRequest req, HttpServletResponse resp, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools
    }

    private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {
        //Recuperando os parametros
        int categoriaParam = Util.stringParaInt(req.getParameter("categoria"));
        String descricaoParam = req.getParameter("descricao");
        String detalhesParam = req.getParameter("detalhes");
        float valorParam = Util.stringFormatadaParaFloat(req.getParameter("valor"));

        Produto prod = new Produto();
        prod.setDescricao(descricaoParam);
        prod.setDetalhes(detalhesParam);
        prod.setValor(valorParam);
        prod.setVendido(false);
        prod.setDataPostagem(new Date());

        Connection conexao = (Connection) req.getAttribute("conexao");

        CategoriaDao categoriaDao = new CategoriaDao(conexao);
        Categoria cat = categoriaDao.consultaId(categoriaParam);
        prod.setCategoria(cat);

        //Pegando usuario logado
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario_logado");
        prod.setUsuario(usuario);

        //Inserindo produto
        ProdutoDao dao = new ProdutoDao(conexao);
        dao.inserir(prod);
    }

}
