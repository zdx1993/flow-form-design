package dx.demo.flow.form.design.common;

/**
 * @description: 返回给前端的数据结构
 * @author: zhang.da.xin
 * @create: 2019-07-10 14:13
 **/


public class BackEntity<T> {
    private String code;
    private String backDesc;
    private T content;

    public BackEntity() {

    }

    public BackEntity(String code, String backDesc, T content) {
        this.code = code;
        this.backDesc = backDesc;
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBackDesc() {
        return backDesc;
    }

    public void setBackDesc(String backDesc) {
        this.backDesc = backDesc;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BackEntity{" +
                "code='" + code + '\'' +
                ", backDesc='" + backDesc + '\'' +
                ", content=" + content +
                '}';
    }
}
