package generics.func;

import java.io.Serializable;

/**
 * Created by tools on 2018/1/17.
 */

public class ServicesBean implements Serializable {
    public String name;
    public String nameTag;
    public String moduleId;
    public int icon;
    public boolean isShow;
    public boolean isShowCornerMark;
    public String cornerMarkText;
    public String contentId;
    public String CornermarkType;
    public boolean IsAnimating;
    public String AnimationImageAssets;
    public String AnimationAssets;
    public String multilingualismId;
    public ServicesBean() {

    }

    public ServicesBean(String name, String nameTag, String moduleId,
                        boolean isShowCornerMark, boolean isShow, int icon,
                        String multilingualismId) {
        this.name = name;
        this.nameTag = nameTag;
        this.moduleId = moduleId;
        this.icon = icon;
        this.isShow = isShow;
        this.isShowCornerMark = isShowCornerMark;
        this.multilingualismId = multilingualismId;
    }

    @Override
    public String toString() {
        return "ServicesBean{" +
            "name='" + name + '\'' +
            ", nameTag='" + nameTag + '\'' +
            ", icon=" + icon +
            ", isShow=" + isShow +
            ", isShowCornerMark=" + isShowCornerMark +
            ", cornerMarkText='" + cornerMarkText + '\'' +
            ", contentId='" + contentId + '\'' +
            ", CornermarkType='" + CornermarkType + '\'' +
            ", IsAnimating='" + IsAnimating + '\'' +
            ", AnimationImageAssets='" + AnimationImageAssets + '\'' +
            ", AnimationAssets='" + AnimationAssets + '\'' +
            '}';
    }

}
