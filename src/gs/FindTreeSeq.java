package gs;


import java.util.ArrayList;
import java.util.List;

public class FindTreeSeq {

   public static List<Long> findAllSeq(Tree dto) {
        List<Long> res = new ArrayList<>();
        res.add(dto.getSeq());

        //查找子树的seq
        List<Tree> children =  dto.getChildren();
//        while (children != null) {
//            for (Tree c : children) {
//                res.add(c.getSeq());
//                children = c.getChildren();
//            }
//        }

        return res;
    }


    public static void main(String[] args) {
        Tree tree = new Tree(0L);
        List<Tree> c = new ArrayList<>();
        Tree c1 = new Tree(21L);
        Tree c2 = new Tree(22L);
        c.add(c1);
        c.add(c2);
        Tree d1 = new Tree(31L);
        List<Tree> d = new ArrayList<>();
        d.add(d1);
        c1.setChildren(d);
        Tree e1 = new Tree(41L);
        List<Tree> e = new ArrayList<>();
        c2.setChildren(e);
        e.add(e1);

        tree.setChildren(c);

        System.out.println(findAllSeq(tree));
    }
}


class Tree {
    private Long seq;
    private List<Tree> children;

    public Tree() {
    }

    public Tree(Long seq) {
        this.seq = seq;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }
}