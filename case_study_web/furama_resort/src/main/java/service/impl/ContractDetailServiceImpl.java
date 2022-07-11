package service.impl;

import dto.ContractFacility;
import model.ContractDetail;
import repository.ContractDetailRepository;
import repository.impl.ContractDetailRepositoryImpl;
import service.ContractDetailService;

import java.sql.SQLException;
import java.util.List;

public class ContractDetailServiceImpl implements ContractDetailService {
    private final ContractDetailRepository contractDetailRepository = new ContractDetailRepositoryImpl();

    @Override
    public List<ContractDetail> selectAllContractDetail() {
        return contractDetailRepository.selectAllContractDetail();
    }

    @Override
    public List<ContractFacility> selectAllAttachFacilityContract() {
        return contractDetailRepository.selectAllAttachFacilityContract();
    }

    @Override
    public void insertContractDetail(ContractDetail contractDetail) throws SQLException {
        contractDetailRepository.insertContractDetail(contractDetail);
    }
}
