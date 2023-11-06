package origin.mappers;


import origin.protobuf.AnnouncementProto;
import origin.shared.AnnouncementEntity;

public class AnnouncementMapper {
    public static AnnouncementProto mapToProto(AnnouncementEntity announcementEntity)
    {
        return AnnouncementProto.newBuilder()
                .setPetOwnerEmail(announcementEntity.getPetOwnerEmail())
                .setDescription(announcementEntity.getDescription())
                .setTimeInterval(DateIntervalMapper.mapToProto(announcementEntity.getTimeIntervalEntity()))
                .setPet(PetMapper.mapToProto(announcementEntity.getPetEntity()))
                .setPostalCode(announcementEntity.getPostalCode())
                .setDateOfCreation(announcementEntity.getDateOfCreation())
                .build();
    }

    public static AnnouncementEntity mapToShared(AnnouncementProto announcement)
    {
        return new AnnouncementEntity(
                announcement.getPetOwnerEmail(),
                announcement.getDescription(),
                DateIntervalMapper.mapToShared(announcement.getTimeInterval()),
                PetMapper.mapToShared(announcement.getPet()),
                announcement.getPostalCode()
        );
    }
}
