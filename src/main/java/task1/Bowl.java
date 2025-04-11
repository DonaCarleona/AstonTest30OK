package task1;

public class Bowl {

    int volume;

    public void addToVolume(int add) {
        volume = volume + add;
    }

    public void getFromVolume(int add) {
        volume = volume - add;
    }

    public int getVolume() {
        return volume;
    }
}
