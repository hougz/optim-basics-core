import com.hgz.optim.util.FreeMarkerUtils;
import com.hgz.optim.util.ImageUtil;
import com.hgz.optim.vo.User;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/8/13 16:26
 */
public class FreeMarkerTest {

    public static void main(String[] args) {
        try {
            User user = new User();
            user.setName("hgz");
            user.setAge("男");
            user.setAddress("上海");
            user.setBirthday("2000-03-09");
            user.setPhoto(ImageUtil.getImageBase64String("D:\\image\\blog\\202202.png"));
            FreeMarkerUtils.generateWord(user, "E:\\模板\\User.doc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
