package servlet.usuario;

import enums.GenericEnum;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import service.UsuarioService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static enums.ErrosGerais.ERRO_GENERICO;

@WebServlet("/crudUsuario")
public class ReadUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        try {

            String clausulaWhereNome = request.getParameter("clausulaWhereNome");
            String clausulaWhereValor = request.getParameter("clausulaWhereValor");
            String clausulaWhereValor2 = request.getParameter("clausulaWhereValor2");
            String orderBy = request.getParameter("orderBy");
            String ordenacao = request.getParameter("ordenacao");

            ArrayList<GenericEnum> errosEncontrados = new ArrayList<>();

            List<Usuario> usuarios = new ArrayList<>();

            usuarios.addAll(UsuarioService.realizarSelect(clausulaWhereNome, clausulaWhereValor, clausulaWhereValor2, orderBy, ordenacao, errosEncontrados));

            List<String> errosEncontradosString = new ArrayList<>();

            for(GenericEnum  g : errosEncontrados ){

                errosEncontradosString.add(g.exibirMensagem());

                System.out.println(g.exibirMensagem());

            }

            if (!errosEncontrados.isEmpty()){

                request.setAttribute("errosEncontrados", errosEncontradosString);
                request.setAttribute("usuarios", usuarios);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/usuario/crudUsuario.jsp");
                dispatcher.forward(request, response);

            } else {

                request.setAttribute("errosEncontrados", errosEncontradosString);
                request.setAttribute("usuarios", usuarios);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/usuario/crudUsuario.jsp");
                dispatcher.forward(request, response);

            }


        } catch (Exception e){

            ArrayList<GenericEnum> errosEncontrados = new ArrayList<>();

            errosEncontrados.add(ERRO_GENERICO);

            ArrayList<String> errosEncontradosString = new ArrayList<>();

            errosEncontradosString.add(ERRO_GENERICO.exibirMensagem());

            List<Usuario> usuarios = UsuarioService.realizarSelect(null, null, null, null, null, errosEncontrados);

            request.setAttribute("errosEncontrados", errosEncontradosString);
            request.setAttribute("usuarios", usuarios);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/usuario/crudUsuario.jsp");
            dispatcher.forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }

}
