package service.employee.impl;

import model.employee.EducationDegree;
import repository.employee.IEducationDegreeRepository;
import repository.employee.impl.EducationDegreeRepositoryImpl;
import service.employee.IEducationDegreeService;

import java.util.List;
import java.util.Map;

public class EducationDegreeServiceImpl implements IEducationDegreeService {
    private IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepositoryImpl();


    @Override
    public List<EducationDegree> selectAll() {
        return educationDegreeRepository.selectAll();
    }

    @Override
    public Map<Integer, String> selectEducationDegree() {
        return educationDegreeRepository.selectEducationDegree();
    }
}
