package dk.via.sep3.services;

import com.google.common.base.Strings;
import dk.via.sep3.DAOInterfaces.AnnouncementDAOInterface;
import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.mappers.AnnouncementMapper;
import dk.via.sep3.model.AnnouncementEntity;
import dk.via.sep3.model.PetEntity;
import dk.via.sep3.model.UserEntity;
import dk.via.sep3.utils.TimestampConverter;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import origin.protobuf.*;
import origin.protobuf.AnnouncementProto;
import origin.protobuf.AnnouncementsProto;
import origin.protobuf.FindAnnouncementProto;
import origin.protobuf.SearchAnnouncementProto;
import origin.protobuf.Void;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Override
    @Transactional
    public void createAnnouncement(AnnouncementProto request, StreamObserver<AnnouncementProto> responseObserver)
    {
        UserEntity petOwner = userDAO.findUser(request.getPetOwnerEmail());
        if(!petOwner.getUserType().equals("PetOwner"))
        {
            responseObserver.onError(GrpcErrorService.constructException("Only pet owner can create an announcement."));
            return;
        }
        AnnouncementEntity announcement = new AnnouncementEntity(
                petOwner,
                request.getDescription(),
                TimestampConverter.toLocalDateTime(request.getTimeStart()),
                TimestampConverter.toLocalDateTime(request.getTimeFinish()),
                new PetEntity(
                        request.getPet().getPetName(),
                        request.getPet().getPetType(),
                        request.getPet().getWeight(),
                        request.getPet().getIsVaccinated(),
                        request.getPet().getDescription(),
                        petOwner
                ),
                request.getPostalCode()
        );
        announcement.setDateOfCreation(TimestampConverter.toLocalDateTime(request.getDateOfCreation()));
        AnnouncementEntity announcementRespond = announcementDAO.createAnnouncement(announcement);

        if(announcementRespond == null)
        {
            responseObserver.onError(GrpcErrorService.constructException("Announcement with such id already exists"));
            return;
        }
        responseObserver.onNext(AnnouncementMapper.mapToProto(announcementRespond));
        responseObserver.onCompleted();
    }



    @Override
    @Transactional
    public void searchAnnouncements(SearchAnnouncementProto request, StreamObserver<AnnouncementsProto> responseObserver)
    {
        Collection<AnnouncementEntity> announcements = request == null? announcementDAO.getAllAnnouncements() : announcementDAO.getAnnouncements(request);
        announcements = announcements.stream().filter(a -> a.getFinishDate().toLocalDate().isAfter(LocalDate.now()) ||
                a.getStartDate().toLocalDate().equals(LocalDate.now())).toList();


        if (announcements.isEmpty())
        {
            responseObserver.onError(GrpcErrorService.constructException("No such announcements"));
            return;
        }

        Collection<AnnouncementProto> announcementCollection = announcements
                .stream().map(AnnouncementMapper::mapToProto).toList();

        AnnouncementsProto announcementsProtoItems = AnnouncementsProto.newBuilder().addAllAnnouncements(announcementCollection).build();
        responseObserver.onNext(announcementsProtoItems);
        responseObserver.onCompleted();
    }
    @Transactional
    public void findAnnouncement(FindAnnouncementProto request, StreamObserver<AnnouncementProto> responseObserver)
    {
        responseObserver.onNext(AnnouncementMapper.mapToProto(announcementDAO.getAnnouncement(request.getId())));
        responseObserver.onCompleted();
    }

    @Transactional
    public void updateAnnouncement(AnnouncementProto request, StreamObserver<AnnouncementProto> responseObserver)
    {
        AnnouncementEntity announcement = announcementDAO.getAnnouncement(request.getId());

        if(announcement == null)
        {
            responseObserver.onError(GrpcErrorService.constructException("Announcement with id " + request.getId() + " is not found"));
            return;
        }

        if(!Strings.isNullOrEmpty(request.getDescription()))
            announcement.setDescription(request.getDescription());

        if(!request.getTimeStart().isInitialized())
            announcement.setStartDate(TimestampConverter.toLocalDateTime(request.getTimeStart()));

        if(!Strings.isNullOrEmpty(request.getPostalCode()))
            announcement.setPostalCode(request.getPostalCode());

        if(!request.getTimeFinish().isInitialized())
            announcement.setFinishDate(TimestampConverter.toLocalDateTime(request.getTimeFinish()));

        if(request.getPet().getId() != 0)
        {
            PetEntity pet = announcement.getPet();

            if(!Strings.isNullOrEmpty(request.getPet().getDescription()))
                pet.setDescription(request.getPet().getDescription());

            if(!Strings.isNullOrEmpty(request.getPet().getPetType()))
                pet.setPetType(request.getPet().getPetType());

            if(!Strings.isNullOrEmpty(request.getPet().getPetName()))
                pet.setPetName(request.getPet().getPetName());

            if(request.getPet().getIsVaccinated() != pet.isVaccinated())
                pet.setVaccinated(request.getPet().getIsVaccinated());

            if(request.getPet().getWeight() == 0 || request.getPet().getWeight() != pet.getWeight())
                pet.setWeight(request.getPet().getWeight());


            announcement.setPet(pet);
        }

        var updatedAnnouncement = announcementDAO.updateAnnouncement(announcement);
        if(updatedAnnouncement == null)
        {
            responseObserver.onError(GrpcErrorService.constructException("Announcement was not updated"));
            return;
        }
        responseObserver.onNext(AnnouncementMapper.mapToProto(updatedAnnouncement));
        responseObserver.onCompleted();
    }


    public void deleteAnnouncement(FindAnnouncementProto request, StreamObserver<Void> responseObserver)
    {
        String response = announcementDAO.deleteAnnouncement(announcementDAO.getAnnouncement(request.getId()))? "User is deleted" : "User not found";
        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }
}
