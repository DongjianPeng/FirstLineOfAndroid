package top.murphypen.studyandroid.activity.base.value;

public class OpenViewValue<T> {
    final int id;
    final Class<T> clasz;

    public OpenViewValue(int id, Class<T> clasz) {
        this.id = id;
        this.clasz = clasz;
    }

    public int getId() {
        return id;
    }

    public Class<T> getClasz() {
        return clasz;
    }
}
