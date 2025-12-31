package model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomInfoDTO {

    private String roomId;
    private String type;
    private String pricePerNight;
    private int macGuest;
    private boolean availability;
    private String description;
    private int floor;
}
