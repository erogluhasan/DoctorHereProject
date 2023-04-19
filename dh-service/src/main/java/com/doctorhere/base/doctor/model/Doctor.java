package com.doctorhere.base.doctor.model;

import com.doctorhere.base.doctor.DoctorSettings;
import com.doctorhere.base.entity.BaseEntity;
import com.doctorhere.base.profession.model.Profession;
import com.doctorhere.base.user.model.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "dh_doctor")
@Where(clause = "deleted = false")
public class Doctor extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private User user;

    private boolean newsletter = false;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String certificateNo;
    private String patentNo; //Tescil No
    private String graduadateSchool;

    @ManyToOne
    private Profession profession;

    private String interests;
    private String workHospital;
    private String imageUrl;
    private String videoUrl;
    private String cvUrl;
    private Boolean approved;



    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(
            name = "doctor_profession",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "profession_id"))
    private Set<Profession> doctorProfessionsSet = new HashSet();

    @OneToOne(mappedBy = "doctor", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private DoctorSettings doctorSettings;

}
