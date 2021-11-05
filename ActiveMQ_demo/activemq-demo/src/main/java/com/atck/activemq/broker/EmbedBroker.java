package com.atck.activemq.broker;

import org.apache.activemq.broker.BrokerService;

public class EmbedBroker
{
    public static void main(String[] args) throws Exception
    {
        //ActiveMQ也支持在vm中通信基于嵌入式的broker
        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
        //
        // int[] sum = sum(new int[]{2, 4, 6, 7, 9}, 10);
        //
        // System.out.println(sum[0] + " "  +sum[1] );


    }

    public static int[] sum(int[] nums,int target)
    {
        int[] res = new int[2];
        label1:for (int i = 0; i < nums.length; i++)
        {
            res[0] = i + 1;
            int sub_target = target - nums[i];
            System.out.println("nums[" + i + "]=" + nums[i] + "," + "sub_target=" + sub_target);
            for (int j = i + 1; j < nums.length; j++)
            {
                System.out.println("nums[" + (j) + "]=" + nums[j]);
                if (sub_target == nums[j])
                {
                    res[1] = j + 1;
                    break label1;
                }
            }
            System.out.println();
        }
        
        return res;
    }
}
