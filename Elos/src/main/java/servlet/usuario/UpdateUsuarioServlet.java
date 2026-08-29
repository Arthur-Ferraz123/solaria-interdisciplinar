package servlet.usuario;

import enums.GenericEnum;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;
import service.UsuarioService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static enums.ErrosGerais.ERRO_GENERICO;

@WebServlet("/crudUsuario-update")
public class UpdateUsuarioServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        try {

            String id = request.getParameter("idUpdate");


            Usuario usuario = UsuarioService.exibirUsuarioUpdate(id);



            if (usuario == null){

                request.setAttribute("erroUpdate", "Um erro inesperado aconteceu, tente novamente");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/usuario/crudUsuario.jsp");
                dispatcher.forward(request, response);

            } else {

                request.setAttribute("usuarioUpdate", usuario);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/usuario/crudUsuario.jsp");
                dispatcher.forward(request, response);

            }


        } catch (Exception e){

            request.setAttribute("erroUpdate", "Um erro inesperado aconteceu, tente novamente");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/usuario/crudUsuario.jsp");
            dispatcher.forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }
}
