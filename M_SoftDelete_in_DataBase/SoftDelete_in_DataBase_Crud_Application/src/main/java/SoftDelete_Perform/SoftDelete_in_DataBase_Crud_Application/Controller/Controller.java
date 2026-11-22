package SoftDelete_Perform.SoftDelete_in_DataBase_Crud_Application.Controller;

import SoftDelete_Perform.SoftDelete_in_DataBase_Crud_Application.CartEntity.CartEntity;
import SoftDelete_Perform.SoftDelete_in_DataBase_Crud_Application.Entity.Entity;
import SoftDelete_Perform.SoftDelete_in_DataBase_Crud_Application.Service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("")
public class Controller
{
    private Service service;
    Controller(Service service)
    {
        this.service=service;
    }
    //Add Product.
    @PostMapping("/add")
    public Entity addproduct(@RequestBody Entity entity)
    {
        return service.addproduct(entity);
    }
    //get product by id.
    @GetMapping("/get/{id}")
    public Entity getbyid(@PathVariable Long id)
    {
        return service.getbyid(id);
    }
    //get all product.
    @GetMapping("/getall")
    public List<Entity> getallproduct()
    {
        return service.getAllActiveProducts();
    }
    //update product.
    @PutMapping("/update")
    public Entity updateproduct(@PathVariable Long id,@RequestBody Entity entity)
    {
        return service.updateproduct(id,entity);
    }
    //softdelete one product.
    @DeleteMapping("/softdeleteone/{id}")
    public String softdelete(@PathVariable Long id,Entity entity)
    {
        return service.softdeleteoneproduct(id,entity);
    }
    //soft delete all Product.
    @DeleteMapping("/softdeleteall")
    public String softdeleteall(@RequestBody Entity entity)
    {
       return service.softdeleteallproduct((List<Entity>) entity);
    }
    //Delete one product.
    @DeleteMapping("/deleteone/{id}")
    public String deleteoneproduct(@PathVariable Long id)
    {
        return service.deleteoneproduct(id);
    }
    //Delete All Product.
    @DeleteMapping("/deleteall")
    public String deleteallproduct(@RequestBody Entity entity)
    {
        return service.deleteallproduct(entity);
    }
    //Search Product by name;
    public List<Entity> searchproductbyname(@PathVariable String name)
    {
       return service.searchproductbyname(name);
    }
    //addcart
    @PostMapping("/addcart/{id}")
    public CartEntity addcart(@PathVariable Long id,@RequestBody CartEntity cartEntity)
    {
        return service.addproductcart(id,cartEntity);
    }
}
