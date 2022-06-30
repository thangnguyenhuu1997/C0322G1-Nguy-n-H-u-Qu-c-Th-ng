package service.customer.impl;

import model.customer.CustomerType;
import repository.customer.ICustomerTypeRepository;
import repository.customer.impl.CustomerTypeRepositoryImpl;
import service.customer.ICustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements ICustomerTypeService {
    private ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();

    @Override
    public List<CustomerType> selectAll() {
        return customerTypeRepository.selectAll();
    }
}
