package dk.via.sep3.mappers;

import dk.via.sep3.shared.PetEntity;
import dk.via.sep3.shared.PetServiceEntity;
import dk.via.sep3.shared.PetServiceRequestEntity;
import origin.protobuf.ServiceRequestProto;


public class PetServiceRequestMapper {
    public static ServiceRequestProto mapToProto(PetServiceRequestEntity serviceRequestEntity)
    {
        return ServiceRequestProto.newBuilder()
                .setInitiatorEmail(serviceRequestEntity.getInitiator().getEmail())
                .setRecipientEmail(serviceRequestEntity.getRecipient().getEmail())
                .setAnnouncementId(serviceRequestEntity.getAnnouncement().getId())
                .build();
    }
}
