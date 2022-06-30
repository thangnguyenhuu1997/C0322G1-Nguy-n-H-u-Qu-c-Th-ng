package service.employee;

import model.employee.EducationDegree;

import java.util.List;
import java.util.Map;

public interface IEducationDegreeService {

    List<EducationDegree> selectAll();

    public Map<Integer, String> selectEducationDegree();

}
