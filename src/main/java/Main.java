public class Main {

    public static void main (String[] args) {

        Smartphone s50 = new Smartphone("Samsung", "A50", "2340x1080", 6.5, 64, true, OperatingSystem.ANDROID, "9.0", "Beeline");
        Pad lenovo1 = new Pad("Lenovo", "T304", "1200х920", 10.0, 32, true, OperatingSystem.ANDROID, "7.1", false);
        EReader pocketbook = new EReader("Pocketbook", "P740", "1404х1852", 7.8, 8, true, OperatingSystem.LINUX, "LinuxPB", true, new String[]{"pdf", "epub", "fb2", "txt"});

        s50.setContacts(new String[]{"мама", "работа", "доставка пиццы"});
        s50.makePhoneCall(s50.findContact(s50.getContacts(), "мама"), 15);

        lenovo1.printDeviceInfo();
        pocketbook.getTextFormats();
    }
}
