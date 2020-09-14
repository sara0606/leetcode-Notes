package CodeWars;

/**
 * @author yuanyuan
 * @description 7 kyu
 * Histogram - H1
 * @date 2020/8/20 21:38
 */
public class Dinglemouse {

//     "6|##### 5\n"+
//             "5|\n"+
//             "4|# 1\n"+
//             "3|########## 10\n"+
//             "2|### 3\n"+
//             "1|####### 7\n";
//    assertEquals(expected, Dinglemouse.histogram(new int[]{7,3,10,1,0,5}));

    public static String histogram(final int results[]) {
        StringBuilder sb = new StringBuilder();

        if (results ==null || results.length == 0) {
            return "";
        }
        for (int i = results.length - 1; i >= 0; i--) {
            sb.append(i+1);
            sb.append("|");
            StringBuilder sb_symbols = new StringBuilder();
            if (results[i] != 0){
                for (int j = 0; j < results[i]; j++) {
                    sb_symbols.append("#");
                }
                sb.append(sb_symbols);
                sb.append(" ");
                sb.append(results[i]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String histogram = histogram(new int[]{7, 3, 10, 1, 0, 5});
    }

}
