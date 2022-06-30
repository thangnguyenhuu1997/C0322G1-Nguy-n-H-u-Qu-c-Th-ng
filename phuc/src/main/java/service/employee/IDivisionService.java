package service.employee;

import model.employee.Division;

import java.util.List;
import java.util.Map;

public interface IDivisionService {

    List<Division> selectAll();

    public Map<Integer, String> selectDivision();

}
