package repository.Employee;

import model.employee.Position;

import java.util.List;

public interface IPositionRepository {
    List<Position> selectAllPosition();
}
