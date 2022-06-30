package repository.customer.impl;

import model.customer.CustomerType;
import repository.BaseRepository;
import repository.customer.ICustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerTypeRepositoryImpl implements ICustomerTypeRepository {
    private final String SELECT_ALL_CUSTOMER_TYPE = "SELECT * FROM customer_type;";

    @Override
    public List<CustomerType> selectAll() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                CustomerType customerType = new CustomerType(customerTypeId,customerTypeName);
                customerTypeList.add(customerType);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return customerTypeList;
    }

    public Map<Integer, String> selectAllCustomerType() {
        Map<Integer, String> map = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                map.put(customerTypeId,customerTypeName);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return map;
    }
}
