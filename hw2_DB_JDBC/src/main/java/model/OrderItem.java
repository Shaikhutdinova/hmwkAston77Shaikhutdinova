package model;

import lombok.Data;

@Data
public class OrderItem {
    private int id;
    private int orederId;
    private int productId;
    private int quantity;
}
