package day16exer1;

public class Order
{
	private int orderId;
	private String orderName;
	
	public Order()
	{
		
	}
	
	public Order(int orderId,String orderName)
	{
		this.orderId = orderId;
		this.orderName = orderName;
	}
	public int getOrderId()
	{
		return orderId;
	}
	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}
	public String getOrderName()
	{
		return orderName;
	}
	public void setOrderName(String orderName)
	{
		this.orderName = orderName;
	}
	
	public boolean equals(Object obj)
	{
		if(obj == this)
		{
			return true;
		}
		
		if(obj instanceof Order)
		{
			Order order = (Order)obj;
			return this.orderId == order.orderId && this.orderName.equals(order.orderName);
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return "Order[orderId = " + orderId + ",orderName = " + orderName + "]";
	}
}
