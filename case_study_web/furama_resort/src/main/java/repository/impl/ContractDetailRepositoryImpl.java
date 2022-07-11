package repository.impl;

import dto.ContractFacility;
import model.ContractDetail;
import repository.BaseRepository;
import repository.ContractDetailRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepositoryImpl implements ContractDetailRepository {
    private static final String INSERT_CONTRACT_DETAIL_SQL = "insert into contract_detail (contract_detail_id, contract_id, attach_facility_id, quantity) values (?, ?, ?, ?);";
    private static final String SELECT_ALL_CONTRACT_DETAIL = "select * from contract_detail";
    private static final String SELECT_ALL_ATTACH_FACILITY_CONTRACT = "select contract.contract_id, contract.contract_start_date, contract.contract_end_date, contract.contract_deposit, contract.employee_id, contract.customer_id, contract.facility_id,\n" +
            " contract_detail.contract_detail_id, contract_detail.quantity,\n" +
            " attach_facility.attach_facility_id, attach_facility.attach_facility_name, attach_facility.attach_facility_cost, attach_facility.attach_facility_unit, attach_facility.attach_facility_status\n" +
            "from contract\n" +
            "left join contract_detail on contract.contract_id = contract_detail.contract_id\n" +
            "left join attach_facility on attach_facility.attach_facility_id = contract_detail.attach_facility_id \n" +
            "group by contract.contract_id;";

    @Override
    public List<ContractDetail> selectAllContractDetail() {
        List<ContractDetail> contractDetailList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("contract_detail_id"));
                int contractId = Integer.parseInt(rs.getString("contract_id"));
                int attachFacilityId = Integer.parseInt(rs.getString("attach_facility_id"));
                int quantity = Integer.parseInt(rs.getString("quantity"));

                contractDetailList.add(new ContractDetail(id, contractId, attachFacilityId, quantity));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return contractDetailList;
    }

    @Override
    public List<ContractFacility> selectAllAttachFacilityContract() {
        List<ContractFacility> contractFacilityList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ATTACH_FACILITY_CONTRACT)) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int contractId = Integer.parseInt(rs.getString("contract_id"));
                String startDate = rs.getString("contract_start_date");
                String endDate = rs.getString("contract_end_date");
                double deposit = Double.parseDouble(rs.getString("contract_deposit"));
                int employeeId = Integer.parseInt(rs.getString("employee_id"));
                int customerId = Integer.parseInt(rs.getString("customer_id"));
                int facilityId = Integer.parseInt(rs.getString("facility_id"));

                int contractDetailId;
                if (rs.getString("contract_detail_id") == null) {
                    contractDetailId = 0;
                } else {
                    contractDetailId = Integer.parseInt(rs.getString("contract_detail_id"));
                }

                int quantity;
                if (rs.getString("quantity") == null) {
                    quantity = 0;
                } else {
                    quantity = Integer.parseInt(rs.getString("quantity"));
                }

                int attachFacilityId;
                if (rs.getString("attach_facility_id") == null) {
                    attachFacilityId = 0;
                } else {
                    attachFacilityId = Integer.parseInt(rs.getString("attach_facility_id"));
                }

                String name = rs.getString("attach_facility_name");

                double cost;
                if (rs.getString("attach_facility_cost") == null) {
                    cost = 0;
                } else {
                    cost = Double.parseDouble(rs.getString("attach_facility_cost"));
                }

                String unit = rs.getString("attach_facility_unit");
                String status = rs.getString("attach_facility_status");

                contractFacilityList.add(new ContractFacility(contractId, startDate, endDate, deposit, employeeId, customerId, facilityId, contractDetailId, quantity, attachFacilityId, name, cost, unit, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return contractFacilityList;
    }

    @Override
    public void insertContractDetail(ContractDetail contractDetail) throws SQLException {
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_DETAIL_SQL)) {

            preparedStatement.setInt(1, contractDetail.getId());
            preparedStatement.setInt(2, contractDetail.getContractId());
            preparedStatement.setInt(3, contractDetail.getAttachFacilityId());
            preparedStatement.setInt(4, contractDetail.getQuantity());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
