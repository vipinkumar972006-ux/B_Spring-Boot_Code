package SoftDelete_Perform.SoftDelete_in_DataBase_Crud_Application.Service;

import SoftDelete_Perform.SoftDelete_in_DataBase_Crud_Application.CartEntity.CartEntity;
import SoftDelete_Perform.SoftDelete_in_DataBase_Crud_Application.CartEntityRepository.Cartrepository;
import SoftDelete_Perform.SoftDelete_in_DataBase_Crud_Application.Entity.Entity;
import SoftDelete_Perform.SoftDelete_in_DataBase_Crud_Application.Repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Service {
    private final ProductRepository repository;
    private Cartrepository cartrepository;
    public Service(ProductRepository repository ,Cartrepository Cartrepository)
    {
        this.repository = repository;
        this.cartrepository=cartrepository;
    }
    //add product.
    public Entity addproduct(Entity entity)
    {
        entity.setIsDeleted(false);
        return repository.save(entity);
    }
    //get by id.
    public Entity getbyid(Long id)
    {
        return repository.findByIdAndIsDeletedFalse(id).orElseThrow();
    }
    //get all product.
    public List<Entity> getAllActiveProducts()
    {
        return repository.findByIsDeletedFalse();
    }
    //update one product.
    public Entity updateproduct(Long id,Entity entity)
    {
        Entity olddata=repository.findByIdAndIsDeletedFalse(id).orElseThrow(()->new RuntimeException("Product not found..."));
        olddata.setId(entity.getId());
        olddata.setCategory(entity.getCategory());
        olddata.setDescription(entity.getDescription());
        olddata.setIsDeleted(entity.getIsDeleted());
        olddata.setPrice(entity.getPrice());
        olddata.setProductname(entity.getProductname());
        olddata.setQuantity(entity.getQuantity());
        return repository.save(olddata);
    }
    //softdelete one product.
    public String softdeleteoneproduct(Long id,Entity entity)
    {
        if(repository.existsByIdAndIsDeletedFalse(id))
        {
            entity.setIsDeleted(true);
            repository.save(entity);
        }
        return "Soft Delete One Product Successfully...";
    }
    //softdelete all product.
    public String softdeleteallproduct(List<Entity> entity)
    {
        for(Entity entityall:entity)
        {
            entityall.setIsDeleted(true);
        }
        repository.saveAll(entity);
        return "Soft Delete All Product Successfully...";
    }
    //Delete one product.
    public String deleteoneproduct(Long id)
    {
        if(repository.existsByIdAndIsDeletedFalse(id))
        {
            repository.deleteById(id);
        }
        return "Delete one Product Successfully...";
    }
    //Delete all product.
    public String deleteallproduct(Entity entity)
    {
        repository.delete(entity);
        return "Delete All Product Successfully...";
    }
    //Search Product by name;
    public List<Entity> searchproductbyname(String name)
    {
        return repository.findByProductnameContainingIgnoreCaseAndIsDeletedFalse(name);
    }
   //add product to cart.
    public CartEntity addproductcart(Long id,CartEntity cartEntity)
    {
        if(repository.existsByIdAndIsDeletedFalse(id))
        {
            repository.deleteById(id);
        }
        return cartrepository.save(cartEntity);
    }

}
