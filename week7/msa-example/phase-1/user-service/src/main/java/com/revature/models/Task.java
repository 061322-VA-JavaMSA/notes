package com.revature.models;

<<<<<<< HEAD
=======
import javax.persistence.Entity;
>>>>>>> main
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD

import lombok.Data;

=======
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tasks")
>>>>>>> main
@Data
public class Task {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String description;
	@Enumerated(EnumType.STRING)
	private Status status;
}
