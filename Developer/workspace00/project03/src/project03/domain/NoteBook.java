package project03.domain;

public class NoteBook implements Equipment
{
	private String model;
	private String price;
	
	public NoteBook()
	{
		
	}
	
	public NoteBook(String model,String price)
	{
		this.model = model;
		this.price = price;
	}
	
	public String getModel()
	{
		return model;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
	public String getPrice()
	{
		return price;
	}
	public void setPrice(String price)
	{
		this.price = price;
	}

	@Override
	public String getDescription()
	{
		// TODO Auto-generated method stub
		return model + "(" + price + ")";
	}
}