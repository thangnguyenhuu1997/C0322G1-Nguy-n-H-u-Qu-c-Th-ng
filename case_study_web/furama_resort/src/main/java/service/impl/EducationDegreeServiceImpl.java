package service.impl;

import model.EducationDegree;
import repository.EducationDegreeRepository;
import repository.impl.EducationDegreeRepositoryImpl;
import service.EducationDegreeService;

import java.util.List;


public class EducationDegreeServiceImpl implements EducationDegreeService {
    private final EducationDegreeRepository educationDegreeRepository = new EducationDegreeRepositoryImpl();

    @Override
    public List<EducationDegree> selectAllEducationDegree() {
        return educationDegreeRepository.selectAllEducationDegree();
    }
}
