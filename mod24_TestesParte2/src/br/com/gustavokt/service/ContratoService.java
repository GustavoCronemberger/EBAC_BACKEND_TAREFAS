package br.com.gustavokt.service;

import br.com.gustavokt.dao.IContratoDao;

public class ContratoService implements IContratoService{

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvarTest() {
        contratoDao.salvarTest();
        return "Salvado com sucesso";
    }

    @Override
    public String buscarTest() {
        contratoDao.buscarTest();
        return "Encontrado com sucesso";
    }

    @Override
    public String atualizarTest() {
        contratoDao.atualizarTest();
        return "Atualizado com sucesso";
    }

    @Override
    public String excluirTest() {
        contratoDao.excluirTest();
        return "Excluído com sucesso";
    }
}
