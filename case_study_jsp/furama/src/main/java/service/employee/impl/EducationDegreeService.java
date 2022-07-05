package service.employee.impl;

import model.employee.EducationDegree;
import repository.Employee.IEducationDegreeRepository;
import repository.Employee.impl.EducationDegreeRepository;
import service.employee.IEducationDegreeService;

import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {
    private IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();
    @Override
    public List<EducationDegree> selectAllEducationDegree() {
        return educationDegreeRepository.selectAllEducationDegree();
    }
}
