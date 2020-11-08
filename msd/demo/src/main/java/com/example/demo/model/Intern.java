package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="interns")
public class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

//    @Column
//    private Date dob;

//    @Column
//    private String studies;

//    @Column
//    private String startDate;
//
//    @Column
//    private String endDate;
//
//    @Column
//    private boolean paid;
//
//    @Column
//    private float salary;
//
//    @Column
//    private boolean sevenCard;
//
//    @Column
//    private boolean mealTickets;
//
//    @Column
//    private boolean gameRoom;
//
//    @Column
//    private int schedule;

    public Intern() { }

//    public Intern(int id, String name, Date dob, String studies, String startDate, String endDate, boolean paid, float salary, boolean sevenCard, boolean mealTickets, boolean gameRoom, int schedule) {
//        this.id = id;
//        this.name = name;
////        this.dob = dob;
////        this.studies = studies;
//        this.startDate = startDate;
//        this.endDate = endDate;
////        this.paid = paid;
////        this.salary = salary;
////        this.sevenCard = sevenCard;
////        this.mealTickets = mealTickets;
////        this.gameRoom = gameRoom;
////        this.schedule = schedule;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Date getDob() {
//        return dob;
//    }
//
//    public void setDob(Date dob) {
//        this.dob = dob;
//    }
//
//    public String getStudies() {
//        return studies;
//    }
//
//    public void setStudies(String studies) {
//        this.studies = studies;
//    }

//    public String getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(String startDate) {
//        this.startDate = startDate;
//    }
//
//    public String getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(String endDate) {
//        this.endDate = endDate;
//    }

//    public boolean isPaid() {
//        return paid;
//    }
//
//    public void setPaid(boolean paid) {
//        this.paid = paid;
//    }
//
//    public float getSalary() {
//        return salary;
//    }
//
//    public void setSalary(float salary) {
//        this.salary = salary;
//    }
//
//    public boolean isSevenCard() {
//        return sevenCard;
//    }
//
//    public void setSevenCard(boolean sevenCard) {
//        this.sevenCard = sevenCard;
//    }
//
//    public boolean isMealTickets() {
//        return mealTickets;
//    }
//
//    public void setMealTickets(boolean mealTickets) {
//        this.mealTickets = mealTickets;
//    }
//
//    public boolean isGameRoom() {
//        return gameRoom;
//    }
//
//    public void setGameRoom(boolean gameRoom) {
//        this.gameRoom = gameRoom;
//    }
//
//    public int getSchedule() {
//        return schedule;
//    }
//
//    public void setSchedule(int schedule) {
//        this.schedule = schedule;
//    }
}
