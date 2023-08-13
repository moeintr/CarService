package com.a.model.domain;

import com.a.common.type.DataBaseType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Table(name = "CAR")
@Entity(name = "car")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "carSeq", sequenceName = "car_seq", allocationSize = 1)
public class Car implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "carSeq")
    private Long carId;
    @Column(columnDefinition = DataBaseType.VARCHAR2_20)
    private String model;
    private Long personId;
}
