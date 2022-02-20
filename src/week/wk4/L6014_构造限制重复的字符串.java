//package week.wk4;
//
//public class L6014_构造限制重复的字符串 {
//    public String repeatLimitedString(String s, int repeatLimit) {
//        int[] letterCount = new int[26];
//        for (char c : s.toCharArray()) {
//            letterCount[c - 'a']++;
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = letterCount.length; i >= 0; i--) {
//            int count = letterCount[i];
//            StringBuilder tmp = new StringBuilder();
//            StringBuilder left = new StringBuilder();
//            //如果超过repeat，先插入其他count,在插入left
//            while (count > 0) {
//                tmp.append('a' + i);
//                count--;
//                repeatLimit--;
//                if (repeatLimit == 0) {
//                    left ;
//                    break;
//                }
//            }
//            sb.append(tmp.toString());
//        }
//
//    }
//}
