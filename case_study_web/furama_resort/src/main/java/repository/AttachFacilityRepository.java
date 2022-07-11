package repository;

import model.AttachFacility;

import java.util.List;

public interface AttachFacilityRepository {
    List<AttachFacility> selectAllAttachFacility();

    List<AttachFacility> selectAllAttachFacilityContract();
}
