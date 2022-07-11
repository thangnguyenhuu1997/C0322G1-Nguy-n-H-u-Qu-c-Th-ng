package service;

import dto.ContractFacility;
import model.ContractDetail;

import java.sql.SQLException;
import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> selectAllContractDetail();

    List<ContractFacility> selectAllAttachFacilityContract();

    void insertContractDetail(ContractDetail contractDetail) throws SQLException;
}
