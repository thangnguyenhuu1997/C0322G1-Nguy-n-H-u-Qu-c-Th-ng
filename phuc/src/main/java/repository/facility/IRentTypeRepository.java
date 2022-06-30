package repository.facility;

import model.facility.RentType;

import java.util.List;
import java.util.Map;

public interface IRentTypeRepository {

    List<RentType> selectAll();

    public Map<Integer, String> selectRentType();

}
