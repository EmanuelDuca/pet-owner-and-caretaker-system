package dk.via.sep3.mappers;

import dk.via.sep3.shared.FeedbackEntity;
import dk.via.sep3.shared.PetEntity;
import dk.via.sep3.shared.UserEntity;
import origin.protobuf.FeedbackProto;
import origin.protobuf.PetProto;

public class FeedbackMapper
{
    public static FeedbackProto mapToProto(FeedbackEntity entity)
    {
        return FeedbackProto.newBuilder()
                .setFeedback(entity.getFeedback())
                .setRating(entity.getRating())
                .setCaretakerEmail(entity.getCaretaker().getEmail())
                .setService(PetServiceMapper.mapToProto(entity.getService()))
                .build();
    }

}
