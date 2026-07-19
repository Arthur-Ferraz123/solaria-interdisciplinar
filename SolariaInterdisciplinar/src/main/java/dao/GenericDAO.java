package dao;

import conexao.Conexao;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface para representar o esqueleto mínimo de um DAO no projeto.
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 * @param <T> Model da entidade que o DAO interage.
 */
public interface GenericDAO<T> {

    /**
     * Em caso de erro por constraint do BD essa constante deve ser retornada.
     */
    public final int ERRO_POR_CONSTRAINT_DE_DADOS_NO_BD = -1;

    /**
     * Em caso de erro relacionado ao banco de dados essa constante deve ser retornada.
     */
    public final int ERRO_NO_BD = -2;

    /**
     * Em caso de erro genérico essa constante deve ser retornada.
     */
    public final int ERRO_GENERICO = -3;

    /**
     * Realiza o insert a partir de um objeto feito pelo construtor criado para o DAO em {@link T}
     * Veja as constantes da interface para compreender como deve ser feito o tratamento de exceções.
     *
     * @param objeto Objeto feito a partir do construtor feito para o DAO.
     * @return Se nenhuma exceção for lançada retorna o número de linhas alteradas.
     */
    public int insert(T objeto);

    /**
     * Busca um {@link T} a partir do id.
     * Em caso de inexistência do id retornar null.
     *
     * @param id ID da entidade.
     * @return A entidade com todos os seus dados.
     */
    public T readById(long id);

    /**
     * Lê todos os dados contidos na tabela da entidade {@link T}.
     *
     * @return Uma lista com todos os registro da tabela.
     */
    public List<T> readAll();

    /**
     * Realiza um update a partir do construtor feito para o DAO em {@link T}
     * Veja as constantes da interface para compreender como deve ser feito o tratamento de exceções.
     *
     * @param objeto Objeto feito a partir do construtor feito para o DAO.
     * @return Se nenhuma exceção for lançada retorna o número de linhas alteradas.
     */
    public int update(T objeto);

    /**
     * Deleta um {@link T} a partir do seu ID.
     * Veja as constantes da interface para compreender como deve ser feito o tratamento de exceções.
     *
     * @param id ID da entidade.
     * @return  Se nenhuma exceção for lançada retorna o número de linhas alteradas.
     */
    public int deleteById(long id);

}

