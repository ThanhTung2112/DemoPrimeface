package net.lvs.model;

public class Catalog {
    private String id;
    private String name;

    public Catalog(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Catalog() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
