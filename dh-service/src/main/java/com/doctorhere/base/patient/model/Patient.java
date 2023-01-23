package com.doctorhere.base.patient.model;

import com.doctorhere.base.entity.BaseEntity;
import com.doctorhere.base.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "dh_patient")
@Where(clause = "deleted = false")
public class Patient extends BaseEntity {

	private static final long serialVersionUID = -1479634900049154267L;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	private User user;

	private boolean newsletter = false;
	private String name;
	private String surname;
    private String  email;
    private String  phone;
}
