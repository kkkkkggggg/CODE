package day07_exer_01;

import java.util.List;

/**
 * @acthor KKKKK
 * @creay 2021-04-23-{TIME}
 */
public class DAOTest
{
    public static void main(String[] args)
    {
        DAO<User> dao = new DAO<>();

        dao.save("1001",new User(1001,34,"123"));
        dao.save("1002",new User(1002,20,"456"));
        dao.save("1003",new User(1003,25,"789"));

        dao.upDate("1003",new User(1003,30,"101"));

        dao.delete("1002");

        List<User> list = dao.list();

//        System.out.println(list);
        list.forEach(System.out::println);

    }
}
