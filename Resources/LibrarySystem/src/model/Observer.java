package model;

public interface Observer {
	public Inventory inventory=null;
	public abstract void update();
}
