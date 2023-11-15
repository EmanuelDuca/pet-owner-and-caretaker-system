package dk.via.sep3.services;

import dk.via.sep3.DAOInterfaces.AnnouncementDAOInterface;
import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.mappers.AnnouncementMapper;
import dk.via.sep3.shared.AnnouncementEntity;
import dk.via.sep3.shared.PetEntity;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import origin.protobuf.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
    @Transactional
    public void createAnnouncement(origin.protobuf.AnnouncementProto request, io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementProto> responseObserver)
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
        responseObserver.onNext(AnnouncementMapper.mapToProto(announcementRespond));
        responseObserver.onCompleted();
    }
    @Transactional
    public void findAnnouncements(origin.protobuf.SearchAnnouncementProto request, io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementsProto> responseObserver)
    {
        Collection<AnnouncementEntity> announcements = announcementDAO.getAnnouncements(
                request.getPetOwnerEmail(),
                request.getTimeStart(),
                request.getTimeFinish(),
                request.getPostalCode(),
                request.getPetType(),
                request.getPetWeight(),
                request.getPetIsVaccinated()
        );
        if (announcements.isEmpty()) {
            responseObserver.onError(new Exception("No such announcements"));
            return;
        }
        Collection<AnnouncementProto> announcementCollection = new ArrayList<>();
        for (var announcement : announcements)
        {
            announcementCollection.add(AnnouncementMapper.mapToProto(announcement));
        }
        AnnouncementsProto announcementsProtoItems = AnnouncementsProto.newBuilder().addAllAnnouncements(announcementCollection).build();
        responseObserver.onNext(announcementsProtoItems);
        responseObserver.onCompleted();
    }
    @Transactional
    public void getAnnouncement(origin.protobuf.FindAnnouncementProto request, io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementProto> responseObserver)
    {
        responseObserver.onNext(AnnouncementMapper.mapToProto(announcementDAO.getAnnouncement(request.getId())));
        responseObserver.onCompleted();
    }

    @Transactional
    public void updateAnnouncement(origin.protobuf.AnnouncementProto request, io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementProto> responseObserver)
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

    @Transactional
    public void deleteAnnouncement(origin.protobuf.FindAnnouncementProto request, io.grpc.stub.StreamObserver<origin.protobuf.ResponseStatus> responseObserver)
    {
        String response = announcementDAO.deleteAnnouncement(announcementDAO.getAnnouncement(request.getId()));
        responseObserver.onNext(ResponseStatus.newBuilder().setResponseStatus(response).build());
        responseObserver.onCompleted();
    }



}
