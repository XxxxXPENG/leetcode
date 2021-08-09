package gs;//package gs;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Test {
//
//    List<Province> getProvinceDto(){
//        //使用Map再 O(N)情况下实现三级联动
//        List<Province> list = getList();
//        List<Province> res = list.stream().filter(d -> d.getParentCode().equals("")).collect(Collectors.toList());
//        List<Province> children = list.stream().filter(d -> !(d.getParentCode().equals(""))).collect(Collectors.toList());
//        //建立映射
//        Map<String,Province> map = new HashMap<>();
//
//        map.put()
//        list.forEach(d -> map.put(d.getCode(),d));
////        Set<Province> second = new HashSet<>();
////        Set<Province> third = new HashSet<>();
//        //一、一次遍历 如果发现前面的编码还没创建过，就新建，有的话就找到这个child放入子或孙
//        //我怎么在list上判断是否存在了children？
//        list.forEach(d -> {
//            if(res.contains())
//        });
//
//
//
////        //二、找到二级、三级list，  从下往上分别做好级联
////        for (Province d : children) {
////            //判断三级的父类是否添加,无则添加，再二级上创建
////            if (!second.contains( map.get(d.getParentCode()))) {
////                Province p = map.get(d.getParentCode());
////                second.add(p);
////            }
////            third.add(d);//添加三级 或者 二级
////        }
////        second.forEach(d -> d.getCode().equals( ));
//
//
//    }
//
//    /**
//     * 获取初始数据
//     * @return
//     */
//    List<Province> getList(){
//        List<Province> res = new ArrayList<>();
//        res.add(new Province("S22","","信息技术"));
//        res.add(new Province("S2201","S22","互联网"));
//        res.add(new Province("S220101","S2201","电子商务开发"));
//        res.add(new Province("S220101","S2201","电子商务运营"));
//        res.add(new Province("S44","","矿石"));
//        res.add(new Province("S4401","S44","矿石子1"));
//        res.add(new Province("S4402","S44","矿石子2"));
//        res.add(new Province("S440101","S4401","矿石子1孙"));
//        res.add(new Province("S440201","S4402","矿石子2孙"));
//        return res;
//    }
//
//
////    Map<String,Province> getTree(List<Province> list){
////        List<Province> resTemp = list.stream().filter(d -> d.getParentCode().equals("")).collect(Collectors.toList());
////        Map<String,Province> res = new HashMap<>();
////        resTemp.forEach(d -> res.put(d.getCode(),d));
////        //遍历二级、三级
////        list.forEach(d ->{
////            //假设是二级，判断父类是否创建
////            if(res.containsKey(d.getParentCode()) && res.get(d.getParentCode()).getChildren().contains(res.get("")))){
//////                continue;
////            }
////        });
////    }
//}
