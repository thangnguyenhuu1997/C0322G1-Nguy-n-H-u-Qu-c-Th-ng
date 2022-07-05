package service.employee.impl;

import model.employee.Position;
import repository.Employee.IPositionRepository;
import repository.Employee.impl.PositionRepository;
import service.employee.IPositionService;

import java.util.List;

public class PositionService implements IPositionService {
    private IPositionRepository positionRepository = new PositionRepository();
    @Override
    public List<Position> selectAllPosition() {
        return positionRepository.selectAllPosition();
    }
}
