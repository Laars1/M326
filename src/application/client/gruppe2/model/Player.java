package application.client.gruppe2.model;

public class Player {
    private String name;
    private int x;
    private int y;

    public Player(String name)
    {
        this.name = name;
    }

    public Player(String name, int initialX, int initialY)
    {
        this(name);
        x = initialX;
        y = initialY;
    }

    public boolean isYourName(String playername) {
        return name.equals(playername) ;
    }

    public void setPosition(int initialX, int initialY) {
        x = initialX;
        y = initialY;
    }
}
