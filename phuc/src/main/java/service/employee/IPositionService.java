package service.employee;

import model.employee.Position;

import java.util.List;
import java.util.Map;

public interface IPositionService {

    List<Position> selectAll();

    public Map<Integer, String> selectPosition();

}
