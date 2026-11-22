package Crud_Project.Himself_Create_Crud_Project.Controller;

import Crud_Project.Himself_Create_Crud_Project.Entity.Employee_Information;
import Crud_Project.Himself_Create_Crud_Project.Repository.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller
{
    private Repository repository;
    Controller(Repository repository)
    {
        this.repository=repository;
    }

    // Create Employee.
    @PostMapping("/student/create")
    public Employee_Information CreateEmployee(@RequestBody Employee_Information employeeInformation)
    {
        // repository.save(employeeInformation); <- ye database me Save + or object dega  , or yahi class me bo object Ignore ho jayega kyu ki kisi ko return nhi kiya hai.
        return repository.save(employeeInformation); // database me Save + object dega , or object bo postman me pas chala jayega kyu ki api hit call  karega ,return  object dega jaha se call hua hai ,  jo ki maine postman se call api hit ki madat se kiya hai . or postman ke response me chala jayega.
    }

    //read employee BY ID .
    @GetMapping("/student/read/{id}")
    public Employee_Information getone(@PathVariable Long id)
    {
        return repository.findById(id).orElseThrow();
    }

    //read all employee.
    @GetMapping("/students/readall")
    public List<Employee_Information> getall()
    {
        return repository.findAll();
    }

    //update one emplyee by id .
    @PutMapping("/student/update/{id}")
    public Employee_Information updateone(@PathVariable Long id,@RequestBody Employee_Information employeeInformation)
    {
        employeeInformation.setId(id);
        return repository.save(employeeInformation);
    }

    //delete one emplyee by id .
    @DeleteMapping("/student/delete/{id}")
    public String deleteone(@PathVariable Long id)
    {
        repository.deleteById(id);
        return "Delete Employee Successfully";
    }

    //delete all employee.
    @DeleteMapping("/students/delete")
    public String deleteall()
    {
        repository.deleteAll();
        return "Delete All Data";
    }

}
