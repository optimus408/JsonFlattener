package types;

import java.util.ArrayList;
import java.util.List;

public class LineItem {

    private String id;

    private String title;

    private String category;

    private List<Attribute> attributes = new ArrayList<>();

    public static LineItem mockItem() {

        LineItem x = new LineItem();
        x.id = "L11111";
        x.title = "Test title";
        x.category = "Test categoory";

        Attribute t = new Attribute();
        t.setName("Test");
        t.setValue("TV");
        x.attributes.add(t);

        t = new Attribute();
        t.setName("Test1");
        t.setValue("TV1");

        x.attributes.add(t);

        return x;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
