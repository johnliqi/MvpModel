package com.example.mvpmodel.Model;

import java.io.Serializable;

public class NewsBean implements Serializable  {/**
 * docid
 */
private String docid;
    /**
     * 标题
     */
    private String title;
    /**
     * 小内容
     */
    private String digest;
    /**
     * 图片地址
     */
    private String imgsrc;
    /**
     * 来源
     */
    private String source;
    /**
     * 时间
     */
    private String ptime;
    /**
     * TAG
     */
    private String tag;

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
//---------------------
//    作者：人与宇宙的关系
//    来源：CSDN
//    原文：https://blog.csdn.net/XiNanHeiShao/article/details/74732933
//    版权声明：本文为博主原创文章，转载请附上博文链接！

}
