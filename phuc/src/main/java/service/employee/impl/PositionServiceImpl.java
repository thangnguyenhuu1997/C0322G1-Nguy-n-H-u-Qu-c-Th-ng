package service.employee.impl;

import model.employee.Position;
import repository.employee.IPositionRepository;
import repository.employee.impl.PositionRepositoryImpl;
import service.employee.IPositionService;

import java.util.List;
import java.util.Map;

public class PositionServiceImpl implements IPositionService {
    private IPositionRepository positionRepository = new PositionRepositoryImpl();


    @Override
    public List<Position> selectAll() {
        return positionRepository.selectAll();
    }

    @Override
    public Map<Integer, String> selectPosition() {
        return positionRepository.selectPosition();
    }
}
