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
import java.util.Enumeration;
import java.util.List;

import static enums.ErrosGerais.ERRO_GENERICO;

@WebServlet("/crudUsuario")
public class ReadUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        try {
            HttpSession session = request.getSession();

            String sairPressionado = request.getParameter("sairPressionado");

            if(sairPressionado != null && sairPressionado.equalsIgnoreCase("true")){
                Enumeration<String> attributes = session.getAttributeNames();
                while(attributes.hasMoreElements()){
                    session.removeAttribute(attributes.nextElement());
                }
            }

            String clausulaWhereNome = request.getParameter("clausulaWhereNome");
            String clausulaWhereValor = request.getParameter("clausulaWhereValor");
            String clausulaWhereValor2 = request.getParameter("clausulaWhereValor2");
            String orderBy = request.getParameter("orderBy");
            String ordenacao = request.getParameter("ordenacao");

            ArrayList<GenericEnum> errosRead = new ArrayList<>();
            List<Usuario> usuariosRead = new ArrayList<>();

            usuariosRead.addAll(UsuarioService.realizarSelect(clausulaWhereNome, clausulaWhereValor, clausulaWhereValor2, orderBy, ordenacao, errosRead));

            if (!errosRead.isEmpty()){
                request.setAttribute("errosRead", errosRead);
                request.setAttribute("usuariosRead", errosRead);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/usuario/crudUsuario.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("errosRead", errosRead);
                request.setAttribute("usuariosRead", usuariosRead);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/usuario/crudUsuario.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e){
            ArrayList<GenericEnum> errosRead = new ArrayList<>();
            errosRead.add(ERRO_GENERICO);

            List<Usuario> usuariosRead = UsuarioService.realizarSelect(null, null, null, null, null, errosRead);

            request.setAttribute("errosRead", errosRead);
            request.setAttribute("usuariosRead", usuariosRead);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/usuario/crudUsuario.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
