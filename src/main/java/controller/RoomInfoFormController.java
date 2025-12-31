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

public class RoomInfoFormController {

    ObservableList<RoomInfoDTO> roomInfoDto = FXCollections.observableArrayList(
            new RoomInfoDTO("R001","A/C","500.0",2,true,"heloo java here",3),
            new RoomInfoDTO("R002","Non A/C","2500.0",4,false," java here1",4),
            new RoomInfoDTO("R003","A/C","3500.0",1,true," java here2",3),
            new RoomInfoDTO("R004","Non A/C","4500.0",5,false," java here3",3)
            );


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

    @FXML
    void btnReloadOnAction(ActionEvent event) {

        colRoomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        colRoomtype.setCellValueFactory(new PropertyValueFactory<>("type"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("pricePerNight"));
        colMaxGuests.setCellValueFactory(new PropertyValueFactory<>("maxGuest"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colFloor.setCellValueFactory(new PropertyValueFactory<>("floor"));

        tblRoomInfo.setItems(roomInfoDto);
    }

}
