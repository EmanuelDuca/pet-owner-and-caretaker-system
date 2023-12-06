package dk.via.sep3.mappers;

import dk.via.sep3.model.ServiceEntity;
import origin.protobuf.ServiceProto;

public class ServiceMapper {
    public static ServiceProto mapToProto(ServiceEntity serviceEntity)
    {
        return ServiceProto.newBuilder()
                .setId(serviceEntity.getId())
                .setCaretakerEmail(serviceEntity.getCareTaker().getEmail())
                .setAnnouncement(AnnouncementMapper.mapToProto(serviceEntity.getAnnouncement()))
                .setStatus(serviceEntity.getStatus())
                .setPetOwnerEmail(serviceEntity.getPetOwner().getEmail())
                .build();
    }

}
