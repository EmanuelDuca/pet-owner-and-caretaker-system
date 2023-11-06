package origin.services;

import io.grpc.stub.StreamObserver;
import origin.DAO.AnnouncementDAO;
import origin.DAOInterfaces.AnnouncementDAOInterface;
import origin.mappers.AnnouncementMapper;
import origin.protobuf.AnnouncementProto;
import origin.protobuf.AnnouncementServiceGrpc;
import origin.protobuf.AnnouncementsProto;
import origin.protobuf.SearchFieldProto;
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
    public void createAnnouncement(AnnouncementProto request,
                                   StreamObserver<AnnouncementProto> responseObserver) {
        AnnouncementEntity announcement = new AnnouncementEntity(
                request.getPetOwnerEmail(),
                request.getDescription(),
                new TimeIntervalEntity(request.getTimeInterval().getStartDate(), request.getTimeInterval().getFinishDate()),
                new PetEntity(
                        request.getPet().getPetName(),
                        request.getPet().getPetType(),
                        request.getPet().getWeight(),
                        request.getPet().getDescription()
                ),
                request.getPostalCode()
        );
        AnnouncementEntity announcementRespond = announcementDAO.createAnnouncement(announcement);
        responseObserver.onNext(AnnouncementMapper.mapToProto(announcementRespond));
        responseObserver.onCompleted();

    }

    @Override
    public void findAnnouncements(SearchFieldProto request,
                                  StreamObserver<AnnouncementsProto> responseObserver) {

    }

    @Override
    public void updateAnnouncement(AnnouncementProto request, StreamObserver<origin.protobuf.Void> responseObserver)
    {

    }

    @Override
    public void deleteAnnouncement(AnnouncementProto request, StreamObserver<origin.protobuf.Void> responseObserver)
    {

    }

}
