package androidclient.api.popsi.co.followassistant.bean;

import java.io.Serializable;

/**
 * Created by Kiven on 2017/2/28.
 */

public class OrdersListInfo implements Serializable {

    private String getLikesNum;
    private String needCoinsNum;

    public OrdersListInfo(String getLikesNum, String needCoinsNum) {
        this.getLikesNum = getLikesNum;
        this.needCoinsNum = needCoinsNum;
    }

    public String getGetLikesNum() {
        return getLikesNum;
    }

    public void setGetLikesNum(String getLikesNum) {
        this.getLikesNum = getLikesNum;
    }

    public String getNeedCoinsNum() {
        return needCoinsNum;
    }

    public void setNeedCoinsNum(String needCoinsNum) {
        this.needCoinsNum = needCoinsNum;
    }

    @Override
    public String toString() {
        return "OrdersListInfo{" +
                "getLikesNum='" + getLikesNum + '\'' +
                ", needCoinsNum='" + needCoinsNum + '\'' +
                '}';
    }
}
