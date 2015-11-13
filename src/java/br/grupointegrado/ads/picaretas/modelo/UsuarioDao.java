package br.grupointegrado.ads.picaretas.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author Rhuan Coltre
 */
public class UsuarioDao extends Dao<Usuario> {

    public UsuarioDao(Connection conexao) {
        super(conexao);
    }

    @Override
    public void inserir(Usuario objeto) throws SQLException {
        String sql = " INSERT INTO usuario (email, apelido, senha, telefone) "
                + " VALUES (?, ?, ?, ?) ";

        executaSql(sql,
                objeto.getEmail(), objeto.getApelido(), objeto.getSenha(), objeto.getTelefone());

    }

    @Override
    public void remover(Usuario objeto) throws SQLException {
        String sql = " DELETE FROM usuario WHERE id = ? ";

        executaSql(sql, objeto.getId());
    }

    @Override
    public void atualizar(Usuario objeto) throws SQLException {
        String sql = " UPDATE usuario SET email = ?, apelido = ?, senha = ?,  telefone = ? "
                + " WHERE id = ? ";

        executaSql(sql,
                objeto.getApelido(), objeto.getEmail(), objeto.getTelefone(), objeto.getSenha());
        objeto.getId();
    }

    public void atualizarImagem(Usuario usuario, Imagem imagem) throws SQLException {

        String sql = " UPDATE usuario SET id_imagem = ? WHERE id = ? ";
        executaSql(sql, imagem.getId(), usuario.getId());

    }

    @Override
    public Usuario montaObjeto(ResultSet resultado) throws SQLException {
        Usuario u = new Usuario();

        u.setId(resultado.getInt("id"));
        u.setApelido(resultado.getString("apelido"));
        u.setEmail(resultado.getString("email"));
        u.setTelefone(resultado.getString("telefone"));
        u.setSenha(resultado.getString("senha"));

        return u;
    }

    public Usuario consultaEmailSenha(String apelidoEmail, String senha) throws SQLException {
        String sql = " SELECT * FROM usuario WHERE senha = ? AND "
                + " ( apelido = ? OR email = ?) ";

        List<Usuario> usuarios = consultaSql(sql,
                senha,
                apelidoEmail,
                apelidoEmail); // Apelido E-mail duas vezes porque ele pega no banco onde esta comparando se é Email ou Usuario

        //Se a lista está vazia, então retorna nulo
        if (usuarios.isEmpty()) {
            return null;
        }
        // Se existem objetos na Lista, então retorna o primeiro
        return usuarios.get(0);

    }

    public Usuario consultaId(int... Ids) throws SQLException {
        String sql = " SELECT * FROM usuario WHERE id = ? ";

        List<Usuario> usuarios = consultaSql(sql, Ids[0]);

        //Comparando se produtos for vazio.
        if (usuarios.isEmpty()) {
            return null;
        }
        //(SE NAO) Se usuario nao for nulo, entao retorna primeira posição
        return usuarios.get(0);

    }
}
