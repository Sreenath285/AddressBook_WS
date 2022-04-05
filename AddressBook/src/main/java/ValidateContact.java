import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateContact {

    /***
     * created validateName method to validate name
     * @param name - passing name
     * @return
     */
    public boolean validateName(String name) {
        Pattern pattern = Pattern.compile("[A-Z]{1}[a-z]{2,}");
        Matcher matcher = pattern.matcher(name);
        boolean result = matcher.matches();
        return result;
    }

    /***
     * created validateEmail method to validate email
     * @param email - passing email
     * @return
     */
    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+([._+-]*[0-9A-Za-z]+)*[@][a-zA-Z0-9]+.[a-zA-Z]{2,}([.][a-z]{2,})?$");
        Matcher matcher = pattern.matcher(email);
        boolean result = matcher.matches();
        return result;
    }

    /***
     * created validatePhoneNumber method to validate phoneNumber
     * @param phoneNumber - passing phoneNumber
     * @return
     */
    public boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("91 [0-9]{10}");
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean result = matcher.matches();
        return result;
    }

    /***
     * created validateZipCode method to validate zipCode
     * @param zipCode - passing zipCode
     * @return
     */
    public boolean validateZipCode(String zipCode) {
        Pattern pattern = Pattern.compile("[0-9]{6}");
        Matcher matcher = pattern.matcher(zipCode);
        boolean result = matcher.matches();
        return result;
    }

    /***
     * created validateCity method to validate city
     * @param city - passing city
     * @return
     */
    public boolean validateCity(String city) {
        Pattern pattern = Pattern.compile("[A-Z][a-z]+(?:[A-Z][a-z]+)*");
        Matcher matcher = pattern.matcher(city);
        boolean result = matcher.matches();
        return result;
    }

    /***
     * created validateState method to validate state
     * @param state - passing state
     * @return
     */
    public  boolean validateState(String state) {
        Pattern pattern = Pattern.compile("[A-Z][a-z]+(?:[A-Z][a-z]+)*");
        Matcher matcher = pattern.matcher(state);
        boolean result = matcher.matches();
        return result;
    }

    /***
     * created validateAddress method to validate address
     * @param address - passing address
     * @return
     */
    public  boolean validateAddress(String address) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+([ ,._+-]*[0-9A-Za-z]+)*");
        Matcher matcher = pattern.matcher(address);
        boolean result = matcher.matches();
        return result;
    }
}
