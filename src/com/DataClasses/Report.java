package com.DataClasses;

public abstract class Report {

    protected String name;
    protected String number;
    protected String address;
    protected String city;
    protected String state;
    protected String zip;

    public Report(){
        name = null;
        number = null;
        address = null;
        city = null;
        state = null;
        zip = null;
    }

    public Report(User toFill){
        build(toFill);
    }

    public int build(User toFill){
        //Builds the report based on the order of
        //protected data members below.
        if(toFill == null){
            return -1;
        }
        String [] toGet;
        toGet = toFill.getAll();
        if(toGet == null){
            return -1;
        }
        this.name = toGet[0];
        this.number = toGet[1];
        this.address = toGet[2];
        this.city = toGet[3];
        this.state = toGet[4];
        this.zip = toGet[5];
        return 0;
    }

    public abstract int display();
    public abstract int emptyServices();

    //change a given field in the report.
    public int changeName(String toChange){
        if(toChange == null){
            return -1;
        }
        this.name = toChange;
        return 0;
    }
    public int changeID(String toChange){
        if(toChange == null){
            return -1;
        }
        this.number = toChange;
        return 0;
    }
    public int changeAddress(String toChange){
        if(toChange == null){
            return -1;
        }
        this.address = toChange;
        return 0;
    }
    public int changeCity(String toChange){
        if(toChange == null){
            return -1;
        }
        this.city = toChange;
        return 0;
    }
    public int changeState(String toChange) {
        if(toChange == null){
            return -1;
        }
        this.state = toChange;
        return 0;
    }
    public int changeZip(String toChange){
        if(toChange == null){
            return -1;
        }
        this.zip = toChange;
        return 0;
    }

    public abstract String [] getAll();
    public String get(int toGet){
        //Return one field.
        //The number passed in is
        //0 - name
        //1 - number
        //2 - address
        //3 - city
        //4 - state
        //5 - zip
        String toReturn;
        if(toGet == 0 && name != null){
            return name;
        }
        if(toGet == 1 && number != null){
            return number;
        }
        if(toGet == 2 && address != null){
            return address;
        }
        if(toGet == 3 && city != null){
            return city;
        }
        if(toGet == 4 && state != null){
            return state;
        }
        if(toGet == 5 && zip != null){
            return zip;
        }
        else{
            return null;
        }
    }
}
