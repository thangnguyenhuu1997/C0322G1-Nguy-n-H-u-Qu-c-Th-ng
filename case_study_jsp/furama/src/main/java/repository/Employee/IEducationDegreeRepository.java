package repository.Employee;

import model.employee.EducationDegree;

import java.util.List;

public interface IEducationDegreeRepository {
    List<EducationDegree> selectAllEducationDegree();
}