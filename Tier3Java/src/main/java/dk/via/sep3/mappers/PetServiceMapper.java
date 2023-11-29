package dk.via.sep3.mappers;

import dk.via.sep3.shared.PetServiceEntity;
import dk.via.sep3.shared.PetServiceRequestEntity;
import origin.protobuf.ServiceProto;
import origin.protobuf.ServiceRequestProto;

public class PetServiceMapper {
    public static ServiceProto mapToProto(PetServiceEntity serviceEntity)
    {
        return ServiceProto.newBuilder()
                .setCaretakerEmail(serviceEntity.getCareTaker().getEmail())
                .setAnnouncement(AnnouncementMapper.mapToProto(serviceEntity.getAnnouncement()))
                .setStatus(serviceEntity.getStatus())
                .setPetOwnerEmail(serviceEntity.getPetOwner().getEmail())
                .build();
    }

}
