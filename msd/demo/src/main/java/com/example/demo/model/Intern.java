package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="interns")
public class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column(name="start_date")
    private String startDate;
    @Column(name="end_date")
    private String endDate;
//    @Column(name="date_of_birthday")
//    private String dob;
//    @Column
//    private String studies;
//    @Column
//    private boolean paid;
//    @Column
//    private float salary;
//    @Column(name="seven_card")
//    private boolean sevenCard;
//    @Column(name="meal_tk")
//    private boolean mealTickets;
//    @Column(name="game_room")
//    private boolean gameRoom;
//    @Column
//    private int schedule;
}

