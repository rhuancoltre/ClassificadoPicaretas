package org.apache.jsp.WEB_002dINF.paginas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/includes/head.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Arquivo head.jsp que contém o código referente a tag <head> -->\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<meta charset=\"utf-8\" />\n");
      out.write("<!-- Bootstrap core CSS -->\n");
      out.write("<link href=\"/Picaretas/css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("        <title>Picaretas Login</title>\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            /*\n");
      out.write("            Código CSS para ajustar o tamanho dos formulários\n");
      out.write("            */\n");
      out.write("            .control-group .control-label {\n");
      out.write("                width: 80px !important;\n");
      out.write("            }\n");
      out.write("            .form-horizontal .controls {\n");
      out.write("                margin-left: 100px !important;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1> PICARETAS</h1>\n");
      out.write("        <div class=\"span5\" >\n");
      out.write("            <h2>Login </h2>\n");
      out.write("            <form name=\"form-login\" method=\"POST\" action=\"Login\" \n");
      out.write("                  class=\"form-horizontal\">\n");
      out.write("                <input type=\"hidden\" name=\"acao\" value=\"login\" />\n");
      out.write("                <label>Usuario/E-mail: </label>\n");
      out.write("                <input type=\"text\" name=\"usuario\" value=\"\" />\n");
      out.write("                <br />\n");
      out.write("                <label>Senha: </label>\n");
      out.write("                <input type=\"password\" name=\"senha\" value=\"\" />\n");
      out.write("                <br />\n");
      out.write("                <br />\n");
      out.write("\n");
      out.write("                <input type=\"submit\" name=\"Entrar\" />\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"span5\" >\n");
      out.write("            <h2>Cadastro </h2>\n");
      out.write("            <form name=\"form-cadastro\" method=\"POST\" action=\"Login\"\n");
      out.write("                  class=\"form-horizontal\" style=\"float: left\"> \n");
      out.write("                <input type=\"hidden\" name=\"acao\" value=\"cadastro\" />\n");
      out.write("                <label>Apelido </label>\n");
      out.write("                <input type=\"text\" name=\"apelido\" value=\"\" />\n");
      out.write("                <br />\n");
      out.write("                <label>E-mail: </label>\n");
      out.write("                <input type=\"text\" name=\"email\" value=\"\" />\n");
      out.write("                <br />\n");
      out.write("                <label>Senha: </label>\n");
      out.write("                <input type=\"password\" name=\"senha\" value=\"\" />\n");
      out.write("                <br />\n");
      out.write("                <input type=\"submit\" name=\"Cadastrar\" />\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
