package servlet.usuario;

import enums.ErrosGerais;
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

import static enums.ErrosGerais.ERRO_GENERICO;

@WebServlet("/crudUsuario-delete")
public class DeleteUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect(request.getContextPath() + "/crudUsuario");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String id = request.getParameter("id");

            GenericEnum erro = UsuarioService.realizarDelete(id);

            if(erro != null){

                HttpSession session = request.getSession();

                session.setAttribute("mensagem", erro.exibirMensagem());

                response.sendRedirect(request.getContextPath() + "/crudUsuario");

            } else {

                HttpSession session = request.getSession();

                session.setAttribute("mensagem", "O usuário foi deletado com sucesso!");

                response.sendRedirect(request.getContextPath() + "/crudUsuario");

            }

        } catch (Exception e){

            HttpSession session = request.getSession();

            session.setAttribute("mensagem", ERRO_GENERICO.exibirMensagem());

            response.sendRedirect(request.getContextPath() + "/crudUsuario");

        }

    }

}
