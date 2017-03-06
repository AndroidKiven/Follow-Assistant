package androidclient.api.popsi.co.followassistant.bean;

import java.io.Serializable;

/**
 * Created by Kiven on 2017/3/5.
 */

public class DailyBonusInfo implements Serializable {

    private String coinsNum;
    private boolean isSigned;

    public DailyBonusInfo(String coinsNum, boolean isSigned) {
        this.coinsNum = coinsNum;
        this.isSigned = isSigned;
    }

    public String getCoinsNum() {
        return coinsNum;
    }

    public void setCoinsNum(String coinsNum) {
        this.coinsNum = coinsNum;
    }

    public boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }

    @Override
    public String toString() {
        return "DailyBonusInfo{" +
                "coinsNum='" + coinsNum + '\'' +
                ", isSigned=" + isSigned +
                '}';
    }
}
