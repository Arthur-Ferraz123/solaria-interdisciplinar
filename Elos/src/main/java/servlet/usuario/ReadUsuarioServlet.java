package servlet.usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/crudUsuario")
public class ReadUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        String clausulaWhereNome = request.getParameter("clausulaWhereNome");
        String clausulaWhereValor = request.getParameter("clausulaWhereValor");
        String clausulaWhereValor2 = request.getParameter("clausulaWhereValor2");
        String orderBy = request.getParameter("orderBy");


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/usuario/crudUsuario.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }

}
