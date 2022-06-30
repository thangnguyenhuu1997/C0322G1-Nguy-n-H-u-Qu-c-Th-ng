package repository.employee.impl;

import model.employee.Division;
import model.employee.EducationDegree;
import repository.BaseRepository;
import repository.employee.IEducationDegreeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EducationDegreeRepositoryImpl implements IEducationDegreeRepository {
    private final String SELECT_EDUCATION_DEGREE = "SELECT * FROM education_degree;";


    @Override
    public List<EducationDegree> selectAll() {
        List<EducationDegree> listEducationDegree = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_EDUCATION_DEGREE);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int educationDegreeId = resultSet.getInt("education_degree_id");
                String educationDegreeName = resultSet.getString("education_degree_name");
                EducationDegree degree = new EducationDegree(educationDegreeId,educationDegreeName);
                listEducationDegree.add(degree);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return listEducationDegree;
    }

    @Override
    public Map<Integer, String> selectEducationDegree() {
        Map<Integer, String> map = new HashMap<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_EDUCATION_DEGREE);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int educationDegreeId = resultSet.getInt("education_degree_id");
                String educationDegreeName = resultSet.getString("education_degree_name");
                map.put(educationDegreeId,educationDegreeName);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return map;
    }
}
