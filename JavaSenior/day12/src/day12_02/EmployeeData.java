package day12_02;

import java.util.ArrayList;
import java.util.List;
/**
 * �ṩ���ڲ��Ե�����
 *
 * @author shkstart ���䣺shkstart@126.com
 *
 */
public class EmployeeData {

    public static List<day12_02.Employee> getEmployees(){
        List<day12_02.Employee> list = new ArrayList<>();

        list.add(new day12_02.Employee(1001, "����", 34, 6000.38));
        list.add(new day12_02.Employee(1002, "����", 12, 9876.12));
        list.add(new day12_02.Employee(1003, "��ǿ��", 33, 3000.82));
        list.add(new day12_02.Employee(1004, "�׾�", 26, 7657.37));
        list.add(new day12_02.Employee(1005, "�����", 65, 5555.32));
        list.add(new day12_02.Employee(1006, "�ȶ��Ǵ�", 42, 9500.43));
        list.add(new day12_02.Employee(1007, "������", 26, 4333.32));
        list.add(new day12_02.Employee(1008, "���˲���", 35, 2500.32));
        list.add(new day12_02.Employee(1008, "���˲���", 35, 2500.32));

        return list;
    }

}
