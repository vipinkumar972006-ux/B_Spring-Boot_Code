package SoftDelete_Perform.SoftDelete_in_DataBase_Crud_Application.CartEntity;

import jakarta.persistence.*;

@Entity
@Table(schema = "Cart_Detail")
public class CartEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productname;
    private double totalprice;
}
