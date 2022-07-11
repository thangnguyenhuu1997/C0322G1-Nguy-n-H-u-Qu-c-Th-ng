package service;

import model.Product;

import java.util.List;

public interface IProductService{
    public List<Product> selectAllProduct();

    public Product selectProduct(int id);

    public void insertProduct(Product product);

    public boolean updateProduct(Product product);

    public boolean deleteProduct(int id);

    public List<Product> searchProduct(String idSearch, String nameSearch);
}
