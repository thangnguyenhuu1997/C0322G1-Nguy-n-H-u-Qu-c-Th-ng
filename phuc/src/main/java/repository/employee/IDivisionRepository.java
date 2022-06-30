package repository.employee;

import model.employee.Division;

import java.util.List;
import java.util.Map;

public interface IDivisionRepository {

    List<Division> selectAll();

    public Map<Integer, String> selectDivision();

}
