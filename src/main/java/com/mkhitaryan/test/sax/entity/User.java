//package com.mkhitaryan.test.sax.entity;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "users")
//public class User {
//    @Id
//    @Column(name = "username")
//    private String username;
//
//    @Column(name = "password")
//    private String password;
//
//    @Column(name = "enabled")
//    private byte enabled;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "username")
//    private List<Operation> operations;
//
//    public User(){}
//    public User(String username, String password, byte enabled) {
//        this.username = username;
//        this.password = password;
//        this.enabled = enabled;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public byte getEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(byte enabled) {
//        this.enabled = enabled;
//    }
//}
