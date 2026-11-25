public class Coordinate {

    private boolean shot;
    private boolean ship;
    
    public Coordinate(boolean shot, boolean ship) {
        this.shot = shot;
        this.ship = ship;
    }

    public boolean isShot() { return shot; }
    public void setShot(boolean shot) { this.shot = shot; }

    public boolean isShip() { return ship; }
    public void setShip(boolean ship) { this.ship = ship; }

    @Override
    public String toString() {
        if (shot && ship) {
            return "X"; // Hit
        } else if (shot) {
            return "O"; // Miss
        } else if (ship) {
            return "S"; // Ship present
        } else {
            return "_"; // Empty
        }
    }

}
