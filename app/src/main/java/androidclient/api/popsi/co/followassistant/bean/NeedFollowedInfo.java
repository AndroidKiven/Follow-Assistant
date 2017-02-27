package androidclient.api.popsi.co.followassistant.bean;

import java.io.Serializable;

/**
 * Created by Kiven on 2017/2/26.
 */

public class NeedFollowedInfo implements Serializable {

    private String head_url;
    private String use_name;

    public NeedFollowedInfo(String head_url, String use_name) {
        this.head_url = head_url;
        this.use_name = use_name;
    }

    public String getHead_url() {
        return head_url;
    }

    public void setHead_url(String head_url) {
        this.head_url = head_url;
    }

    public String getUse_name() {
        return use_name;
    }

    public void setUse_name(String use_name) {
        this.use_name = use_name;
    }

    @Override
    public String toString() {
        return "NeedFollowedInfo{" +
                "head_url='" + head_url + '\'' +
                ", use_name='" + use_name + '\'' +
                '}';
    }
}
