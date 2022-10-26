package com.menius.tablo.entities;

import com.menius.tablo.entities.enms.Entertainment;
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
    private String subsidiaryPhoto;
    @Column(nullable = false)
    private String schedule;
    @ElementCollection(targetClass = Entertainment.class)
    @JoinTable(name = "entertainments", joinColumns = @JoinColumn(name = "subsidiary_id"))
    @Column(name = "entertainment", nullable = false)
    @Enumerated(EnumType.STRING)
    List<Entertainment> entertainments;
    @ManyToOne(

            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE} //To DO: Persis must be deleted
    )
    @JoinColumn(name = "restaurant_id")
    private RestaurantDbo restaurantId;
}
