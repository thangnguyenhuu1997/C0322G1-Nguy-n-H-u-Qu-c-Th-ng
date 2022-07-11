package service.impl;

import model.Contract;
import repository.ContractRepository;
import repository.impl.ContractRepositoryImpl;
import service.ContractService;

import java.sql.SQLException;
import java.util.List;

public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository = new ContractRepositoryImpl();

    @Override
    public List<Contract> selectAll() {
        return contractRepository.selectAll();
    }

    @Override
    public List<Contract> selectAllContract() {
        return contractRepository.selectAllContract();
    }

    @Override
    public Contract selectContract(int id) {
        return contractRepository.selectContract(id);
    }

    @Override
    public void insertContract(Contract contract) throws SQLException {
        contractRepository.insertContract(contract);
    }

    @Override
    public boolean updateContract(Contract contract) throws SQLException {
        return contractRepository.updateContract(contract);
    }

    @Override
    public boolean deleteContract(int id) throws SQLException {
        return contractRepository.deleteContract(id);
    }
}
