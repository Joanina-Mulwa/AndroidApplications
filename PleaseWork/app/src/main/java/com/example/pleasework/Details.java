package com.example.pleasework;

public class Details {
    String name;
    String regNo;
    String gender;
    String email;
    int id;
    int phoneNumber;

    public Details(String Name, String regNo, String gender, String email, int id, int phoneNumber){
        //constructor for initializing the variables
        this.name=Name;
        this.regNo=regNo;
        this.gender=gender;
        this.email=email;
        this.id = id;
        this.phoneNumber=phoneNumber;

    }


    public String getName() {

        return name;
    }

    public void setName(String Name){
        this.name= Name;
    }

    public String showRegNo(){
        return regNo;
    }
}
