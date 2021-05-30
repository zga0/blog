package cn.zga.blog.vo;

public class User {
    /**
     * user表主键
     */
    private Integer uid;
    /**
     * 用户显示的名称
     */
    private String screenName;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;
    /**
     * 上次登录最后活跃时间
     */
    private Integer logged;
}
