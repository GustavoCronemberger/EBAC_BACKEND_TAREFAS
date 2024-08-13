package br.com.gustavokt.DAO;

import br.com.gustavokt.Connection.ConnectionFactory;
import br.com.gustavokt.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            pstm = connection.prepareStatement(sql);
            adicionarParametrosInsert(pstm, produto);
            return pstm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, pstm, null); //Sempre tem que fechar a conexão no final para não acumular dados na memória e dar bug.
        }
    }

    private String getSqlInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO CLIENTE (CLI_NOME, CLI_CODIGO) ");
        sb.append("VALUES (?, ?)"); //Será preenchido pelo adicionarParametrosInsert como getNome e getCodigo
        return sb.toString();
    }

    private void adicionarParametrosInsert(PreparedStatement pstm, Produto produto) throws SQLException {
        pstm.setString(1, produto.getNome()); //O 1 é a primeira ?
        pstm.setString(2, produto.getCodigo());
    }

    private void closeConnection(Connection connection, PreparedStatement pstm, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (pstm != null && !pstm.isClosed()) {
                pstm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            pstm = connection.prepareStatement(sql);
            adicionarParametrosUpdate(pstm, produto);
            return pstm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, pstm, null);
        }
    }

    private void adicionarParametrosUpdate(PreparedStatement pstm, Produto produto) throws SQLException {
        pstm.setString(1, produto.getNome());
        pstm.setString(2, produto.getCodigo());
        pstm.setLong(3, produto.getId());
    }

    private String getSqlUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE CLIENTE ");
        sb.append("SET CLI_NOME = ?, CLI_CODIGO = ? ");
        sb.append("WHERE CLI_ID = ?");
        return sb.toString();
    }

    @Override
    public Produto buscar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelect();
            pstm = connection.prepareStatement(sql);
            adicionarParametrosSelect(pstm, codigo);
            rs = pstm.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                String nome = rs.getString("CLI_NOME");
                String cd = rs.getString("CLI_CODIGO");
                Long id = rs.getLong("CLI_ID");
                produto.setNome(nome);
                produto.setCodigo(cd);
                produto.setId(id);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, pstm, rs);
        }
        return produto;
    }

    private String getSqlSelect() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM CLIENTE ");
        sb.append("WHERE CLI_CODIGO = ?");
        return sb.toString();
    }

    private void adicionarParametrosSelect(PreparedStatement pstm, String codigo) throws SQLException {
        pstm.setString(1, codigo);
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Produto> list = new ArrayList<>();
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                produto = new Produto();
                Long id = rs.getLong("CLI_ID");
                String cd = rs.getString("CLI_CODIGO");
                String nome = rs.getString("CLI_NOME");
                produto.setId(id);
                produto.setCodigo(cd);
                produto.setNome(nome);
                list.add(produto);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, pstm, rs);
        }
        return list;
    }

    private String getSqlSelectAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM CLIENTE ");
        return sb.toString();
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            pstm = connection.prepareStatement(sql);
            adicionarParametrosDelete(pstm, produto);
            return pstm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, pstm, null);
        }
    }

    private void adicionarParametrosDelete(PreparedStatement pstm, Produto produto) throws SQLException {
        pstm.setString(1, produto.getCodigo());
    }

    private String getSqlDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM CLIENTE ");
        sb.append("WHERE CLI_CODIGO = ?");
        return sb.toString();
    }
}
