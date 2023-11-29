package dk.via.sep3.mappers;

import dk.via.sep3.shared.AnnouncementEntity;
import dk.via.sep3.utils.TimestampConverter;
import origin.protobuf.AnnouncementProto;


public class AnnouncementMapper
{
    public static AnnouncementProto mapToProto(AnnouncementEntity announcementEntity)
    {

        return AnnouncementProto.newBuilder()
                .setPetOwnerEmail(announcementEntity.getPetOwner().getEmail())
                .setDescription(announcementEntity.getDescription())
                .setTimeStart(TimestampConverter.fromLocalDateTime(announcementEntity.getStartDate()))
                .setTimeFinish(TimestampConverter.fromLocalDateTime(announcementEntity.getFinishDate()))
                .setPet(PetMapper.mapToProto(announcementEntity.getPet()))
                .setPostalCode(announcementEntity.getAddress())
                .setDateOfCreation(TimestampConverter.fromLocalDateTime(announcementEntity.getDateOfCreation()))
                .setId(announcementEntity.getId())
                .build();
    }
}
