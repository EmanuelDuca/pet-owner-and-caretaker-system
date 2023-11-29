package dk.via.sep3.DAO;

public class PetServiceDAO
{
    private final PetServiceRepository repository;

    @Autowired
    public PetServiceDAO(PetServiceRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public PetServiceEntity createService(PetServiceEntity service)
    {
        return repository.save(service);
    }

    @Override
    public void endService(int serviceId)
    {
        findServiceById(serviceId);
    }

    @Override
    public PetServiceEntity findServiceById(int serviceId)
    {
        return repository.getReferenceById(serviceId);
    }

    @Override
    public Collection<PetServiceEntity> searchServices(CareTakerEntity careTaker, PetOwnerEntity petOwner, ServiceProto.Status status)
    {
        return null;
    }
}
