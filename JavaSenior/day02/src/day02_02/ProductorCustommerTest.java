package day02_02;

import java.util.Set;

/**
 * 线程通信的应用 ：经典例题：生产者/消费者问题
 *
 * 生产者(Productor)将产品交给店员(Clerk),而消费者(Custommer)从店员处取走产品，店员一次只能持有固定
 * 数量的产品(比如：20)，如果生产者试图生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品
 * 了再通知生产者继续生产：如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者
 * 来取走产品
 *
 * @acthor KKKKK
 * @creay 2021-04-14-{TIME}
 */
//public class ProductorCustommerTest
//{
//    public static void main(String[] args)
//    {
//        Custommer c = new Custommer();
//        Thread t1 = new Thread(c);
//        Thread t2 = new Thread(c);
//
//        t1.setName("客户一");
//        t2.setName("客户二");
//
//        t1.start();
//        t2.start();
//    }
//}
//
//class Product
//{
//    private static int id = 0;
//    private int productId = 0;
//    public Product()
//    {
//        id++;
//        productId = id;
//    }
//
//    public int getId()
//    {
//        return productId;
//    }
//
//}
//
//class Productor
//{
//
//
//    public static Product makeProduct()
//    {
//
//        return new Product();
//    }
//}
//
//class Clerk
//{
//    private static Product[] arr = new Product[20];
//    private static int index = 0;
//    private static int numOfProduct = 0;
//
//    public void productIn()
//    {
//        while(true)
//        {
//            synchronized(Clerk.class)
//            {
//                if(index < 20)
//                {
//                    arr[index] = Productor.makeProduct();
//                    index++;
//                    numOfProduct++;
//                }else
//                {
//                    break;
//                }
//            }
//        }
//
//    }
//
//    public Product productOut()
//    {
//        Product product = null;
//        synchronized(Clerk.class)
//        {
//            if(numOfProduct == 0)
//            {
//                notifyAll();
//            }
//
//            if(numOfProduct > 0)
//            {
//                product = arr[numOfProduct - 1];
//                arr[numOfProduct - 1] = null;
//                numOfProduct--;
//                index--;
//                try
//                {
//                    wait();
//                }catch(InterruptedException e)
//                {
//                    e.printStackTrace();
//                }
//                return product;
//
//            }else
//            {
//                productIn();
//                return arr[numOfProduct - 1];
//            }
//        }
//
//    }


//}

//class Custommer implements Runnable
//{
//    private static Clerk c = new Clerk();
//
//    @Override
//    public void run()
//    {
//        while(true)
//        {
//
//            Product product = c.productOut();
//            System.out.println(Thread.currentThread().getName() + "取走了商品,商品号是：" + product.getId());
//
//        }
//
//    }
//
//}