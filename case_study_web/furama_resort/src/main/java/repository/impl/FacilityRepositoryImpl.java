package repository.impl;

import model.*;
import repository.BaseRepository;
import repository.FacilityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepositoryImpl implements FacilityRepository {
    private static final String INSERT_VILLA_SQL = "insert into facility (facility_id, facility_name, facility_area, facility_cost, facility_max_people, rent_type_id, facility_type_id, standard_room, description_other_convenence, pool_area, number_of_floors) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String INSERT_HOUSE_SQL = "insert into facility (facility_id, facility_name, facility_area, facility_cost, facility_max_people, rent_type_id, facility_type_id, standard_room, description_other_convenence, number_of_floors) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String INSERT_ROOM_SQL = "insert into facility (facility_id, facility_name, facility_area, facility_cost, facility_max_people, rent_type_id, facility_type_id, facility_free) values (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_FACILITY_BY_ID = "select * from facility where facility_id = ?;";
    private static final String SELECT_ALL_FACILITY = "select * from facility where flag = 0";
    private static final String SELECT_ALL = "select * from facility";
    private static final String UPDATE_VILLA_SQL = "update facility set facility_name = ?, facility_area = ?, facility_cost = ?, facility_max_people = ?, rent_type_id = ?, facility_type_id = ?,  standard_room = ?, description_other_convenence = ?, pool_area = ?, number_of_floors = ? where facility_id = ?;";
    private static final String UPDATE_HOUSE_SQL = "update facility set facility_name = ?, facility_area = ?, facility_cost = ?, facility_max_people = ?, rent_type_id = ?, facility_type_id = ?,  standard_room = ?, description_other_convenence = ?, number_of_floors = ? where facility_id = ?;";
    private static final String UPDATE_ROOM_SQL = "update facility set facility_name = ?, facility_area = ?, facility_cost = ?, facility_max_people = ?, rent_type_id = ?, facility_type_id = ?, facility_free = ? where facility_id = ?;";
    private static final String DELETE_FACILITY_SQL = "update facility set flag = 1 where facility_id = ?;";
    private static final String SEARCH_SQL = "select * from facility where facility_name like ? or facility_area like ? or facility_cost like ? or facility_max_people like ? or description_other_convenence like ? or pool_area like ? or number_of_floors like ? or facility_free like ?;";

    @Override
    public List<Facility> selectAll() {
        List<Facility> facilityList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("facility_id"));
                String name = rs.getString("facility_name");
                int area = Integer.parseInt(rs.getString("facility_area"));
                double cost = Double.parseDouble(rs.getString("facility_cost"));
                int maxPeople = Integer.parseInt(rs.getString("facility_max_people"));
                int rentTypeId = Integer.parseInt(rs.getString("rent_type_id"));
                int facilityTypeId = Integer.parseInt(rs.getString("facility_type_id"));

                String standardRoom = rs.getString("standard_room");
                String otherDescription = rs.getString("description_other_convenence");

                double poolArea;
                if (rs.getString("pool_area") == null) {
                    poolArea = 0;
                } else {
                    poolArea = Double.parseDouble(rs.getString("pool_area"));
                }

                int numberFloor;
                if (rs.getString("number_of_floors") == null) {
                    numberFloor = 0;
                } else {
                    numberFloor = Integer.parseInt(rs.getString("number_of_floors"));
                }

                String facilityFree = rs.getString("facility_free");

                if (facilityTypeId == 1) {
                    facilityList.add(new Villa(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, otherDescription, poolArea, numberFloor));
                } else if (facilityTypeId == 2) {
                    facilityList.add(new House(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, otherDescription, numberFloor));
                } else {
                    facilityList.add(new Room(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, facilityFree));
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return facilityList;
    }

    @Override
    public List<Facility> selectAllFacility() {
        List<Facility> facilityList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FACILITY)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("facility_id"));
                String name = rs.getString("facility_name");
                int area = Integer.parseInt(rs.getString("facility_area"));
                double cost = Double.parseDouble(rs.getString("facility_cost"));
                int maxPeople = Integer.parseInt(rs.getString("facility_max_people"));
                int rentTypeId = Integer.parseInt(rs.getString("rent_type_id"));
                int facilityTypeId = Integer.parseInt(rs.getString("facility_type_id"));

                String standardRoom = rs.getString("standard_room");
                String otherDescription = rs.getString("description_other_convenence");

                double poolArea;
                if (rs.getString("pool_area") == null) {
                    poolArea = 0;
                } else {
                    poolArea = Double.parseDouble(rs.getString("pool_area"));
                }

                int numberFloor;
                if (rs.getString("number_of_floors") == null) {
                    numberFloor = 0;
                } else {
                    numberFloor = Integer.parseInt(rs.getString("number_of_floors"));
                }

                String facilityFree = rs.getString("facility_free");

                if (facilityTypeId == 1) {
                    facilityList.add(new Villa(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, otherDescription, poolArea, numberFloor));
                } else if (facilityTypeId == 2) {
                    facilityList.add(new House(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, otherDescription, numberFloor));
                } else {
                    facilityList.add(new Room(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, facilityFree));
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return facilityList;
    }

    @Override
    public Facility selectFacility(int id) {
        Facility facility = null;
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FACILITY_BY_ID)) {

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            String name;
            int area;
            double cost;
            int maxPeople;
            int rentTypeId;
            int facilityTypeId = 0;

            String standardRoom;
            String otherDescription;
            double poolArea;
            int numberFloor;

            String facilityFree;

            while (rs.next()) {
                facilityTypeId = Integer.parseInt(rs.getString("facility_type_id"));
                if (facilityTypeId == 1) {
                    name = rs.getString("facility_name");
                    area = Integer.parseInt(rs.getString("facility_area"));
                    cost = Double.parseDouble(rs.getString("facility_cost"));
                    maxPeople = Integer.parseInt(rs.getString("facility_max_people"));
                    rentTypeId = Integer.parseInt(rs.getString("rent_type_id"));


                    standardRoom = rs.getString("standard_room");
                    otherDescription = rs.getString("description_other_convenence");

                    if (rs.getString("pool_area") == null) {
                        poolArea = 0;
                    } else {
                        poolArea = Double.parseDouble(rs.getString("pool_area"));
                    }

                    if (rs.getString("number_of_floors") == null) {
                        numberFloor = 0;
                    } else {
                        numberFloor = Integer.parseInt(rs.getString("number_of_floors"));
                    }

                    facility = new Villa(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, otherDescription, poolArea, numberFloor);
                } else if (facilityTypeId == 2) {
                    name = rs.getString("facility_name");
                    area = Integer.parseInt(rs.getString("facility_area"));
                    cost = Double.parseDouble(rs.getString("facility_cost"));
                    maxPeople = Integer.parseInt(rs.getString("facility_max_people"));
                    rentTypeId = Integer.parseInt(rs.getString("rent_type_id"));
                    facilityTypeId = Integer.parseInt(rs.getString("facility_type_id"));

                    standardRoom = rs.getString("standard_room");
                    otherDescription = rs.getString("description_other_convenence");

                    if (rs.getString("number_of_floors") == null) {
                        numberFloor = 0;
                    } else {
                        numberFloor = Integer.parseInt(rs.getString("number_of_floors"));
                    }

                    facility = new House(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, otherDescription, numberFloor);
                } else {
                    name = rs.getString("facility_name");
                    area = Integer.parseInt(rs.getString("facility_area"));
                    cost = Double.parseDouble(rs.getString("facility_cost"));
                    maxPeople = Integer.parseInt(rs.getString("facility_max_people"));
                    rentTypeId = Integer.parseInt(rs.getString("rent_type_id"));
                    facilityTypeId = Integer.parseInt(rs.getString("facility_type_id"));

                    facilityFree = rs.getString("facility_free");
                    facility = new Room(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, facilityFree);
                }
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return facility;
    }

    @Override
    public void insertVilla(Villa villa) throws SQLException {
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VILLA_SQL)) {

            preparedStatement.setInt(1, villa.getId());
            preparedStatement.setString(2, villa.getName());
            preparedStatement.setInt(3, villa.getArea());
            preparedStatement.setDouble(4, villa.getCost());
            preparedStatement.setInt(5, villa.getMaxPeople());
            preparedStatement.setInt(6, villa.getRentTypeId());
            preparedStatement.setInt(7, villa.getFacilityTypeId());

            preparedStatement.setString(8, villa.getStandardRoom());
            preparedStatement.setString(9, villa.getOtherDescription());
            preparedStatement.setDouble(10, villa.getPoolArea());
            preparedStatement.setInt(11, villa.getNumberFloor());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void insertHouse(House house) throws SQLException {
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOUSE_SQL)) {

            preparedStatement.setInt(1, house.getId());
            preparedStatement.setString(2, house.getName());
            preparedStatement.setInt(3, house.getArea());
            preparedStatement.setDouble(4, house.getCost());
            preparedStatement.setInt(5, house.getMaxPeople());
            preparedStatement.setInt(6, house.getRentTypeId());
            preparedStatement.setInt(7, house.getFacilityTypeId());

            preparedStatement.setString(8, house.getStandardRoom());
            preparedStatement.setString(9, house.getOtherDescription());
            preparedStatement.setInt(10, house.getNumberFloor());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void insertRoom(Room room) throws SQLException {
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM_SQL)) {

            preparedStatement.setInt(1, room.getId());
            preparedStatement.setString(2, room.getName());
            preparedStatement.setInt(3, room.getArea());
            preparedStatement.setDouble(4, room.getCost());
            preparedStatement.setInt(5, room.getMaxPeople());
            preparedStatement.setInt(6, room.getRentTypeId());
            preparedStatement.setInt(7, room.getFacilityTypeId());

            preparedStatement.setString(8, room.getFacilityFree());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean updateVilla(Villa villa) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_VILLA_SQL);) {

            preparedStatement.setString(1, villa.getName());
            preparedStatement.setInt(2, villa.getArea());
            preparedStatement.setDouble(3, villa.getCost());
            preparedStatement.setInt(4, villa.getMaxPeople());
            preparedStatement.setInt(5, villa.getRentTypeId());
            preparedStatement.setInt(6, villa.getFacilityTypeId());

            preparedStatement.setString(7, villa.getStandardRoom());
            preparedStatement.setString(8, villa.getOtherDescription());
            preparedStatement.setDouble(9, villa.getPoolArea());
            preparedStatement.setInt(10, villa.getNumberFloor());
            preparedStatement.setInt(11, villa.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean updateHouse(House house) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HOUSE_SQL);) {

            preparedStatement.setString(1, house.getName());
            preparedStatement.setInt(2, house.getArea());
            preparedStatement.setDouble(3, house.getCost());
            preparedStatement.setInt(4, house.getMaxPeople());
            preparedStatement.setInt(5, house.getRentTypeId());
            preparedStatement.setInt(6, house.getFacilityTypeId());

            preparedStatement.setString(7, house.getStandardRoom());
            preparedStatement.setString(8, house.getOtherDescription());
            preparedStatement.setInt(9, house.getNumberFloor());
            preparedStatement.setInt(10, house.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean updateRoom(Room room) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROOM_SQL);) {

            preparedStatement.setString(1, room.getName());
            preparedStatement.setInt(2, room.getArea());
            preparedStatement.setDouble(3, room.getCost());
            preparedStatement.setInt(4, room.getMaxPeople());
            preparedStatement.setInt(5, room.getRentTypeId());
            preparedStatement.setInt(6, room.getFacilityTypeId());

            preparedStatement.setString(7, room.getFacilityFree());
            preparedStatement.setInt(8, room.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteFacility(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_FACILITY_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Facility> search(String keySearch) {
        List<Facility> facilityList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SQL)) {

            preparedStatement.setString(1, "%" + keySearch + "%");
            preparedStatement.setString(2, "%" + keySearch + "%");
            preparedStatement.setString(3, "%" + keySearch + "%");
            preparedStatement.setString(4, "%" + keySearch + "%");
            preparedStatement.setString(5, "%" + keySearch + "%");
            preparedStatement.setString(6, "%" + keySearch + "%");
            preparedStatement.setString(7, "%" + keySearch + "%");
            preparedStatement.setString(8, "%" + keySearch + "%");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("facility_id"));
                String name = rs.getString("facility_name");

                int area = Integer.parseInt(rs.getString("facility_area"));
                double cost = Double.parseDouble(rs.getString("facility_cost"));

                int maxPeople = Integer.parseInt(rs.getString("facility_max_people"));
                int rentTypeId = Integer.parseInt(rs.getString("rent_type_id"));

                int facilityTypeId = Integer.parseInt(rs.getString("facility_type_id"));

                String standardRoom = rs.getString("standard_room");
                String otherDescription = rs.getString("description_other_convenence");

                double poolArea;
                if (rs.getString("pool_area") == null) {
                    poolArea = 0;
                } else {
                    poolArea = Double.parseDouble(rs.getString("pool_area"));
                }

                int numberFloor;
                if (rs.getString("number_of_floors") == null) {
                    numberFloor = 0;
                } else {
                    numberFloor = Integer.parseInt(rs.getString("number_of_floors"));
                }

                String facilityFree = rs.getString("facility_free");

                if (facilityTypeId == 1) {
                    facilityList.add(new Villa(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, otherDescription, poolArea, numberFloor));
                } else if (facilityTypeId == 2) {
                    facilityList.add(new House(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, otherDescription, numberFloor));
                } else {
                    facilityList.add(new Room(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, facilityFree));
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return facilityList;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
