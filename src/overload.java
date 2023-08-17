public class overload {

    public static void main(String[] args) {
//        System.out.println(convertToCentimeters(7));
//        System.out.println(convertToCentimeters(5, 7));
        getDurationString(-10);
        getDurationString(1432, 23);
    }

    public static double convertToCentimeters(int inches) {
        return inches * 2.54;
    }

    public static double convertToCentimeters(int foot, int inches) {
        int totalInches = (foot * 12) + inches;
        return convertToCentimeters(totalInches);
    }

    public static void getDurationString(int seconds) {
        boolean isParametersValid = seconds >= 0;
        if (isParametersValid) {
            int minutes = seconds / 60;
            int resSeconds = seconds % 60;
            getDurationString(minutes, resSeconds);
        } else {
            System.out.println("invalid parameters");
        }
    }
    public static void getDurationString(int minutes, int seconds) {
        boolean isParametersValid = minutes >= 0 && (seconds >= 0 && seconds <= 59);
        if (isParametersValid) {
            if (minutes >= 60) {
                int hours = minutes / 60;
                int restMinutes = minutes % 60;
                System.out.println(hours + "h" + " " + restMinutes + "m" + " " + seconds + "s");
            } else {
                System.out.println(minutes + "m" + " " + seconds + "s");

            }
        } else {
            System.out.println("invalid parameters");
        }
    }
}