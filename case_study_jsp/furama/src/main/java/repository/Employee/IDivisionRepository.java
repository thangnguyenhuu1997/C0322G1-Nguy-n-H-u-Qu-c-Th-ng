package repository.Employee;

import model.employee.Division;

import java.util.List;

public interface IDivisionRepository {
    List<Division> selectAllDivision();
}
