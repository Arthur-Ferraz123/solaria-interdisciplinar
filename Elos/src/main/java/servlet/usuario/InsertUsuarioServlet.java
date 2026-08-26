package servlet.usuario;

import enums.GenericEnum;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UsuarioService;

import java.io.IOException;
import java.util.ArrayList;

import static enums.ErrosGerais.ERRO_GENERICO;

@WebServlet("/crudUsuario-insert")
public class InsertUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/usuario/crudUsuario.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        try{

            String tipoUsuario = request.getParameter("tipoUsuario");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String nome = request.getParameter("nome");
            String raioProcuraKm = request.getParameter("raioProcuraKm");

            ArrayList<GenericEnum> mensagens = UsuarioService.realizarInsert(email, senha, nome, tipoUsuario, raioProcuraKm);

            if(!mensagens.isEmpty()){

                request.setAttribute("mensagens", mensagens);

                request.setAttribute("tipoUsuario", tipoUsuario);
                request.setAttribute("email", email);
                request.setAttribute("nome", nome);
                request.setAttribute("raioProcuraKm", raioProcuraKm);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/usuario/crudUsuario.jsp");
                dispatcher.forward(request, response);


            } else{

                HttpSession session = request.getSession();

                session.setAttribute("mensagens", mensagens);

                response.sendRedirect(request.getContextPath() + "/crudUsuario");

            }

        } catch (Exception exception){

            ArrayList<GenericEnum> mensagens = new ArrayList<>();

            mensagens.add(ERRO_GENERICO);

            request.setAttribute("mensagens", mensagens);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/usuario/crudUsuario.jsp");
            dispatcher.forward(request, response);


        }

    }

}