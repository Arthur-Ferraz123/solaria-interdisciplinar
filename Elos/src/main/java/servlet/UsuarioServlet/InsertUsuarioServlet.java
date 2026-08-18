package servlet.UsuarioServlet;

import com.sun.net.httpserver.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usuario-insert")
public class InsertUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/WEB-INF/view/Usuario/insertUsuario.jsp");

        requestDispatcher.forward(httpServletRequest, httpServletResponse);

    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException{


        String tipoUsuario = httpServletRequest.getParameter("tipoUsuario");
        String email = httpServletRequest.getParameter("email");
        String senha = httpServletRequest.getParameter("senha");
        String nome = httpServletRequest.getParameter("nome");
        String raioProcuraKm = httpServletRequest.getParameter("raioProcuraKm");


        String mensagem = null;









    }


}
