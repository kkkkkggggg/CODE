package com.atck.pojo;

import java.util.List;
import java.util.Map;

/**
 * Page是分页的模型对象
 *
 * @param <T> 是具体的JavaBean类
 */
public class Page<T>
{
    public static final Integer PAGE_SIZE = 2;
    //当前页码
    private Integer pageNo;
    //总页码
    private Integer pageTotal;
    //总记录数
    private Integer pageTotalCount;
    //当前页显示数量
    private Integer pageSize = PAGE_SIZE;
    //当前页数据
    private List<T> items;
    //分页条的请求地址
    private String url;

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Integer getPageNo()
    {
        return pageNo;
    }

    public void setPageNo(Integer pageNo)
    {
        /*数据边界的有效检查*/
        if (pageNo < 1)
        {
            pageNo = 1;
        }

        if (pageNo > pageTotal)
        {
            pageNo = pageTotal;
        }

        this.pageNo = pageNo;
    }

    public Integer getPageTotal()
    {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal)
    {
        this.pageTotal = pageTotal;
    }

    public Integer getPageTotalCount()
    {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount)
    {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public List<T> getItems()
    {
        return items;
    }

    public void setItems(List<T> items)
    {
        this.items = items;
    }

    @Override
    public String toString()
    {
        return "Page{" + "pageNo=" + pageNo + ", pageTotal=" + pageTotal + ", pageTotalCount=" + pageTotalCount + ", pageSize=" + pageSize + ", items=" + items + ", url='" + url + '\'' + '}';
    }
}
