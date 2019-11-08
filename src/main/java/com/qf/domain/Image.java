package com.qf.domain;

import java.util.Arrays;

public class Image {
    private Integer errno; //错误代码，0 表示没有错误。
    private String[] data; //已上传的图片路径

    public Image(String[] data) {
        super();
        this.errno = 0;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Image{" +
                "errno=" + errno +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public Image() {
    }

    public Image(Integer errno, String[] data) {
        this.errno = errno;
        this.data = data;
    }
}
