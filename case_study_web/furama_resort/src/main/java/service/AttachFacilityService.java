package service;

import model.AttachFacility;

import java.util.List;

public interface AttachFacilityService {
    List<AttachFacility> selectAllAttachFacility();

    List<AttachFacility> selectAllAttachFacilityContract();
}
