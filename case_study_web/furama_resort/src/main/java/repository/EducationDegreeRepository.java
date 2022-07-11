package repository;

import model.EducationDegree;

import java.util.List;

public interface EducationDegreeRepository {
    List<EducationDegree> selectAllEducationDegree();
}
