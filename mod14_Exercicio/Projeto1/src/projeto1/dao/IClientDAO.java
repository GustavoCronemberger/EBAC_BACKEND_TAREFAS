/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto1.dao;

import projeto1.domain.Cliente;

/**
 *
 * @author gusta
 */
public interface IClientDAO {
    public Boolean cadastrar (Cliente cliente);
    
    public void excluir (Long cpf);
    
    public void alterar (Cliente cliente);
    
    public Cliente consultar (Long cpf);
}
