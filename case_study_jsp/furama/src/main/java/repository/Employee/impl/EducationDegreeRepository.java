package repository.Employee.impl;

import model.employee.EducationDegree;
import repository.BaseRepository;
import repository.Employee.IEducationDegreeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements IEducationDegreeRepository {
    private final String SELECT_ALL_EDUCATION_DEGREE = "SELECT * FROM education_degree;";
    @Override
    public List<EducationDegree> selectAllEducationDegree() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EDUCATION_DEGREE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int education_degree_id = resultSet.getInt("education_degree_id");
                String education_degree_name = resultSet.getString("education_degree_name");
                EducationDegree educationDegree = new EducationDegree(education_degree_id,education_degree_name);
                educationDegreeList.add(educationDegree);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return educationDegreeList;
    }
}
