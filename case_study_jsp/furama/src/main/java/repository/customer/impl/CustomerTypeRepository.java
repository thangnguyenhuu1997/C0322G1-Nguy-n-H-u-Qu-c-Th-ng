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

public class CustomerTypeRepository implements ICustomerTypeRepository {
    private final String SELECT_ALL_CUSTOMER_TYPE = "SELECT * FROM customer_type;";
    @Override
    public List<CustomerType> selectAll() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_type_name = resultSet.getString("customer_type_name");
                CustomerType customerType = new CustomerType(customer_type_id,customer_type_name);
                customerTypeList.add(customerType);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return customerTypeList;
    }
}
