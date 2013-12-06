package com.ippon.formation.gwt.server.domain.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ippon.formation.gwt.shared.domain.entities.Plays;

@Entity(name = "Player")
@Table(name = "player")
public class PlayerEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4312165633377357234L;

    public PlayerEntity() {

    }

    public PlayerEntity(String name, int height, int weight, Date birthDay, Plays playHand, int yearTurnPro,
            Integer atpPoint, CountryEntity country) {
        this.name = name;
        this.height = height;
        this.playHand = playHand;
        this.birthDay = birthDay;
        this.weight = weight;
        this.yearTurnPro = yearTurnPro;
        this.atpPoint = atpPoint;
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date birthDay;
    private int height;
    private int weight;
    private int yearTurnPro;
    private Integer atpPoint;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COUNTRY_ID")
    private CountryEntity country;
    @Enumerated(EnumType.ORDINAL)
    private Plays playHand;

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public void setAtpPoint(Integer atpPoint) {
        this.atpPoint = atpPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setTurnedPro(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getYearTurnPro() {
        return yearTurnPro;
    }

    public void setYearTurnPro(int yearTurnPro) {
        this.yearTurnPro = yearTurnPro;
    }

    public Plays getPlayHand() {
        return playHand;
    }

    public void setPlayHand(Plays playHand) {
        this.playHand = playHand;
    }

    public Integer getAtpPoint() {
        return atpPoint;
    }

    public void setAtpPoint(int atpPoint) {
        this.atpPoint = atpPoint;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PlayerEntity other = (PlayerEntity) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        }
        else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
