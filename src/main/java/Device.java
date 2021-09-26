import java.util.Date;

public class Device {

	private String manufacturer;
	private String modelName;
	private String screenResolution;
	private double screenSize; //в дюймах
	private int memorySizeInternal; //в гигабайтах
	private int memorySizeFull; //в гигабайтах

	private boolean hasMemoryCardSlot;
	private boolean hasMemoryCard;
	
	protected screenOrientationType screenOrientation;
	private boolean screenOrientationIsLocked;
	
	OperatingSystem operatingSystem;

	private String version;
	private String versionFull;
	
	private boolean turnedOn;
	
	public Device(String manufacturer, String modelName, String screenResolution, double screenSize, int memorySizeInternal,  boolean hasMemoryCardSlot, OperatingSystem operatingSystem, String version) {
		this.manufacturer = manufacturer;
		this.modelName = modelName;
		this.screenResolution = screenResolution;
		this.screenSize = screenSize;
		this.memorySizeInternal = memorySizeInternal;
		this.hasMemoryCardSlot =  hasMemoryCardSlot;
		this.operatingSystem = operatingSystem;
		this.version = version;
		
		switch (operatingSystem) {
			case ANDROID: 
			this.versionFull = "Android " + version; break;
			case IOS: 
			this.versionFull = "iOS " + version; break;
			case LINUX:
			this.versionFull = "Linux " + version; break;
			case WINDOWS_PHONE:
			this.versionFull = "Windows Phone " + version; break;
	}
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	public String getVersion() {
		return version;
	}

	int getMemorySizeFull() {
		return memorySizeFull;
	}

	public boolean getHasMemoryCardSlot(){
		return hasMemoryCardSlot;
	}

	public void setHasMemoryCard(boolean hasMemoryCard) {
		this.hasMemoryCard = hasMemoryCard;
	}
	
	public void setMemorySizeFull(int memorySizeCard) {
		if (hasMemoryCardSlot && hasMemoryCard) {
			this.memorySizeFull = this.memorySizeFull - memorySizeInternal + memorySizeCard;
		} else if (hasMemoryCardSlot && !hasMemoryCard) {
			this.memorySizeFull = memorySizeInternal + memorySizeCard;
		} else if (!hasMemoryCardSlot) {
			System.out.println("В устройстве отсутствует слот для карты памяти");
		}
		
	}

	public void lockScreenOrientation() {
		screenOrientationIsLocked = true;
	}

	public void unlockScreenOrientation() {
		screenOrientationIsLocked = false;
	}
	
	public void changeScreenOrientation() {
			if (screenOrientationIsLocked) {System.out.println("Ориентация залочена, снимите блокировку");}
			else if (screenOrientation == screenOrientationType.BOOK) {
			screenOrientation = screenOrientationType.ALBOOM;
			System.out.println("Ориентация изменена на альбомную");
			} else if (screenOrientation == screenOrientationType.ALBOOM) {
			screenOrientation = screenOrientationType.BOOK;
			System.out.println("Ориентация изменена на книжную");
			}
	}

	private Date startTime;
	
	public void turnOn() {
		if (!turnedOn) {
		System.out.println("Устройство включено! Можно работать");
		turnedOn = true;
			startTime = new Date();
		} else if (turnedOn) {
			System.out.println("Уже включено");
		}
	}
	
	public void turnOff() {
		if (turnedOn) {
		System.out.println("Устройство выключено!");
		turnedOn = false;
		}
	}

	int power;

//надо запускать через определенные промежутки, однако не реализовано из-за сложностей в освоении
	public int checkDevicePowerOverTime() {
		int d;
		if (!turnedOn) {System.out.println("Включите устройство чтобы узнать заряд");}
			Date currentTime = new Date();
		if (currentTime.getHours() > startTime.getHours()) {
			d = currentTime.getHours() - startTime.getHours();
		} else {d = startTime.getHours() - currentTime.getHours();}
		power = power - (d * 7);
			if (power <= 0) {
			turnOff();}
			return power;
	}
	
	public int deviceCharge() {
		while (power != 100) {power = power + 1; System.out.println("Заряжено на " + power + " %"); }
		System.out.println("Зарядка завершена");
		return power;
	}

	public void printDeviceInfo() {
		System.out.println("Информация об устройстве: " + 
			manufacturer + 
			modelName + "," +
			screenResolution + "," +
			screenSize + " дюймов" + "," + 
			memorySizeFull + " гигабайт" + "," + 
			versionFull);
	}

}


