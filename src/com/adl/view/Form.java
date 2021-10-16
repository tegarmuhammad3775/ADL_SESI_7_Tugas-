package com.adl.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Form {
	
	
	public Form(){
		
	}
	
	public Form(Component component){
		addComponent(component);
	}
	
	
	private List<Component> listComponent = new ArrayList<Component>();
	
	//function untuk tambah component
	public void addComponent(Component component) {
		listComponent.add(component);
	}	
	
	//function untuk menampilkan semua component
	public void showComponents() {
		
		for (int i = 0; i < this.listComponent.size(); i++) {
			listComponent.get(i).show();
		}
	}
	
	//function untuk menampilkan component by name
	public void showComponentByName(String name) {
		for (int i = 0; i < this.listComponent.size(); i++) {
			if(listComponent.get(i).getName().equalsIgnoreCase(name)){
				listComponent.get(i).show();
			}
		}
	}

	public List<Component> getListComponent() {
		return listComponent;
	}

	public void setListComponent(List<Component> listComponent) {
		this.listComponent = listComponent;
	}

}
