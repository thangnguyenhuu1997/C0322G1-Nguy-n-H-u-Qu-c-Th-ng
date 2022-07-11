package repository;

import model.Position;

import java.util.List;

public interface PositionRepository {
    List<Position> selectAllPosition();
}
