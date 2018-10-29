package hopnetworks.dota2.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class OrderUniqueNum {


    public static int getOrderNo() {
        String orderNo = "";
     //   String trandNo = String.valueOf((Math.random() * 9 + 1) * 1000000);
        String sdf = new SimpleDateFormat("MMSS").format(new Date());
       // orderNo = trandNo+ sdf;
        return Integer.valueOf(sdf);
    }
}