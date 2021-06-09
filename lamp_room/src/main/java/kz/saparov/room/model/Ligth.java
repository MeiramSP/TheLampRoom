package kz.saparov.room.model;

public class Ligth {
	
	private boolean condition;

	public boolean isCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "Ligth [condition=" + condition + "]";
	}
}
