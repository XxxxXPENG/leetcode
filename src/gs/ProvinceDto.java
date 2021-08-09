package gs;

public class ProvinceDto extends Province {
    private Province[] child;

    public Province[] getChild() {
        return child;
    }

    public void setChild(Province[] child) {
        this.child = child;
    }
}
