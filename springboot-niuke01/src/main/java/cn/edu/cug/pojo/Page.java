package cn.edu.cug.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装分页相关的信息
 */

@AllArgsConstructor
@NoArgsConstructor
public class Page {
    //当前的页码
    private int current = 1;
    //显示上限
    private int limit =10;
    //数据总数（用于计算总页数）
    private int rows;
    //查询路径(用于复用分页链接）
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current>=1){
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit>=1&&limit<=100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows>=0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     * @return
     */
    public int getOffSet(){
        return (current-1)*limit;
    }

    /**
     * 获取总页数
     * @return
     */
    public int getTotal(){
        if(rows%limit==0){
            return rows/limit;
        }else {
            return rows/limit +1;
        }
    }
    /**
     * 获取当前页的起始页码，就是页面下方只显示5个页码
     */
    public int getFrom(){
        int f=current-2;
        return f<1?1:f;
    }

    /**
     * 获取结束页码
     * @return
     */
    public int getTo(){
        int to = current+2;
        int total=getTotal();
        return to>total?total:to;
    }
}


