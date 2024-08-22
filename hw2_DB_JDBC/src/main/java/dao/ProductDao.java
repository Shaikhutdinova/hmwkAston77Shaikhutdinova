package dao;
import model.Product;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {

    private Connection connection;

    public ProductDao(Connection connection) {
        this.connection = connection;
    }

    public List<Product> getAllProducts() throws SQLException {
        // Выполнить запрос к базе данных
        // Заполнить список продуктов из результата запроса
        return new ArrayList<Product>();
    }

    // ... другие методы для работы с продуктами
}

