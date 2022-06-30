package repository.employee;

import model.employee.Position;

import java.util.List;
import java.util.Map;

public interface IPositionRepository {

    List<Position> selectAll();

    public Map<Integer, String> selectPosition();

}
