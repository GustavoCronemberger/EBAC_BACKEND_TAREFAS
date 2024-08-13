package br.com.gustavokt.DAO;

import br.com.gustavokt.Connection.ConnectionFactory;
import br.com.gustavokt.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO{
    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement pstm = null;
        try{
            connection = ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            pstm = connection.prepareStatement(sql);
            adicionarParametrosInsert(pstm, cliente);
            return pstm.executeUpdate();
        }catch (Exception e){
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

    private void adicionarParametrosInsert(PreparedStatement pstm, Cliente cliente) throws SQLException {
        pstm.setString(1, cliente.getNome()); //O 1 é a primeira ?
        pstm.setString(2, cliente.getCodigo());
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
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer atualizar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement pstm = null;
        try{
            connection = ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            pstm = connection.prepareStatement(sql);
            adicionarParametrosUpdate(pstm, cliente);
            return pstm.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally {
            closeConnection(connection, pstm, null);
        }
    }

    private void adicionarParametrosUpdate(PreparedStatement pstm, Cliente cliente) throws SQLException {
        pstm.setString(1, cliente.getNome());
        pstm.setString(2, cliente.getCodigo());
        pstm.setLong(3, cliente.getId());
    }

    private String getSqlUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE CLIENTE ");
        sb.append("SET CLI_NOME = ?, CLI_CODIGO = ? ");
        sb.append("WHERE CLI_ID = ?");
        return sb.toString();
    }

    @Override
    public Cliente buscar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cliente cliente = null;
        try{
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelect();
            pstm = connection.prepareStatement(sql);
            adicionarParametrosSelect(pstm, codigo);
            rs = pstm.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                String nome = rs.getString("CLI_NOME");
                String cd = rs.getString("CLI_CODIGO");
                Long id = rs.getLong("CLI_ID");
                cliente.setNome(nome);
                cliente.setCodigo(cd);
                cliente.setId(id);
            }
        }catch (Exception e){
            throw e;
        } finally {
            closeConnection(connection, pstm, rs);
        }
        return cliente;
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
    public List<Cliente> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cliente> list = new ArrayList<>();
        Cliente cliente = null;
        try{
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                Long id = rs.getLong("CLI_ID");
                String cd = rs.getString("CLI_CODIGO");
                String nome = rs.getString("CLI_NOME");
                cliente.setId(id);
                cliente.setCodigo(cd);
                cliente.setNome(nome);
                list.add(cliente);
            }
        }catch (Exception e){
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
    public Integer excluir(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement pstm = null;
        try{
            connection = ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            pstm = connection.prepareStatement(sql);
            adicionarParametrosDelete(pstm, cliente);
            return pstm.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally {
            closeConnection(connection, pstm, null);
        }
    }

    private void adicionarParametrosDelete(PreparedStatement pstm, Cliente cliente) throws SQLException {
        pstm.setString(1, cliente.getCodigo());
    }

    private String getSqlDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM CLIENTE ");
        sb.append("WHERE CLI_CODIGO = ?");
        return sb.toString();
    }
}
