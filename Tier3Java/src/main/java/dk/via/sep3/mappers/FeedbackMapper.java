package dk.via.sep3.mappers;

import dk.via.sep3.model.FeedbackEntity;
import origin.protobuf.FeedbackProto;

public class FeedbackMapper
{
    public static FeedbackProto mapToProto(FeedbackEntity entity)
    {
        return FeedbackProto.newBuilder()
                .setFeedback(entity.getFeedback())
                .setRating(entity.getRating())
                .setServiceId(entity.getService().getId())
                .build();
    }

}
