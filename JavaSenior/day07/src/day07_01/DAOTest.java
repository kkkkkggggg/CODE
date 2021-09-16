package day07_01;

import org.junit.Test;

import java.util.List;

/**
 * @acthor KKKKK
 * @creay 2021-04-22-{TIME}
 */
public class DAOTest
{
    @Test
    public void test()
    {
        CustomerDAO dao = new CustomerDAO();

        dao.add(new Customer());

        List<Customer> list =  dao.get(0,10);
    }
}
