/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akashspringcrud.userCrud.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Akash
 */
@Entity
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
    , @NamedQuery(name = "Department.findById", query = "SELECT d FROM Department d WHERE d.id = :id")
    , @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deptid")
    private int id;
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "description")
    private String description;
    
    public Department() {
    }

    public Department(Integer id) {
        this.id = id;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }



}
