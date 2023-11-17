package dk.via.sep3.services;

import dk.via.sep3.DAOInterfaces.AnnouncementDAOInterface;
import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.mappers.AnnouncementMapper;
import dk.via.sep3.shared.AnnouncementEntity;
import dk.via.sep3.shared.PetEntity;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import origin.protobuf.*;

import java.util.Collection;

@GRpcService
public class AnnouncementService extends AnnouncementServiceGrpc.AnnouncementServiceImplBase {

    @Autowired
    private UserDAOInterface userDAO;

    @Autowired
    private AnnouncementDAOInterface announcementDAO;


    public AnnouncementService()
    {
    }

    public void createAnnouncement(AnnouncementProto request, StreamObserver<AnnouncementProto> responseObserver)
    {
        AnnouncementEntity announcement = new AnnouncementEntity(
                userDAO.findUser(request.getPetOwnerEmail()),
                request.getDescription(),
                request.getTimeStart(),
                request.getTimeFinish(),
                new PetEntity(
                        request.getPet().getPetName(),
                        request.getPet().getPetType(),
                        request.getPet().getWeight(),
                        request.getPet().getIsVaccinated(),
                        request.getPet().getDescription(),
                        userDAO.findUser(request.getPetOwnerEmail())
                ),
                request.getPostalCode()
        );
        announcement.setDateOfCreation(request.getDateOfCreation());
        AnnouncementEntity announcementRespond = announcementDAO.createAnnouncement(announcement);

        if(announcementRespond == null)
            responseObserver.onError(GrpcError.constructException("Announcement with such id already exists"));

        responseObserver.onNext(AnnouncementMapper.mapToProto(announcementRespond));
        responseObserver.onCompleted();
    }

    public void findAnnouncements(SearchAnnouncementProto request, StreamObserver<AnnouncementsProto> responseObserver)
    {
        Collection<AnnouncementEntity> announcements = request == null? announcementDAO.getAllAnnouncements() : announcementDAO.getAnnouncements(request);

        if (announcements.isEmpty())
        {
            responseObserver.onError(GrpcError.constructException("No such announcements"));
            return;
        }

        Collection<AnnouncementProto> announcementCollection = announcements
                .stream().map(AnnouncementMapper::mapToProto).toList();

        AnnouncementsProto announcementsProtoItems = AnnouncementsProto.newBuilder().addAllAnnouncements(announcementCollection).build();
        responseObserver.onNext(announcementsProtoItems);
        responseObserver.onCompleted();
    }

    public void getAnnouncement(FindAnnouncementProto request, StreamObserver<AnnouncementProto> responseObserver)
    {
        responseObserver.onNext(AnnouncementMapper.mapToProto(announcementDAO.getAnnouncement(request.getId())));
        responseObserver.onCompleted();
    }


    public void updateAnnouncement(AnnouncementProto request, StreamObserver<AnnouncementProto> responseObserver)
    {
        AnnouncementEntity announcement = announcementDAO.getAnnouncement(request.getId());
        announcement.setDescription(request.getDescription());
        announcement.setStartDate(request.getTimeStart());
        announcement.setFinishDate(request.getTimeFinish());
        announcement.setPet(new PetEntity(
                request.getPet().getPetName(),
                request.getPet().getPetType(),
                request.getPet().getWeight(),
                request.getPet().getIsVaccinated(),
                request.getPet().getDescription()
        ));
        responseObserver.onNext(AnnouncementMapper.mapToProto(announcementDAO.updateAnnouncement(announcement)));
        responseObserver.onCompleted();
    }


    public void deleteAnnouncement(FindAnnouncementProto request, StreamObserver<ResponseStatus> responseObserver)
    {
        String response = announcementDAO.deleteAnnouncement(announcementDAO.getAnnouncement(request.getId()))? "User is deleted" : "User not found";
        responseObserver.onNext(ResponseStatus.newBuilder().setResponseStatus(response).build());
        responseObserver.onCompleted();
    }



}
