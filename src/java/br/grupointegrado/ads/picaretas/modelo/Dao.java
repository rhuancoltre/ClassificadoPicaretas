package br.grupointegrado.ads.picaretas.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rhuan Coltre
 */
public abstract class Dao<T> {

    //Conexão PROTECTED para acessar nas heranças/ Pois protected consegue puxar por herança e PRIVATE nao.
    protected Connection conexao;

    public Dao(Connection conexao) {
        this.conexao = conexao;
    }

    public abstract void inserir(T objeto) throws SQLException;

    public abstract void remover(T objeto) throws SQLException;

    public abstract void atualizar(T objeto) throws SQLException;

    public abstract T consultaId(int... ids) throws SQLException;
    
    /**
     * Método para executar comandos do Banco de Dados. (Como INSERT, DELETE,
     * UPDATE, ALTER TABLE, ... etc)
     *
     * @param sql
     * @param parametros
     * @throws SQLException
     */
    public void executaSql(String sql, Object... parametros) throws SQLException {
        //Object... significa que pegará todos os objetos
        PreparedStatement ps = conexao.prepareStatement(sql);

        if (parametros != null) { //Verificando se ele nao esta vindo vazio
            for (int i = 0, j = 1; i < parametros.length; i++, j++) {
                Object obj = parametros[i];
                ps.setObject(j, obj);
            }
        }
        ps.execute();
        ps.close();

    }

    /**
     * Realiza uma consulta GENÉRICA no Banco de Dados e retorna um LIST de
     * Objetos
     *
     * @param sql
     * @param parametros
     * @return
     * @throws SQLException
     */
    public List<T> consultaSql(String sql, Object... parametros) throws SQLException {
        PreparedStatement ps = conexao.prepareStatement(sql);
        if (parametros != null) { //Verificando se parametros nao esta vindo vazio
            for (int i = 0, j = 1; i < parametros.length; i++, j++) {
                Object obj = parametros[i];
                ps.setObject(j, obj);
            }
        }
        ResultSet resultado = ps.executeQuery();
        List<T> objetos = new ArrayList<T>();

        while (resultado.next()) {
            T objeto = montaObjeto(resultado);
            objetos.add(objeto);
        }

        return objetos;

    }

    /**
     * Metodo que será implementado nas heranças, onde recebe um ResultSet e
     * retorna Objeto final
     *
     * @param resultado
     * @return
     */
    public abstract T montaObjeto(ResultSet resultado)  throws SQLException ;

}
