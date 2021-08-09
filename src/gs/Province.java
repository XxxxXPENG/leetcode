package gs;

import java.util.List;

public class Province {
    private String code;
    private String parentCode;
    private String name;
    private List<Province> children;
    public Province() {
    }

    public Province(String code, String parentCode, String name) {
        this.code = code;
        this.parentCode = parentCode;
        this.name = name;
    }

    public List<Province> getChildren() {
        return children;
    }

    public void setChildren(List<Province> children) {
        this.children = children;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
