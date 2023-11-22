package dk.via.sep3.services;

import com.google.common.base.Strings;
import dk.via.sep3.DAOInterfaces.AnnouncementDAOInterface;
import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.mappers.AnnouncementMapper;
import dk.via.sep3.shared.AnnouncementEntity;
import dk.via.sep3.shared.PetEntity;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import origin.protobuf.*;

import javax.transaction.Transactional;
import java.util.Collection;

@GRpcService
public class AnnouncementService extends AnnouncementServiceGrpc.AnnouncementServiceImplBase {

    private final UserDAOInterface userDAO;

    private final AnnouncementDAOInterface announcementDAO;


    @Autowired
    public AnnouncementService(AnnouncementDAOInterface announcementDAO, UserDAOInterface userDAO)
    {
        this.announcementDAO = announcementDAO;
        this.userDAO = userDAO;
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
    @Transactional
    public void getAnnouncement(FindAnnouncementProto request, StreamObserver<AnnouncementProto> responseObserver)
    {
        responseObserver.onNext(AnnouncementMapper.mapToProto(announcementDAO.getAnnouncement(request.getId())));
        responseObserver.onCompleted();
    }

    @Transactional
    public void updateAnnouncement(AnnouncementProto request, StreamObserver<AnnouncementProto> responseObserver)
    {
        AnnouncementEntity announcement = announcementDAO.getAnnouncement(request.getId());

        if(!Strings.isNullOrEmpty(request.getDescription()))
            announcement.setDescription(request.getDescription());

        if(!Strings.isNullOrEmpty(request.getTimeStart()))
            announcement.setStartDate(request.getTimeStart());

        if(!Strings.isNullOrEmpty(request.getTimeFinish()))
            announcement.setFinishDate(request.getTimeFinish());

        if(request.getPet().getId() != 0)
        {
            PetEntity pet = new PetEntity(
                    request.getPet().getPetName(),
                    request.getPet().getPetType(),
                    request.getPet().getWeight(),
                    request.getPet().getIsVaccinated(),
                    request.getPet().getDescription(),
                    userDAO.findUser(request.getPetOwnerEmail()));

            announcement.setPet(pet);
        }

        System.out.println("#####LOG#####" + announcement.getDescription());
        System.out.println("#####LOG#####" + announcement.getPet().getPetType());
        System.out.println("#####LOG#####" + announcement.getPet().getPetOwner().getUsername());
        var announcementEntity = announcementDAO.updateAnnouncement(announcement);
        if(announcementEntity == null)
        {
            responseObserver.onError(GrpcError.constructException("Announcement was not updated"));
            return;
        }
        responseObserver.onNext(AnnouncementMapper.mapToProto(announcementEntity));
        responseObserver.onCompleted();
    }


    public void deleteAnnouncement(FindAnnouncementProto request, StreamObserver<ResponseStatus> responseObserver)
    {
        String response = announcementDAO.deleteAnnouncement(announcementDAO.getAnnouncement(request.getId()))? "User is deleted" : "User not found";
        responseObserver.onNext(ResponseStatus.newBuilder().setResponseStatus(response).build());
        responseObserver.onCompleted();
    }



}
