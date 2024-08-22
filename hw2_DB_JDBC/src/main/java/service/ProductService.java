package service;

import dao.ProductDao;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getAllProducts() throws SQLException {
        // Получить список всех продуктов
        return productDao.getAllProducts();
    }

}
