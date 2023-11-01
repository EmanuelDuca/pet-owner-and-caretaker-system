package origin.services;

import io.grpc.stub.StreamObserver;
import origin.DAO.AnnouncementDAO;
import origin.DAOInterfaces.AnnouncementDAOInterface;
import origin.mappers.AnnouncementMapper;
import origin.protobufClasses.Void;
import origin.protobufClasses.*;
import origin.shared.AnnouncementEntity;
import origin.shared.PetEntity;
import origin.shared.TimeIntervalEntity;

public class AnnouncementService extends AnnouncementServiceGrpc.AnnouncementServiceImplBase {

    private final AnnouncementDAOInterface announcementDAO;
    public AnnouncementService()
    {
        announcementDAO = new AnnouncementDAO();
    }

    @Override
    public void createAnnouncement(Announcement request,
                                   StreamObserver<Announcement> responseObserver) {
        AnnouncementEntity announcement = new AnnouncementEntity(
                request.getPetOwnerEmail(),
                request.getDescription(),
                new TimeIntervalEntity(request.getTimeInterval().getStartDate(), request.getTimeInterval().getFinishDate()),
                new PetEntity(
                        request.getPet().getPetName(),
                        request.getPet().getPetType(),
                        request.getPet().getWeight(),
                        request.getPet().getIsVaccinated(),
                        request.getPet().getDietDescription()
                ),
                request.getPostalCode()
        );
        AnnouncementEntity announcementRespond = announcementDAO.createAnnouncement(announcement);
        responseObserver.onNext(AnnouncementMapper.mapToProto(announcementRespond));
        responseObserver.onCompleted();

        System.out.println("An Announcement was created by: "+request.getPetOwnerEmail() +" at time: "+request.getDateOfCreation());
    }

    @Override
    public void findAnnouncements(SearchField request,
                                  StreamObserver<Announcements> responseObserver) {

    }

    @Override
    public void updateAnnouncement(Announcement request,
                                   StreamObserver<Void> responseObserver) {

    }

    @Override
    public void deleteAnnouncement(Announcement request,
                                   StreamObserver<Void> responseObserver) {

    }

}
