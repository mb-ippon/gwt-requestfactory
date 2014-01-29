package com.ippon.formation.gwt.server.domain.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
import javax.persistence.Version;

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

    public PlayerEntity(String name, Integer height, Integer weight, Date birthDay, Plays playHand,
            Integer yearTurnPro, Integer atpPoint, CountryEntity country) {
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
    private Integer height;
    private Integer weight;
    private Integer yearTurnPro;
    private Integer atpPoint;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "COUNTRY_ID")
    private CountryEntity country;
    @Enumerated(EnumType.ORDINAL)
    private Plays playHand;
    @Version
    private Integer version;

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getYearTurnPro() {
        return yearTurnPro;
    }

    public void setYearTurnPro(Integer yearTurnPro) {
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

    public void setAtpPoint(Integer atpPoint) {
        this.atpPoint = atpPoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getVersion() {
        return version;
    }

}
