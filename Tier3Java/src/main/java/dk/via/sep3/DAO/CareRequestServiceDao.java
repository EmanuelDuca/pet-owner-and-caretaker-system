package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.CareRequestServiceDaoInterface;
import dk.via.sep3.repository.CareServiceRequestRepository;
import dk.via.sep3.shared.CareServiceRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class CareRequestServiceDao implements CareRequestServiceDaoInterface
{
    private final CareServiceRequestRepository repository;

    @Autowired
    public CareRequestServiceDao(CareServiceRequestRepository repository)
    {
        this.repository = repository;
    }
    @Override
    public CareServiceRequestEntity createAnnouncement(CareServiceRequestEntity careServiceEntity)
    {
        return repository.save(careServiceEntity);
    }
}
