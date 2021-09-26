public class Pad extends Device {
    private boolean hasKeyboard;

    public Pad(String manufacturer, String modeleName, String screenResolution, double screenSize, int memorySize,  boolean hasMemoryCardSlot, OperatingSystem operatingSystem, String version, boolean hasKeyboard) {
        super(manufacturer, modeleName, screenResolution, screenSize, memorySize,  hasMemoryCardSlot, operatingSystem, version);
        this.hasKeyboard = hasKeyboard;
        this.screenOrientation = screenOrientationType.ALBOOM;
    }

    public boolean isHasKeyboard() {
        return hasKeyboard;
    }
}