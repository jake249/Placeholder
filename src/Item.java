

public class Item {
	private String name;
	private String description;
	private String itemType;
	private int id;
	public Item() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getItemType() {
		return itemType;
	}
	
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	public String toString() {
		return "Item Name: " + name + "\n" +
				"Item Description: " + description + "\n" +
				"Item ID: " + id + "\n" +
				"Item Type: " + itemType + "\n" +
				"item Class: " + this.getClass();
		
	}
}
