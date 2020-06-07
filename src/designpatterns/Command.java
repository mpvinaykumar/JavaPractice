package designpatterns;

import java.util.HashMap;
import java.util.Map;

enum CommandType {
	OIL, ELECTRICALS
}

interface CommandI {
	public abstract void execute();
}

class ChangeOilCommand implements CommandI {

	private Mechanic mechanic;

	public ChangeOilCommand(Mechanic mechanic) {
		this.mechanic = mechanic;
	}

	@Override
	public void execute() {
		mechanic.changeOil();
	}

}

class CheckElectricalsCommand implements CommandI {

	private Mechanic mechanic;

	public CheckElectricalsCommand(Mechanic mechanic) {
		this.mechanic = mechanic;
	}

	@Override
	public void execute() {
		mechanic.checkElectricals();
	}

}

class Mechanic {

	public void changeOil() {
		System.out.println("Changing oil now");
	}

	public void checkElectricals() {
		System.out.println("Checking electrical systems now");
	}

}

class Manager {

	private Map<CommandType, CommandI> commands = new HashMap<CommandType, CommandI>();

	public void addRequest(CommandType type, CommandI oilChange) {
		commands.put(type, oilChange);
	}

	public void processRequest(CommandType type) {
		commands.get(type).execute();
	}

}

public class Command {

	public static void main(String args[]) {

		Manager manager = new Manager();
		Mechanic mechanic = new Mechanic();

		CommandI oilChange = new ChangeOilCommand(mechanic);
		CommandI electricalsCheck = new CheckElectricalsCommand(mechanic);

		manager.addRequest(CommandType.OIL, oilChange);
		manager.addRequest(CommandType.ELECTRICALS, electricalsCheck);

		manager.processRequest(CommandType.OIL);
		manager.processRequest(CommandType.ELECTRICALS);

	}

}
