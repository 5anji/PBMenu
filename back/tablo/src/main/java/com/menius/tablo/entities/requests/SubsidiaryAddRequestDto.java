package com.menius.tablo.entities.requests;

import com.menius.tablo.entities.dbo.RestaurantDbo;
import com.menius.tablo.entities.enms.Entertainment;
import com.menius.tablo.entities.enms.Status;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubsidiaryAddRequestDto {
    private UUID restaurantId;
    private String subsidiaryName;
    private String address;
    private String schedule;
    private String phoneNumber;
    private List<Entertainment> entertainments;
    private Status status;
}