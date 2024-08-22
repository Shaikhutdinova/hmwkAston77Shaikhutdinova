package model;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private int id;
    private int userId;
    private Date createdAt = new Date();


}
