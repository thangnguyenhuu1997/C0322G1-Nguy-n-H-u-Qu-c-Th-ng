package repository.impl;

import model.Contract;
import repository.BaseRepository;
import repository.ContractRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {
    private static final String INSERT_CONTRACT_SQL = "insert into contract (contract_id, contract_start_date, contract_end_date, contract_deposit, employee_id, customer_id, facility_id) values (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_CONTRACT_BY_ID = "select * from contract where contract_id = ?;";
    private static final String SELECT_ALL_CONTRACT = "select * from contract where flag = 0";
    private static final String SELECT_ALL= "select * from contract";
    private static final String UPDATE_CONTRACT_SQL = "update contract set contract_start_date = ?, contract_end_date = ?, contract_deposit = ?, employee_id = ?, customer_id = ?, facility_id = ? where contract_id = ?;";
    private static final String DELETE_CONTRACT_SQL = "update contract set flag = 1 where contract_id = ?;";

    @Override
    public List<Contract> selectAll() {
        List<Contract> contractList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("contract_id"));

                String startDate = rs.getString("contract_start_date");
                String endDate = rs.getString("contract_end_date");

                double deposit = Double.parseDouble(rs.getString("contract_deposit"));
                int employeeId = Integer.parseInt(rs.getString("employee_id"));

                int customerId = Integer.parseInt(rs.getString("customer_id"));
                int facilityId = Integer.parseInt(rs.getString("facility_id"));

                contractList.add(new Contract(id, startDate, endDate, deposit, employeeId, customerId, facilityId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return contractList;
    }

    @Override
    public List<Contract> selectAllContract() {
        List<Contract> contractList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("contract_id"));

                String startDate = rs.getString("contract_start_date");
                String endDate = rs.getString("contract_end_date");

                double deposit = Double.parseDouble(rs.getString("contract_deposit"));
                int employeeId = Integer.parseInt(rs.getString("employee_id"));

                int customerId = Integer.parseInt(rs.getString("customer_id"));
                int facilityId = Integer.parseInt(rs.getString("facility_id"));

                contractList.add(new Contract(id, startDate, endDate, deposit, employeeId, customerId, facilityId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return contractList;
    }

    @Override
    public Contract selectContract(int id) {
        Contract contract = null;

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String startDate = rs.getString("contract_start_date");
                String endDate = rs.getString("contract_end_date");

                double deposit = Double.parseDouble(rs.getString("contract_deposit"));
                int employeeId = Integer.parseInt(rs.getString("employee_id"));

                int customerId = Integer.parseInt(rs.getString("customer_id"));
                int facilityId = Integer.parseInt(rs.getString("facility_id"));

                contract = new Contract(id, startDate, endDate, deposit, employeeId, customerId, facilityId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return contract;
    }

    @Override
    public void insertContract(Contract contract) throws SQLException {
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_SQL)) {

            preparedStatement.setInt(1, contract.getId());

            preparedStatement.setDate(2, Date.valueOf(contract.getStartDate()));
            preparedStatement.setDate(3, Date.valueOf(contract.getEndDate()));

            preparedStatement.setDouble(4, contract.getDeposit());
            preparedStatement.setInt(5, contract.getEmployeeId());

            preparedStatement.setInt(6, contract.getCustomerId());
            preparedStatement.setInt(7, contract.getFacilityId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean updateContract(Contract contract) throws SQLException {
        boolean rowUpdated = false;

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACT_SQL)) {

            preparedStatement.setDate(1, Date.valueOf(contract.getStartDate()));
            preparedStatement.setDate(2, Date.valueOf(contract.getEndDate()));

            preparedStatement.setDouble(3, contract.getDeposit());
            preparedStatement.setInt(4, contract.getEmployeeId());

            preparedStatement.setInt(5, contract.getCustomerId());
            preparedStatement.setInt(6, contract.getFacilityId());

            preparedStatement.setInt(7, contract.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            printSQLException(e);
        }

        return rowUpdated;
    }

    @Override
    public boolean deleteContract(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CONTRACT_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
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
