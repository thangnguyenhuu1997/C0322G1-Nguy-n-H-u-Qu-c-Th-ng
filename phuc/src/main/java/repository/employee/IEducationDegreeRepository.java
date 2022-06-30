package repository.employee;

import model.employee.Division;
import model.employee.EducationDegree;

import java.util.List;
import java.util.Map;

public interface IEducationDegreeRepository {

    List<EducationDegree> selectAll();

    public Map<Integer, String> selectEducationDegree();

}
