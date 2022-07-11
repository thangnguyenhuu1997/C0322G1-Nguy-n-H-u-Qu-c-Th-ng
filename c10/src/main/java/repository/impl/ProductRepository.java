package repository.impl;

import model.Product;
import repository.BaseRepository;
import repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final String SELECT_ALL_PRODUCT = "SELECT * FROM product";
    private final String SELECT_PRODUCT_BY_ID = "SELECT * FROM product where product_id = ?;";
    private final String INSERT_NEW_PRODUCT = "insert into product (product_name, product_price, product_quantity, product_color, category_id) values (?,?,?,?,?);";
    private final String DELETE_PRODUCT = "delete from product where product_id = ?;";
    private final String SEARCH_BY_KEYWORD = "select * from product where product_id like ? and product_name like ?;";
    private final String UPDATE_PRODUCT = "update product set product_name =?, product_price =?, product_quantity=?, product_color=?, category_id=? where product_id = ?;";

    @Override
    public List<Product> selectAllProduct() {
        List<Product> productList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int product_id = resultSet.getInt("product_id");
                String product_name = resultSet.getString("product_name");
                double product_price = resultSet.getDouble("product_price");
                int product_quantity = resultSet.getInt("product_quantity");
                String product_color = resultSet.getString("product_color");
                int category_id = resultSet.getInt("category_id");
                Product product = new Product(product_id,
                        product_name,
                        product_price,
                        product_quantity,
                        product_color,
                        category_id);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product selectProduct(int id) {
        Product product = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int product_id = resultSet.getInt("product_id");
                String product_name = resultSet.getString("product_name");
                double product_price = resultSet.getDouble("product_price");
                int product_quantity = resultSet.getInt("product_quantity");
                String product_color = resultSet.getString("product_color");
                int category_id = resultSet.getInt("category_id");
                product = new Product(product_id,
                        product_name,
                        product_price,
                        product_quantity,
                        product_color,
                        category_id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public void insertProduct(Product product) {
        System.out.println(INSERT_NEW_PRODUCT);
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_NEW_PRODUCT);
            preparedStatement.setString(1, product.getProduct_name());
            preparedStatement.setDouble(2,product.getProduct_price());
            preparedStatement.setInt(3, product.getProduct_quantity());
            preparedStatement.setString(4, product.getProduct_color());
            preparedStatement.setInt(5,product.getCategory_id());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getProduct_name());
            preparedStatement.setDouble(2,product.getProduct_price());
            preparedStatement.setInt(3, product.getProduct_quantity());
            preparedStatement.setString(4, product.getProduct_color());
            preparedStatement.setInt(5,product.getCategory_id());
            preparedStatement.setInt(6,product.getProduct_id());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> searchProduct(String idSearch, String nameSearch) {
        return null;
    }
}
