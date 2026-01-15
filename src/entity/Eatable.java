package entity;

public interface Eatable {

    String emoji = "";
    Eatable createEatable(Eatable eatable);
    String getEmoji();
}
