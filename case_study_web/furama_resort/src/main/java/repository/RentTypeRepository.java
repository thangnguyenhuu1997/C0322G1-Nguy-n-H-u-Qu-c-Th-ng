package repository;

import model.RentType;

import java.util.List;

public interface RentTypeRepository {
    List<RentType> selectAllRentType();
}
