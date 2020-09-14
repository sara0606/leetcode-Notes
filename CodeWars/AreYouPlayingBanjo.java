package CodeWars;

import org.apache.logging.log4j.util.Strings;

/**
 * @author kangzhe
 * @description 8 kyu
 * Are You Playing Banjo?
 * @date 2020/8/12 21:23
 */
public class AreYouPlayingBanjo {
    public static String areYouPlayingBanjo(String name) {
        // Program me!
        if(Strings.isBlank(name)){
            return " does not play banjo";
        }
        if (name.toCharArray()[0] == 'R' || name.toCharArray()[0] == 'r'){
            return name + "plays banjo";
        }else {
            return name + " does not play banjo";
        }
    }
}
