package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.RoomInfoDTO;

import java.sql.*;

public class RoomInfoFormController {

    ObservableList<RoomInfoDTO> roomInfoDto = FXCollections.observableArrayList();


    @FXML
    private Button btnReload;

    @FXML
    private TableColumn<?, ?> colAvailability;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colFloor;

    @FXML
    private TableColumn<?, ?> colMaxGuests;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colRoomId;

    @FXML
    private TableColumn<?, ?> colRoomtype;

    @FXML
    private TableView<RoomInfoDTO> tblRoomInfo;
    private ResultSet resultSet;

    @FXML
    void btnReloadOnAction(ActionEvent event) throws SQLException {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation_system", "root", "741897");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM rooms");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RoomInfoDTO roomInfoDTO = new RoomInfoDTO(
                        resultSet.getString("room_id"),
                        resultSet.getString("type"),
                        resultSet.getDouble("price_per_night"),
                        resultSet.getInt("max_guests"),
                        resultSet.getBoolean("availability"),
                        resultSet.getString("description"),
                        resultSet.getInt("floor")
                );

                roomInfoDto.add(roomInfoDTO);
            }

        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }
    }

}
