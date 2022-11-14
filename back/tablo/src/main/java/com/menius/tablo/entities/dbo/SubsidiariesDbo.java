package com.menius.tablo.entities.dbo;

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
@Entity
@Table(name = "subsidiary")
public class SubsidiariesDbo {
    @Id
    @GeneratedValue
    private UUID subsidiaryId;
    @Column(nullable = false)
    private String subsidiaryName;
    @Column(unique = true, nullable = false)
    private String address;
    @Column(nullable = false)
    private String schedule;
    @Column(nullable = false)
    private String phoneNumber;
    @ElementCollection(targetClass = Entertainment.class)
    @JoinTable(name = "entertainments", joinColumns = @JoinColumn(name = "subsidiary_id"))
    @Column(name = "entertainment", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Entertainment> entertainments;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE} //To DO: Persis must be deleted
    )
    @JoinColumn(name = "restaurant_id")
    private RestaurantDbo restaurantDbo;
    @Enumerated(EnumType.STRING)
    private Status status;
}
