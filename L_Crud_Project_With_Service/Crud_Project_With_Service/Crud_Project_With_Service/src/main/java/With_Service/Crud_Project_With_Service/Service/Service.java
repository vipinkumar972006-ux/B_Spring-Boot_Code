package With_Service.Crud_Project_With_Service.Service;

import With_Service.Crud_Project_With_Service.Entity.Entity;
import With_Service.Crud_Project_With_Service.Repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Service
{
    private Repository repository;
    Service(Repository repository)
    {
        this.repository=repository;
    }
    //addcard
    public Entity addcard(Entity entity)
    {
        if(entity.getCardholdername()==null || entity.getCardholdername().isBlank())
        {
            throw new IllegalArgumentException("CardHolerName is Required");
        }
        if(entity.getCardnumber()==null ||entity.getCardnumber()<=0)
        {
            throw new IllegalArgumentException("CardNumber is Required");
        }
         return repository.save(entity);
    }

    //getallcard
    public List<Entity> readall()
    {
        return repository.findAll();
    }

    ///getcardById
    public Entity readone( Long id)
    {
        return repository.findById(id).orElseThrow();
    }

    //delete one card
    public void deleteone(Long id)
    {
        repository.deleteById(id);
    }

    //delete all card
    public void deleteall()
    {
        repository.deleteAll();
    }

    //updatecard
    public Entity update( Entity entity)
    {
        return repository.save(entity);
    }
}
