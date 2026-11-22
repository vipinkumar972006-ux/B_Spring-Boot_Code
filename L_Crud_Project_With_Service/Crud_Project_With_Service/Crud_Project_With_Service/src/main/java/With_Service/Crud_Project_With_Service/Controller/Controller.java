package With_Service.Crud_Project_With_Service.Controller;

import With_Service.Crud_Project_With_Service.Entity.Entity;
import With_Service.Crud_Project_With_Service.Repository.Repository;
import With_Service.Crud_Project_With_Service.Service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("")
public class Controller
{
    private Repository repository;
    private Service service;
    Controller(Repository repository,Service service)
    {
        this.repository=repository;
        this.service=service;
    }

    //add card
    @PostMapping("/add")
    public Entity addcard(@RequestBody Entity entity)
    {
        return service.addcard(entity);
    }

    //get one card
    @GetMapping("/read/{id}")
    public Entity readone(@PathVariable Long id)
    {
       return service.readone(id);
    }

    //get all card
    @GetMapping("/readall")
    public List<Entity> readall()
    {
        return service.readall();
    }

    //delete one card
    @DeleteMapping("/delete/{id}")
    public String deleteone(@PathVariable Long id)
    {
        service.deleteone(id);
        return "Card Deleted Successfully";
    }

    //delete all card
    @DeleteMapping("/deleteall")
    public String deleteall()
    {
        service.deleteall();
        return "Delete All Card Successfully";
    }

    //update card information
    @PutMapping("/update/{id}")
    public Entity update(@RequestBody Entity entity)
    {
        return service.update(entity);
    }
}
