package service.impl;

import model.Position;
import repository.PositionRepository;
import repository.impl.PositionRepositoryImpl;
import service.PositionService;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository = new PositionRepositoryImpl();

    @Override
    public List<Position> selectAllPosition() {
        return positionRepository.selectAllPosition();
    }
}
