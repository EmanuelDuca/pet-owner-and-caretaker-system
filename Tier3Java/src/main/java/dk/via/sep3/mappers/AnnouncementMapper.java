package dk.via.sep3.mappers;

import dk.via.sep3.shared.AnnouncementEntity;
import origin.protobuf.AnnouncementProto;


public class AnnouncementMapper
{
    public static AnnouncementProto mapToProto(AnnouncementEntity announcementEntity)
    {

        return AnnouncementProto.newBuilder()
                .setPetOwnerEmail(announcementEntity.getPetOwner().getEmail())
                .setDescription(announcementEntity.getDescription())
                .setTimeStart(announcementEntity.getStartDate())
                .setTimeFinish(announcementEntity.getFinishDate())
                .setPet(PetMapper.mapToProto(announcementEntity.getPet()))
                .setPostalCode(announcementEntity.getAddress())
                .setDateOfCreation(announcementEntity.getDateOfCreation())
                .setId(announcementEntity.getId())
                .build();
    }
}
