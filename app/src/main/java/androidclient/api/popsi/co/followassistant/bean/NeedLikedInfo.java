package androidclient.api.popsi.co.followassistant.bean;

import java.io.Serializable;

/**
 * Created by Kiven on 2017/2/27.
 */

public class NeedLikedInfo implements Serializable {

    private String imgage_url;
    private String likes_num;

    public NeedLikedInfo(String imgage_url, String likes_num) {
        this.imgage_url = imgage_url;
        this.likes_num = likes_num;
    }

    public String getImgage_url() {
        return imgage_url;
    }

    public void setImgage_url(String imgage_url) {
        this.imgage_url = imgage_url;
    }

    public String getLikes_num() {
        return likes_num;
    }

    public void setLikes_num(String likes_num) {
        this.likes_num = likes_num;
    }

    @Override
    public String toString() {
        return "NeedLikedInfo{" +
                "imgage_url='" + imgage_url + '\'' +
                ", likes_num='" + likes_num + '\'' +
                '}';
    }
}
