/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto1.dao;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import projeto1.domain.Cliente;

/**
 *
 * @author gusta
 */
public class ClienteMapDAO implements IClientDAO{
    private Map<Long, Cliente> map;
    public ClienteMapDAO(){
        map = new TreeMap<>();
    }
    
    
    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (map.containsKey(cliente.getCpf())){
            return false;
        }
            map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = map.get(cpf);
        if(clienteCadastrado != null){
            map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = map.get(cliente.getCpf());
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setCpf(cliente.getCpf());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
        
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }
    

    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }

}
