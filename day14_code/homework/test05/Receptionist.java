package com.atguigu.homework.test05;

public class Receptionist {
	private Filter filter;

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}
	
	public void recept(User u){
		if(filter == null){
			return;
		}
		filter.filterUser(u);
	}
	
}
