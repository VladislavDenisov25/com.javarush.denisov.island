package entity;

public class Plant implements Eatable {

    @Override
    public Eatable createEatable(Eatable eatable){
        return  new Plant();
    }
}
