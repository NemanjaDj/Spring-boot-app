package com.nemanja.springboot.web.Springbootapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="to_do")
public class Todo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="todoid")
    private int id;
	@ManyToOne
	@JoinColumn(name="username")
    private User user;
    @Size(min=10, message="size of description must be at least 10")
    @Column(name="descrip")
    private String desc;
    @Column(name="targetdate")
    private Date targetDate;
    @Column(name="isdone")
    private boolean isDone;
    
    // Constructors
    
    public Todo() {
    	super();
    }
    
    public Todo(User user, String desc, Date targetDate,
            boolean isDone) {
    	this.user = user;
        this.desc = desc;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }
    
    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Todo other = (Todo) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Todo [id=" + id + ", desc=" + desc + ", targetDate=" + targetDate + ", isDone=" + isDone + "]";
	}

}