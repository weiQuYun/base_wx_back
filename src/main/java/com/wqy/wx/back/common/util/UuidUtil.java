package com.wqy.wx.back.common.util;

/**
 * 成都微趣云网络科技有限公司
 *
 * @ClassName: UuidUtil
 * @Description: TODO
 * @Author licm
 * @Date 2019/12/19 23:01
 * @Version V1.0
 * @Explain : 生成19位数字组件
 **/
public class UuidUtil {

    /**
     * 获得UniqId  19位
     */
    public static long getUniqID(Long userId) {
        StringBuffer sb = new StringBuffer();
        long t = System.currentTimeMillis();
        sb.append(t);
        //产生19位的数字
        generate19WeiNumber(sb, userId);
        return Long.valueOf(sb.toString());
    }

    public static void generate19WeiNumber(StringBuffer sb, Long userId) {
        if (userId == null) {
            userId = 0L;
        }
        int len = sb.length();
        int suffixLen = 19 - len;
        String userIdStr = String.valueOf(userId);
        if (userIdStr.length() >= suffixLen) {
            sb.append(userIdStr.substring(0, suffixLen));
        } else {
            int temp = suffixLen - userIdStr.length();
            for (int i = 0; i < temp; i++) {
                sb.append("0");
            }
            sb.append(userIdStr);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            System.out.println(UuidUtil.getUniqID(Long.valueOf(i)));
        }
    }
}
