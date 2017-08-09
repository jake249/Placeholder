package git_Placeholder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ItemList {
	private static ItemList itemList;
	private int ItemCount;
	private static Item[] items;
	
	private ItemList() {
		
	}
	
	public static ItemList getInstance() {
		if(itemList == null) {
			itemList = new ItemList();
		}
		return itemList;
	}
	
	public void setItemCount(int itemCount) {
		this.ItemCount = itemCount;
		initializeItemList();
	}
	
	private void initializeItemList() {
		this.items = new Item[this.ItemCount];
	}
	
	//LOADING IN ITEMS
	
	/*
	 * Items:
	 * 0 = itemType		(string)
	 * 1 = name			(string)
	 * 2 = description	(string)
	 * 3 = id			(int)
	 * 
	 * Weapons:
	 * 4 = damage 		(int)
	 * 5 = durability 	(int)
	 * 
	 * Food:
	 * 4 = sustenance 	(int)
	 * 
	 * Misc:
	 * Nothing yet.
	 */
	
	public void LoadInItems(String fileName) {
		String line = null;
		int i = 0;
		
		try {
			FileReader fileReader = new FileReader(fileName);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null) {
				if(i == 0) {
					System.out.println("Setting item count");
					setItemCount(Integer.parseInt(line));
				} else {
					String[] item = line.split(",");
					Item tempItem;
					switch (item[0]) {
					case "weapon":
						tempItem = new Weapon();
						break;
					case "food":
						tempItem = new Food();
						break;
					default:
						tempItem = new Item();
					}
					tempItem.setItemType(item[0]);
					tempItem.setName(item[1]);
					tempItem.setDescription(item[2]);
					tempItem.setId(Integer.parseInt(item[3]));
					if (tempItem instanceof Weapon) {
						((Weapon) tempItem).setDamage(Integer.parseInt(item[4]));
						((Weapon) tempItem).setDurability(Integer.parseInt(item[5]));
					}else if (tempItem instanceof Food) {
						((Food) tempItem).setSustenance(Integer.parseInt(item[4]));
					}
					
					items[i-1] = tempItem;
					System.out.println("Read in item " + items[i-1].getName());
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Item getItemById(int id) {
		return items[id];
	}
}
