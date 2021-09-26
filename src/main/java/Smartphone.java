
class Smartphone extends Device {
    private String mobileOperator;

    //String[][] contacts;     метод должен быть двумерным, но не разобрался
    private String[] contacts;

    //первый конструктор - смартфон с симкартой
    public Smartphone(String manufacturer, String modelName, String screenResolution, double screenSize, int memorySize,  boolean hasMemoryCardSlot, OperatingSystem operatingSystem, String version, String mobileOperator) {
        super(manufacturer, modelName, screenResolution, screenSize, memorySize,  hasMemoryCardSlot, operatingSystem, version);
        this.mobileOperator = mobileOperator;
        this.screenOrientation = screenOrientationType.BOOK;
    }

    //второй конструктор - смартфон без симкарты
    public Smartphone(String manufacturer, String modelName, String screenResolution, double screenSize, int memorySize,  boolean hasMemoryCardSlot, OperatingSystem operatingSystem, String version) {
        super(manufacturer, modelName, screenResolution, screenSize, memorySize, hasMemoryCardSlot, operatingSystem, version);
        this.screenOrientation = screenOrientationType.BOOK;
    }

    public void setContacts(String[] contacts) {
        this.contacts = contacts;
    }

    public String[] getContacts() {
        return contacts;
    }

    public void setMobileOperator(String mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    public String getMobileOperator() {
        return mobileOperator;
    }

    public String findContact(String[] contacts, String name) {
        for (String c : contacts) {
            if (c == name) {
                return c;
            }
        }
        return "Ничего не нашлось!";
    }

    public void makePhoneCall(String contact, int time) {
        System.out.println("Был совершен звонок контакту " + contact + " на " + time + " минут" );
    }

    public void sendSMS(String contact) {
        System.out.println("Отправлено СМС контакту " + contact );
    }
}