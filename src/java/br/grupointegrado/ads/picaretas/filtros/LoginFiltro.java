package br.grupointegrado.ads.picaretas.filtros;

import br.grupointegrado.ads.picaretas.modelo.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rhuan Coltre
 */
public class LoginFiltro implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession sessao = req.getSession();
        
        if(permitirAcesso(req) || estaLogado(sessao)){
            chain.doFilter(request, response); // Chain, está chamando 
            
        } else {
            resp.sendRedirect("/Picaretas/Login");
        }
        
    }

     private boolean isArquivoRecurso(HttpServletRequest req) {
        /*
         * /imagens/perfil-padrao.jpg 
         * /css/bootstrap.min.css
         * /js/jquery-1.11.2.min.js
         *
         */
        String servletPath = req.getServletPath();
        boolean isArquivoRecurso = servletPath.startsWith("/imagens/")
                || servletPath.startsWith("/css/")
                || servletPath.startsWith("/js/")
                || servletPath.startsWith("/img/")
                || servletPath.equals("/Imagem")
                || servletPath.equals("/Erro.jsp")
                || servletPath.equals("/404.jsp");
        return isArquivoRecurso;
    }
    
    
    private boolean estaLogado(HttpSession sessao) {
        Usuario usuario = (Usuario) sessao.getAttribute("usuario_logado");
        if (usuario != null) {
            return true; // Usuario está logado
        }
        return false; // Usuario não está usuario
    }

    private boolean permitirAcesso(HttpServletRequest req) {
        String servletPath = req.getServletPath();

        if (servletPath.equals("/Login")) {
            return true; // Permite o acesso ao usuario
        }
        return false; // Nao permite acesso ao usuario
    }

    @Override
    public void destroy() {
    }

}
