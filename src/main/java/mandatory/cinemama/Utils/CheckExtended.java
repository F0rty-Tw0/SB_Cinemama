package mandatory.cinemama.Utils;

public class CheckExtended {

  public static boolean isExtended(String type) {
    boolean isExtended = false;
    if (type != null && type.equals("extended")) {
      isExtended = true;
    }
    return isExtended;
  }
}
