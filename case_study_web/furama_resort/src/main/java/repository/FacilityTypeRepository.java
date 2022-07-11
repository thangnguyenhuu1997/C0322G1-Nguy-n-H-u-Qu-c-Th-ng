package repository;

import model.FacilityType;

import java.util.List;

public interface FacilityTypeRepository {
    List<FacilityType> selectAllFacilityType();
}
