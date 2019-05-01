package br.com.teacherpoints.control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "backend", urlPatterns = {"/backend"})
public class backend extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //request, pegando as tags do html e transformando em variaveis
        int mes_cargo = Integer.parseInt(request.getParameter("mes_cargo"));
        int mes_lotacao = Integer.parseInt(request.getParameter("mes_lotacao"));
        int mes_adjunto = Integer.parseInt(request.getParameter("mes_adjunto"));
        int mes_titular = Integer.parseInt(request.getParameter("mes_titular"));
        int magisterio = Integer.parseInt(request.getParameter("magisterio"));
        
        //variaveis locais
        int valor_mes_cargo = mes_cargo * 6;
	int valor_mes_lotacao = mes_lotacao * 5;
	int valor_mes_carreira_adjunto = mes_adjunto * 1;
	int valor_mes_carreira_titular = mes_titular * 3;
	float valor_mes_magisterio = (float) (magisterio * 0.5);
        float total1 = valor_mes_cargo+valor_mes_lotacao+valor_mes_carreira_adjunto+valor_mes_carreira_titular+valor_mes_magisterio;
	float total2 = valor_mes_cargo+valor_mes_carreira_titular+valor_mes_magisterio;
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Teacher Points Web</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">");
            out.println("<link rel=\"shortcut icon\" href=\"ico/teacher.ico\" type=\"image/x-icon\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Pontuação</h1>");
            out.println("<h2>Soma 1: " +total1+"</h2>");
            out.println("<h2>Soma 2: " +total2+"</h2>");
            out.println("<a href=\"index.html\">[Voltar]</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
