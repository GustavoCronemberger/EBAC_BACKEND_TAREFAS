package br.com.gustavokt.exVendas.DAO.generics;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import br.com.gustavokt.exVendas.domain.IPersistente;


public abstract class GenericDAO<T extends IPersistente> implements IGenericDAO<T> {
	
	protected Map<Class, Map<Long, T>> map;
	
	public abstract Class<T> getTipoClass();
	
	public abstract void atualizarDados(T entity, T entityCadastrado);
	
	public GenericDAO() {
		if (this.map == null) {
			this.map = new HashMap<>();
		}
	}

	@Override
	public Boolean cadastrar(T entity) {
		Map<Long, T> mapaInterno = this.map.get(getTipoClass());
		if (mapaInterno.containsKey(entity.getCodigo())) {
			return false;
		}
		mapaInterno.put(entity.getCodigo(), entity);
		return true;

	}

	@Override
	public void excluir(Long valor) {
		Map<Long, T> mapaInterno = this.map.get(getTipoClass());
		T objCadastrado = mapaInterno.get(valor);
		if(objCadastrado != null) {
			this.map.remove(valor, objCadastrado);
		}
	}
		
	

	@Override
	public void alterar(T entity) {
		Map<Long, T> mapaInterno = this.map.get(getTipoClass());
		T objCadastrado = mapaInterno.get(entity.getCodigo());
		if(objCadastrado != null) {
			atualizarDados(entity, objCadastrado);
		}
		
	}

	@Override
	public T consultar(Long valor) {
		Map<Long, T> mapaInterno = this.map.get(getTipoClass());
		return mapaInterno.get(valor);
	}

	@Override
	public Collection<T> buscarTodos() {
		Map<Long, T> mapaInterno = this.map.get(getTipoClass());
		return mapaInterno.values();
	}
	
	

}
