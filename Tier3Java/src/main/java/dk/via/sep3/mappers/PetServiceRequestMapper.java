package dk.via.sep3.mappers;

import dk.via.sep3.shared.RequestEntity;
import origin.protobuf.ServiceRequestProto;


public class PetServiceRequestMapper {
    public static ServiceRequestProto mapToProto(RequestEntity serviceRequestEntity)
    {
        return ServiceRequestProto.newBuilder()
                .setInitiatorEmail(serviceRequestEntity.getInitiator().getEmail())
                .setRecipientEmail(serviceRequestEntity.getRecipient().getEmail())
                .setAnnouncementId(serviceRequestEntity.getAnnouncement().getId())
                .build();
    }
}
