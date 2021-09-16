package compare;

import org.junit.Test;

/**
 * @acthor KKKKK
 * @creay 2021-04-19-{TIME}
 */
public class Goods implements Comparable
{
    private String name;
    private Double price;

    public Goods()
    {
    }

    public Goods(String name, Double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "Goods{" + "name='" + name + '\'' + ", price=" + price + '}';
    }

    //指明商品比较大小的方式：按照价格从低到高排序,如果价格一样，按照商品名从低到高排序
    @Override
    public int compareTo(Object o)
    {
        Goods goods = (Goods)o;
        if(o instanceof Goods)
        {

            if(this.price > goods.price)
            {
                return 1;
            }else if(this.price < goods.price)
            {
                return -1;
            }else
            {
               return this.name.compareTo(goods.name);
            }
        }
      //方式二
//        return Double.compare(this.price,goods.price);
        throw new RuntimeException("传入的数据类型不一致！");
    }


}
