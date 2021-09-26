
public class EReader extends Device {

    private boolean EInk;
    private String[] textFormats;

    public EReader(String manufacturer, String modeleName, String screenResolution, double screenSize, int memorySize,  boolean hasMemoryCardSlot, OperatingSystem operatingSystem, String version, boolean EInk, String[] textFormats) {
        super(manufacturer, modeleName, screenResolution, screenSize, memorySize, hasMemoryCardSlot, operatingSystem, version);
        this.EInk = EInk;
        this.textFormats = textFormats;
    }

    //менять ориентацию экрана нельзя
    @Override
    public void changeScreenOrientation() {
        System.out.println("На этом устройстве доступна только ориентация экрана по умолчанию: книжная");
        }

        public String[] getTextFormats() {
        return textFormats;
    }

        public void setTextFormats(String[] textFormats) {
        this.textFormats = textFormats;
    }

        public boolean isEInk() {
            return EInk;
        }
}